import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Rect {
	public int height, width;
	public Rect(int height) { this(height, 1); }
	public Rect(int height, int width) { this.height = height; this.width = width; }
	public void widen(int incr) { width += incr; }
	public String toString() { return "[" + height + "," + width + "]"; }
}

class Cake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> q = new LinkedList<>();
		int numRects = sc.nextInt();
		while (numRects-- > 0)
			q.offer(sc.nextInt());
		q.offer(0); // force computation
		sc.close();

		Stack<Rect> rects = new Stack<>(); // asc
		rects.push(new Rect(0)); // prevent empty stk
		long globalMaxArea = 0;
		while (!q.isEmpty()) {
			int currHeight = q.poll(), accumWidth = 0;
			while (rects.peek().height > currHeight) {
				int existingHeight = rects.peek().height, existingWidth = rects.pop().width;
				accumWidth += existingWidth;
				globalMaxArea = Math.max(globalMaxArea, (long)existingHeight * accumWidth);
			}
			accumWidth++; // incl curr block
			if (rects.peek().height == currHeight)
				rects.peek().width += accumWidth;
			else
				rects.push(new Rect(currHeight, accumWidth));
		}

		System.out.println(globalMaxArea);

	}
}
