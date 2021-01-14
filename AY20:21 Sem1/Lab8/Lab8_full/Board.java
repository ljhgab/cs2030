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

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        //use arrays of PQ to sort the cells in each row/colomn in order
        PriorityQueue<Cell>[] rows = new PriorityQueue[N];
        PriorityQueue<Cell>[] columns = new PriorityQueue[N];

        CellComparator comparator = new CellComparator();

        for (int i = 0; i < N; i++) {
            rows[i] = new PriorityQueue<Cell>(N, comparator);
            columns[i] = new PriorityQueue<Cell>(N, comparator);
        }

        //lazy deletion: use mark to record whether cell(i,j) is deleted
        boolean[][] mark = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mark[i][j] = false;
                rows[i].offer(new Cell(a[i][j], i, j));
                columns[j].offer(new Cell(a[i][j], i, j));
            }
        }

        int Q = sc.nextInt();
        while (Q-- > 0) {
            String type = sc.next();
            int pos = sc.nextInt();
            pos--;
            PriorityQueue<Cell> currentQueue = (type.equals("R") ? rows[pos] : columns[pos]);
            
            Cell target = findTarget(currentQueue, mark);
            if (target == null) {
                System.out.println("None");
            } else {
                System.out.println(target.value);
            }
        }
    }

    //Pre-condition: currentQueue contains only cells with value from 1 to n, mark is a n*n array. 
    //Post-condition: Number of cells in currentQueue is not larger than its original number.   
    public Cell findTarget(PriorityQueue<Cell> currentQueue, boolean[][] mark) {
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


    public static void main(String[] args) {
        Board runner = new Board();
        runner.run();
    }
}
