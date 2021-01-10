/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Dating {
	public static class Person {
		public String name;
		public int index;

		public Person(String _name, int _index) {
			name = _name;
			index = _index;
		}
	}
	private Queue<Person> maleQueue, femaleQueue;

	private void run() {
		Scanner sc = new Scanner(System.in);
		maleQueue = new LinkedList<Person>();
		femaleQueue = new LinkedList<Person>();
		long totalWaiting = 0;
		int matchedUsers = 0;

		int T = sc.nextInt();
		for (int event = 0; event < T; ++event) {
			String type = sc.next();
			String name = sc.next();
			Person user = new Person(name, event);
			Boolean isMale = type.equals("MALE");
			Queue<Person> thisQueue = (isMale ? maleQueue: femaleQueue);
			Queue<Person> otherQueue = (isMale ? femaleQueue: maleQueue);

			if (otherQueue.isEmpty()) {
				thisQueue.offer(user);
			} else {
				Person otherPerson = otherQueue.poll();
				String maleName = (isMale ? user.name : otherPerson.name);
				String femaleName = (isMale ? otherPerson.name: user.name);
				System.out.println(maleName + " matches " + femaleName);

				totalWaiting += user.index - otherPerson.index;
				matchedUsers += 2;
			}
		}

		double averageWaitingTime = matchedUsers == 0 ? 0 : (double) totalWaiting / (double) matchedUsers;
		System.out.printf("%.2f\n", averageWaitingTime);
	}


	public static void main(String args[]) {
		Dating dating = new Dating();
		dating.run();
	}
}

