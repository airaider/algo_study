package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int past = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) past++;
			}
		}
		int time = 0;
		while (true) {
			time++;
			int cnt = 0;
			visit = new boolean[N][M];
			air(0, 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]==-1) map[i][j]=0;
					else if(map[i][j]==1) cnt++;
				}
			}
			if (cnt == 0) break;
			past = cnt;
		}
		System.out.println(time);
		System.out.println(past);
	}

	private static void air(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		visit[a][b] = true;
		while (!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = dir[i][0] + x;
				int ny = dir[i][1] + y;
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (!visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
				if (map[nx][ny] == 1) {
					map[nx][ny] = -1;
				}
			}
		}
	}
}
