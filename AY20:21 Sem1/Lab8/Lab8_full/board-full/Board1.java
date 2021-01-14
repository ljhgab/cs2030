/*input
3
3 1 5
2 8 6
7 9 4
4
R 1
C 3
C 2
R 3
*/
import java.util.*;

public class Board {
    private static class Cell {
        public int value;
        public int row;
        public int col;

        public Cell(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    private static class CellComparator implements Comparator<Cell> {
        //compare two cells based on the value of the cells
        @Override
        public int compare(Cell a, Cell b) {
            if (a.value > b.value) {
                return -1;
            }
            if (a.value < b.value) {
                return 1;
            }
            return 0;
        }
    }

    private static class MagicBoard {
        //use arrays of PQ to sort the cells in each row/colomn in order
        public PriorityQueue<Cell>[] rows;
        public PriorityQueue<Cell>[] columns;
        //lazy deletion: use mark to record whether cell(i,j) is deleted
        public boolean[][] mark;

        public MagicBoard(int N, int[][] a) {
            PriorityQueue<Cell>[] rows = new PriorityQueue[N];
            PriorityQueue<Cell>[] columns = new PriorityQueue[N];

            CellComparator comparator = new CellComparator();

            for (int i = 0; i < N; i++) {
                rows[i] = new PriorityQueue<Cell>(N, comparator);
                columns[i] = new PriorityQueue<Cell>(N, comparator);
            }

            boolean[][] mark = new boolean[N][N];
        
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mark[i][j] = false;
                    rows[i].offer(new Cell(a[i][j], i, j));
                    columns[j].offer(new Cell(a[i][j], i, j));
                }
            }
        }

        //Pre-condition: currentQueue contains only cells with value from 10^-9 to 10^9, mark is a n*n array. 
        //Post-condition: Number of cells in currentQueue is not larger than its original number. 
        //Type records the query wants to get a row or col. Pos is the index of the row/col.
        public Cell findTarget(String type, int pos) {
            //System.out.println(type);
            PriorityQueue<Cell> currentQueue; 
            if (type.equals("R")) {
                currentQueue = rows[pos];
            } else {
                currentQueue = columns[pos];
            }
    
            Cell target = null;
            while (currentQueue.size() > 0) {
                Cell peak = currentQueue.poll();
                //if this cell is not deleted, delete and return it
                if (!mark[peak.row][peak.col]) {
                    mark[peak.row][peak.col] = true;
                    target = peak;
                    break;
                }
            }
            return target;
        }
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        MagicBoard board = new MagicBoard(N, a);
        int Q = sc.nextInt();
        while (Q-- > 0) {
            String type = sc.next();
            int pos = sc.nextInt();
            pos--;
            Cell target = board.findTarget(type, pos);
            if (target == null) {
                System.out.println("None");
            } else {
                System.out.println(target.value);
            }
        }
    }


    public static void main(String[] args) {
        Board runner = new Board();
        runner.run();
    }
}
