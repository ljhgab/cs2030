/**
 * Name         :
 * Matric. No   :
*/
import java.util.*;
import java.util.stream.IntStream; 
import java.io.*;
import java.util.StringTokenizer;


public class Companies {
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

		public ArrayList<Integer> traverse() {
			ArrayList<Integer> result = new ArrayList<>();
			Node current = head;
			while (current != null) {
				result.add(current.id);
				current = current.next;
			}
			return result;
		}
	} 

	private void run() {
		Scanner sc = new Scanner(System.in);
		OutputStream outputStream = System.out;
        PrintWriter out =new PrintWriter(outputStream);
		int n = sc.nextInt();
		int m = sc.nextInt();
		MyList[] companies = new MyList[m];
		for (int i = 0; i < m; i++) {
			companies[i] = new MyList();
		}
		for (int i = 0; i < m; i++) {
			int numberOfEngineers = sc.nextInt();
			for (int j = 0; j < numberOfEngineers; j++) {
				int id = sc.nextInt();
				companies[i].append(new Node(id));
			}
		}
		boolean[] isBought = new boolean[m];
		for (int i = 0; i < m; i++) {
			isBought[i] = false;
		}
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			companies[u].append(companies[v]);
			isBought[v] = true;
		}

		int cntLive = IntStream.range(0, m).map(i -> isBought[i] ? 0 : 1).sum();
		out.println(cntLive);
		for (int i = 0; i < m; i++) {
			if (isBought[i]) {
				continue;
			}
			ArrayList<Integer> employees = companies[i].traverse();
			Collections.sort(employees);
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
		Companies companies = new Companies();
		companies.run();
	}
}
