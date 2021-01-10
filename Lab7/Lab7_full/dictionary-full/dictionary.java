import java.util.*;

public class Dictionary {
    public static class Node {
        public Node right;
        public Node left;
        public char c;
        public int count;

        public Node(char c) {
            this.c = c;
            this.right = null;
            this.left = null;
            this.count = 0;
        }

    }
    public static class Tree {
        public Node root;

        public Tree() {
            Node root = new Node(' ');
            this.root = root;
        }
        public void setRoot(Node node) {
            this.root = node;
        }

        //to traverse down the tree depending on which char was added
        //pre: character must be 'a' or 'b'
        //post: will update the root node to the node that has been added
        public void nextNode(char c) {
            if (c == 'a') {
                this.root = root.left;
            } else if (c=='b'){
                this.root = root.right;
            }
        }
        
        //method to insert 'a' to the left, and 'b' to the right
        //pre: either 'a' or 'b', Node must be initialised
        //post: insert node containing 'a' or 'b' to the left or right side of the root
        public void insert(char c, Node root) {
            if (c == 'a') {
                Node b = new Node('a');
                if (root.left == null) {
                    this.root.left = b;
                    this.setRoot(b);    
                } else {
                    this.setRoot(root.left);
                }
            } else {
                if (root.right == null) {
                    Node b = new Node('b');
                    this.root.right = b;
                    this.setRoot(b);
                } else {
                    this.setRoot(root.right);
                }
            }
        }

        //to count the number of possible words in the current tree based on the current node
        public int recurse(Node root) {
            int count = 0;
            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left == null && root.right != null) {
                count += recurse(root.right) + 1;
            } else if (root.right == null && root.left != null) {
                count += recurse(root.left) + 1;
            } else {
                count += recurse(root.right) + recurse(root.left) + 1;
            } 
            return count;

        }

        //to traverse down the tree, to return the last node which marks the ending of the prefix query, to find the number of subtrees below
        //pre: takes in a String of the query, which is needed to find the number of words with that as prefix
        //post: updates the root attribute such that this.root is the last node in which the prefix ends at
        public Node traverse(String query) {
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == 'a') {
                    if (this.root.left != null) {
                        this.setRoot(root.left);
                    } else {
                        return null;
                    }
                } else {
                    if (this.root.right != null) {
                        this.setRoot(root.right);
                        continue;
                    } else {
                        return null;
                    }
                }
            }
            return this.root;
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        //initialising the tree
        Tree tree = new Tree();
        Node o = tree.root;
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            for (int j =0; j < str.length(); j++ ) {
                char next = str.charAt(j);
                tree.insert(next, tree.root);
        
            }
            tree.setRoot(o);
            
        }
    //  tree.traverse(tree.root);
    


        //traversing the tree till the last node is the end of the prefix, from there, will count number of subtrees
        for (int i = 0; i < q; i++) {
            String query = scanner.next();
            Node end = tree.traverse(query);
            if (end != null) {
                System.out.println(tree.recurse(end));
            } else {
                System.out.println(0);
            }

            tree.setRoot(o);
        }



    }

    public static void main(String args[]) {
        Dictionary runner = new Dictionary();
        runner.run();
    }
}