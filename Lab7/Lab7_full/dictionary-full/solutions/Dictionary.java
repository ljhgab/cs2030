import java.util.*;

public class Dictionary {
	public static class Node {
		public Node left;
		public Node right;
		public int countNodes = 0;

		public Node() {
			left = right = null;
		}
	}

	private static void addString(String s, Node root) {
		Node current = root;
		for (Character c: s.toCharArray()) {
			Node nextNode = (c == 'a' ? current.left : current.right);
			if (nextNode == null) {
				nextNode = new Node();
				if (c == 'a') {
					current.left = nextNode;
				} else {
					current.right = nextNode;
				}
			}
			current = nextNode;
		}
		current.countNodes++;
	}

	private static void traverse(Node root) {
		if (root.left != null) {
			traverse(root.left);
			root.countNodes += root.left.countNodes;
		}	

		if (root.right != null) {
			traverse(root.right);
			root.countNodes += root.right.countNodes;
		}
	}

	private int count(Node root, String s) {
		Node current = root;
		for (Character c: s.toCharArray()) {
			Node nextNode = (c == 'a' ? current.left : current.right);
			if (nextNode == null) {
				return 0;
			}
			current = nextNode;
		}
		return current.countNodes;
	}


	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();

		Node root = new Node();
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			addString(s, root);
		}
		traverse(root);
		
		while (Q-- > 0) {
			String t = sc.next();
			System.out.println(count(root, t));
		}
	}

	public static void main(String[] args) {
		Dictionary runner = new Dictionary();
		runner.run();
	}
}
