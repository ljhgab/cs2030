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
        static int sum = 0;
        public Node prev;
        public Node next;
        public char c;
        public int id;
        public Node() {
            prev = next = null;
            c = '!'; id = sum; sum++;
        }
        public Node(char c) {
            prev = next = null;
            this.c = c; id = sum; sum++;
        }
        public Node(char c, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.c = c; id = sum; sum++;
        }

        public void copy(Node other) {
            prev = other.prev;
            next = other.next;
            c = other.c;
        }

        // @Override
        // public Node clone() {
        //     return new Node(c, prev, next);
        // }

        @Override
        public String toString() {
            return String.format("'%d %d %d'", (prev == null ? -1 : prev.id), id, (next == null ? -1 : next.id));
        }
    }

    public static class MyEditor {
        int iter;
        LinkedList<Character> buffer;
        Node cursor;
        MyEditor(String inp) {
            buffer = new LinkedList<>();
            cursor = new Node();
            Node u = cursor;
            for (int i = 0; i < inp.length(); i++) {
                Node v = new Node(inp.charAt(i));
                u.next = v;
                v.prev = u;
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

        public void debug() {
            System.out.println("START");
            Node u = cursor;
            while (u.prev != null)
                u = u.prev;
            while (u != null) {
                System.out.println(u);
                u = u.next;
            }
            System.out.println("END");
        }

        public void insert(char c) {
            // debug();
            Node tmp = new Node(c);
            // System.out.println(tmp);
            if (cursor.next != null) cursor.next.prev = tmp;
            tmp.next = cursor.next;
            tmp.prev = cursor;
            cursor.next = tmp;
            // debug();
            cursor = tmp;
            // System.out.println(cursor + " " + cursor.next);
        }

        public void paste() {
            for (Character c : buffer) {
                insert(c);
            }
        }

        @Override
        public String toString() {
            Node u = cursor;
            while (u.prev != null) {
                u = u.prev;
                // System.out.println(u);
            }
            // System.out.println(u);
            StringBuilder sb = new StringBuilder();
            while (u != null) {
                if (u.c != '!') sb.append(u.c);
                u = u.next;
            }
            return sb.toString();
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
        System.out.println(editor);
    }

    public static void main(String[] args) {
        Editor newEditor = new Editor();
        newEditor.run();
    }
}
