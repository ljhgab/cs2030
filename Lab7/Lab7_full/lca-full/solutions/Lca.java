import java.util.*;

public class Lca {
	public static class Node {
		public Node left;
		public Node right;
		public int value;
		public int label;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node();
			nodes[i].value = sc.nextInt();
			nodes[i].label = i;
		}

		
		//create a tree using the nodes. 		
		for (int i = 1; i < n; i++) {
			String type = sc.next();
			int p = sc.nextInt() - 1;
			int u = sc.nextInt() - 1;
			if (type.equals("L")) {
				nodes[p].left = nodes[u];
			} else {
				nodes[p].right = nodes[u];
			}
		}


		while (q-- > 0) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			//make sure that nodes[u] <= nodes[v]
			if (nodes[u].value > nodes[v].value) {
				int temp = u;
				u = v;
				v = temp;
			}

			Node current = nodes[0];
			while (true) {
				if (current.value > nodes[u].value && current.value < nodes[v].value) {
					break;
				}
				if (current.label == nodes[u].label || current.label == nodes[v].label) {
					break;
				}
				if (current.value > nodes[v].value) {
					current = current.left;
				} else {
					current = current.right;
				}
			}

			System.out.println(current.label + 1);
		}
	}

	public static void main(String[] args) {
		Lca runner = new Lca();
		runner.run();
	}
}
