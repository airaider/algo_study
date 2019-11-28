package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1733_오목 {
	static int dir[][] = {
			{ 0, 1 },
			{ 1, 0 },
			{ -1, 1 },
			{ 1, 1 }
	};
	static int[][] map;
	static int h=19;
	static int w=19;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[21][21];
		for (int i = 1; i <= 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				if (map[i][j] == 1 || map[i][j]==2) {
					int check = map[i][j];
					if (map[i][j - 1] != check) {
						int x = i;
						int y = j;
						int cnt = 1;
						while (true) {
							int nx = x + dir[0][0];
							int ny = y + dir[0][1];
							if (nx > h || ny > w || nx < 1 || ny < 1)
								break;
							if (map[nx][ny] == check) {
								cnt++;
								x = nx;
								y = ny;
							}
							else
								break;
						}
						if (cnt == 5) {
							System.out.println(check);
							System.out.println(i +" "+ j);
							return;
						}
					}
					if (map[i - 1][j] != check) {
						int x = i;
						int y = j;
						int cnt = 1;
						while (true) {
							int nx = x + dir[1][0];
							int ny = y + dir[1][1];
							if (nx > h || ny > w || nx < 1 || ny < 1)
								break;
							if (map[nx][ny] == check) {
								cnt++;
								x = nx;
								y = ny;
							}
							else
								break;
						}
						if (cnt == 5) {
							System.out.println(check);
							System.out.println(i +" "+ j);
							return;
						}
					}
					if (map[i + 1][j - 1] != check) {
						int x = i;
						int y = j;
						int cnt = 1;
						while (true) {
							int nx = x + dir[2][0];
							int ny = y + dir[2][1];
							if (nx > h || ny > w || nx < 1 || ny < 1)
								break;
							if (map[nx][ny] == check) {
								cnt++;
								x = nx;
								y = ny;
							}
							else
								break;
						}
						if (cnt == 5) {
							System.out.println(check);
							System.out.println(i +" "+ j);
							return;
						}
					}
					if (map[i - 1][j - 1] != check) {
						int x = i;
						int y = j;
						int cnt = 1;
						while (true) {
							int nx = x + dir[3][0];
							int ny = y + dir[3][1];
							if (nx > h || ny > w || nx < 1 || ny < 1)
								break;
							if (map[nx][ny] == check) {
								cnt++;
								x = nx;
								y = ny;
							}
							else
								break;
						}
						if (cnt == 5) {
							System.out.println(check);
							System.out.println(i +" "+ j);
							return;
						}
					}
				}
			}
		}
		System.out.println(0);

	}

}