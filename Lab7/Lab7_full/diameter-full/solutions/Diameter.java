import java.util.*;

public class Diameter {
	public static class Node {
		public Node left;
		public Node right;
		int maxDepth;
	}

	private static int traverse(Node root) {
		root.maxDepth = 0;
		int answer = 0;
        
		if (root.left != null) {
			answer = Math.max(answer, traverse(root.left));
			root.maxDepth = Math.max(root.maxDepth, root.left.maxDepth + 1);
		}
        
		if (root.right != null) {
			answer = Math.max(answer, traverse(root.right));
			root.maxDepth = Math.max(root.maxDepth, root.right.maxDepth + 1);
		}
        //This update is useful when the root has only one child. 
		answer = Math.max(answer, root.maxDepth);
		if (root.left != null && root.right != null) {
			answer = Math.max(answer, root.left.maxDepth + root.right.maxDepth + 2);
		}
		return answer;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
		    nodes[i] = new Node();
		}
		for (int i = 1; i < N; i++) {
			int parent = sc.nextInt() - 1;
			if (nodes[parent].left == null) {
				nodes[parent].left = nodes[i];
			} else {
				nodes[parent].right = nodes[i];
			}
		}
		System.out.println(traverse(nodes[0]));
	}

	public static void main(String[] args) {
		Diameter runner = new Diameter();
		runner.run();	
	}
}
