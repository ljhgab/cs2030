/*input
fV
2
I b
I T
L
L
R
L
*/
import java.util.*;
public class Editor {
    public static class Node {
        public Node prev;
        public Node next;
        public char c;
        public Node(char c) {
            prev = next = null;
            this.c = c;
        }
    }

    public static class MyEditor {
        int iter;
        LinkedList<Character> buffer;
        Node cursor;
        MyEditor(String inp) {
            buffer = new LinkedList<>();
            cursor = new Node('!');
            Node u = cursor;
            for (int i = 0; i < inp.length(); i++) {
                Node v = new Node(inp.charAt(i));
                u.next = v; v.prev = u;
                u = v;
            }
        }

        public void moveRight() {
            if (cursor.next == null) return;
            cursor = cursor.next;
        }

        public void moveLeft() {
            if (cursor.prev == null) return;
            cursor = cursor.prev;
        }

        public void copy(int num) {
            buffer.clear();
            Node tmp = cursor;
            for (int i = 1; i <= num; i++) {
                if (tmp.next != null) {
                    tmp = tmp.next;
                    buffer.add(tmp.c);
                } else break;
            }
        }
        public void backspace() {
            if (cursor.prev == null) return;
            if (cursor.next == null) {
                cursor = cursor.prev;
                cursor.next = null;
                return;
            }
            cursor.prev.next = cursor.next;
            cursor.next.prev = cursor.prev;
            cursor = cursor.prev;
        }

        public void insert(char c) {
            Node newNode = new Node(c);
            if (cursor.next != null) cursor.next.prev = newNode;
            newNode.next = cursor.next;
            newNode.prev = cursor;
            cursor.next = newNode;
            cursor = newNode;
        }

        public void paste() {
            for (Character c : buffer) {
                insert(c);
            }
        }

        public void doPrint() {
            Node u = cursor;
            while (u.prev != null) {
                u = u.prev;
            }
            while (u != null) {
                if (u.c != '!')System.out.print(u.c);
                u = u.next;
            }
            System.out.println();
        }
    }
    private void run() {
        Scanner in = new Scanner(System.in);
        String para = in.nextLine();
        MyEditor editor = new MyEditor(para);
        int q = in.nextInt();
        for (int i = 1; i <= q; i++) {
            String c = in.next();
            if (c.equals("R")) {
                editor.moveRight();
            } else if (c.equals("L")) {
                editor.moveLeft();
            } else if (c.equals("C")) {
                int t = in.nextInt();
                editor.copy(t);
            } else if (c.equals("P")) {
                editor.paste();
            } else if (c.equals("I")) {
                char c2 = in.next().charAt(0);
                editor.insert(c2);
            } else {
                editor.backspace();
            }
        }
        editor.doPrint();
    }

    public static void main(String[] args) {
        Editor newEditor = new Editor();
        newEditor.run();
    }
}
