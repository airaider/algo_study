package SEA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러 {
	static int N;
	static boolean visit[];
	static Point[] worm;
	static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			worm = new Point[N];
			ans = Long.MAX_VALUE;
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				worm[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			pick(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void pick(int index, int before) {
		if (ans == 0)
			return;
		if (index == N / 2) {
			trace();
			return;
		}

		for (int i = before; i < N; ++i) {
			visit[i] = true;
			pick(index + 1, i + 1);
			visit[i] = false;
		}

	}

	private static void trace() {
		long sumx = 0, sumy = 0;
		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				sumx += worm[i].x;
				sumy += worm[i].y;
			} else {
				sumx -= worm[i].x;
				sumy -= worm[i].y;
			}
		}
		long D = sumx * sumx + sumy * sumy;
		ans = Math.min(D, ans);
	}

}
