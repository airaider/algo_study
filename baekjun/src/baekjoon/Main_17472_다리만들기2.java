package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {

	static int N,M;
	static int mark;
	static int map[][];
	static boolean visit[][];
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int d;
	static int from, to;
	static int len;
	static int parents[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mark = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					mark++;
					color(i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					map[i][j]--;
				}
			}
		}
		ArrayList<bridge> info = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					from = map[i][j];
					if (i - 1 >= 0 && map[i - 1][j] == 0) {
						d = 0;
						to = -1;
						len = 0;
						construct(i - 1, j);
						if (to != -1 && len>=2) {
							info.add(new bridge(from, to, len));
						}
					}
					if (i + 1 < N && map[i + 1][j] == 0) {
						d = 1;
						to = -1;
						len = 0;
						construct(i + 1, j);
						if (to != -1 && len>=2) {
							info.add(new bridge(from, to, len));
						}
					}
					if (j - 1 >= 0 && map[i][j - 1] == 0) {
						d = 2;
						to = -1;
						len = 0;
						construct(i, j - 1);
						if (to != -1 && len>=2) {
							info.add(new bridge(from, to, len));
						}
					}
					if (j + 1 < M && map[i][j + 1] == 0) {
						d = 3;
						to = -1;
						len = 0;
						construct(i, j + 1);
						if (to != -1 && len>=2) {
							info.add(new bridge(from, to, len));
						}
					}

				}
			}
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		for (bridge b : info) {
			System.out.println(b.from+","+b.to+":"+b.len);
		}
		Collections.sort(info);
		parents = new int[mark];
		Arrays.fill(parents, -1);
		int ans = 0;
		int V = 0;
		for (bridge b : info) {
			if(union(b.from, b.to)) {
				ans += b.len;
				V++;
				if(V==mark-2) {
					int cnt=0;
					for (int i = 1; i < parents.length; i++) {
						if(parents[i]==-1) {
							cnt++;
							if(cnt==2) {
								System.out.println("-1");
								return;
							}
						}
					}
					System.out.println(ans);
					return;
				}
			}
		}
		System.out.println(-1);

	}

	private static boolean union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		if (ap != bp) {
			parents[bp] = ap;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] < 0) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void construct(int x, int y) {
		switch (d) {
		case 0:
			for (int i = x; i >= 0; i--) {
				if (map[i][y] != 0) {
					to = map[i][y];
					return;
				}
				len++;
			}
			break;
		case 1:
			for (int i = x; i < N; i++) {
				if (map[i][y] != 0) {
					to = map[i][y];
					return;
				}
				len++;
			}
			break;
		case 2:
			for (int i = y; i >= 0; i--) {
				if (map[x][i] != 0) {
					to = map[x][i];
					return;
				}
				len++;
			}
			break;
		case 3:
			for (int i = y; i < M; i++) {
				if (map[x][i] != 0) {
					to = map[x][i];
					return;
				}
				len++;
			}
			break;
		default:
			break;
		}

	}

	private static void color(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		map[a][b] = mark;
		while (!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = mark;
					q.add(new Point(nx, ny));
				}
			}
		}

	}

	private static class bridge implements Comparable<bridge> {
		int from;
		int to;
		int len;

		public bridge(int from, int to, int len) {
			super();
			this.from = from;
			this.to = to;
			this.len = len;
		}

		@Override
		public int compareTo(bridge o) {
			return this.len - o.len;
		}

	}

}
