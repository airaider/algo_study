package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	static boolean visit[];
	static int map[][];
	static int ans=0;
	static int C,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		map = new int [C+1][C+1];
		visit = new boolean[C+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b]=map[b][a]=1;
		}
		dfs(1);
		System.out.println(ans);
	}
	private static void dfs(int i) {
		visit[i]=true;
		for (int j = 1; j <= C ; j++) {
			if(map[i][j]!=0 && !visit[j]) {
				ans++;
				dfs(j);
			}
		}
	}
}
