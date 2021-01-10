/**
 * Name         :
 * Matric. No   :
*/
import java.util.*;
import java.util.stream.IntStream; 
import java.io.*;
import java.util.StringTokenizer;

public class Companies_TL {
	public static class Node {
		public int id;
		public Node next;	

		public Node(int id) {
			this.id = id;
			next = null;
		}
	}
	public static class MyList {
		public Node head;
		public Node tail;

		public MyList() {
			head = null;
			tail = null;
		}	

		public void append(Node a) {
			if (head == null) {
				head = tail = a;
			} else {
				tail.next = a;
				tail = a;
			}
		}

		public void append(MyList b) {
			if (b.head == null) {
				return;
			}
			if (head == null) {
				this.head = b.head;
				this.tail = b.tail;
			} else {
				this.tail.next = b.head;
				this.tail = b.tail;
			}
		}

		public List<Integer> traverse() {
			List<Integer> result = new LinkedList<>();
			Node current = head;
			while (current != null) {
				result.add(current.id);
				current = current.next;
			}
			Collections.sort(result);
			return result;
		}
	} 

	private void run() {
		Scanner sc = new Scanner(System.in);
		OutputStream outputStream =System.out;
        PrintWriter out =new PrintWriter(outputStream);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<MyList> companies = new LinkedList();
		List<Boolean> isBought = new LinkedList();
		for (int i = 0; i < m; i++) {
			MyList newList = new MyList();
			companies.add(newList);
			int numberOfEngineers = sc.nextInt();
			for (int j = 0; j < numberOfEngineers; j++) {
				int id = sc.nextInt();
				newList.append(new Node(id));
			}
		}
		for (int i = 0; i < m; i++) {
			isBought.add(false);
		}
		int T = sc.nextInt();
		//System.out.println(T);
		//return;
		for (int i = 0; i < T; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			companies.get(u).append(companies.get(v));
			isBought.set(v, true);
		}

		int cntLive = 0;
		for (Boolean x: isBought) {
			if (!x) {
				++cntLive;
			}
		}
		out.println(cntLive);
		for (int i = 0; i < m; i++) {
			if (isBought.get(i)) {
				continue;
			}
			List<Integer> employees = companies.get(i).traverse();
			out.print(i + " ");
			out.print(employees.size());
			for (Integer id: employees) {
				out.print(" " + id);
			}
			out.println();
		}
		out.close();
	}

	public static void main(String args[]) {
		Companies_TL companies = new Companies_TL();
		companies.run();
	}
}
