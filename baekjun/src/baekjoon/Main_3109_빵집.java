package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int N, M;
	static char map[][];
	static boolean flag;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			flag=false;
			pass(i, 0);
		}
		System.out.println(ans);
	}

	private static void pass(int x, int y) {
		if(flag) return;
		if(y==M-1) {
			flag=true;
			ans++;
			return;
		}
		if (x - 1 >= 0 && y + 1 < M && map[x - 1][y + 1] == '.') {
			map[x - 1][y + 1] = 'x';
			pass(x - 1, y + 1);
			if(flag) return;
		}
		if (y + 1 < M && map[x][y + 1] == '.') {
			map[x][y + 1] = 'x';
			pass(x, y + 1);
			if(flag) return;
		}
		if (x + 1 < N && y + 1 < M && map[x + 1][y + 1] == '.') {
			map[x + 1][y + 1] = 'x';
			pass(x + 1, y + 1);
			if(flag) return;
		}
	}

}
