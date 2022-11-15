package ch04;

import java.util.Stack;

class items {
	int x, y, dir;

	public items(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return " " + x + y + dir;
	}
}

class offsets {
	int a, b;

	public offsets() {
		// TODO Auto-generated constructor stub
	}

	public offsets(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}

/*
 * maze[][], mark[][]를 class의 private data member로 선언 main()에서는 class의 public
 * function의 호출로 미로 찾기
 */

public class MazingProblemCPP {
	enum directions {
		N, NE, E, SE, S, SW, W, NW
	};

	static offsets moves[] = new offsets[8];

	static int maze[][] = new int[100][100];
	static int mark[][] = new int[100][100];

	public static void path(int[][] maze2, int[][] mark2, int m, int p)
	// Output a path (if any) in the maze; rows is m, cols is p;
	{
		// start at (1,1)
		mark[1][1] = 1;

		Stack2 st = new Stack2(50);

		items temp = new items(p, m, p);
		temp.x = 1;
		temp.y = 1;
		temp.dir = 2;
		st.push(temp);

		while (!st.isEmpty()) // stack not empty
		{
			temp = st.pop(); // unstack
			int i = temp.x;
			int j = temp.y;
			int d = temp.dir;
			while (d < 8) // moves forward
			{
				// outFile << i << " " << j << " " << d << endl;
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				if ((g == m) && (h == p)) { // reached exit
											// output path
					System.out.println(st);

					System.out.print("the term near the exit: " + i + " " + j);

					System.out.print("exit: " + m + " " + p);

					return;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
					mark[g][h] = 1;
					// push the old temp to the stack, but the direction changes.
					// Because the neighbor in the direction of d has been checked.
					items tp = new items(1, 1, 2);
					tp.x = i;
					tp.y = j;
					tp.dir = d + 1;
					st.push(tp); // stack it
					i = g;
					j = h;
					d = 0; // moves to (g,h)
				} else
					d++; // try next direction
			}
		}
		System.out.println("no path in maze ");
	}

	public static void main(String[] args) {

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };

		for (int i = 0; i < 8; i++) {
			moves[i] = new offsets();
		}
		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;
			}
		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
		}
		path(maze, mark, 12, 14);
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
		}

	}

}