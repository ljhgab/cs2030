/*input
UncleG
9
R
C 6
P
R
C 2
P
I A
L
B
*/
import java.util.*;
public class Editor {
    public static class MyEditor {
        int iter;
        LinkedList<Character> para;
        List<Character> buffer;
        MyEditor(String inp) {
            para = new LinkedList<Character>();
            buffer = new ArrayList<Character>();
            for (int i = 0; i < inp.length(); i++)
                this.para.add(inp.charAt(i));
            iter = 0;
        }

        public void moveRight() {
            iter = Math.min(iter + 1, para.size());
        }
        public void moveLeft() {
            iter = Math.max(iter - 1, 0);
        }
        public void copy(int num) {
            buffer = new ArrayList<>(para.subList(iter, Math.min(iter + num, para.size())));
        }

        public void backspace() {
            if (iter == 0) return;
            iter--;
            para.remove(iter);
            // System.out.println(this);
        }

        public void insert(char c) {
            para.add(iter, c);
            iter++;
            // System.out.println(this);
        }

        public void paste() {
            for (int i = buffer.size() - 1; i >= 0; i--) {
                para.add(iter, buffer.get(i));
            }
            iter += buffer.size();
            buffer.clear();
            // System.out.println(this);
        }

        @Override
        public String toString() {
            List<Character> answer = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (Character ch : para) sb.append(ch);
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
