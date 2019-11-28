package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17471_게리멘더링 {

	static int N;
	static int[][] map;
	static int[] power;
	static boolean[] visit;
	static boolean[] team;
	static int acnt, bcnt;
	static int edge = 0;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		power = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int J = Integer.parseInt(st.nextToken());
			for (int j = 0; j < J; j++) {
				int k = Integer.parseInt(st.nextToken())-1;
				map[i][k] = 1;
				map[k][i] = 1;
			}
		}
		visit = new boolean[N];
		ans = Integer.MAX_VALUE;
		subset(0);
		if(ans==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(ans);

	}

	private static void subset(int index) {
		if (ans == 0)
			return;
		if (index == N) {
			acnt = 0;
			bcnt = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i]) acnt++;
				else bcnt++;
			}
			if (acnt == 0 || bcnt == 0)
				return;
			if (check()) {
				int asum = 0;
				int bsum = 0;
				for (int i = 0; i < N; i++) {
					if (visit[i]) asum += power[i];
					else bsum += power[i];
				}
				int result = Math.abs(asum - bsum);
				if (result < ans)
					ans = result;
			}
			return;
		} 													                                      
		visit[index]=true;
		subset(index+1);
		visit[index]=false;
		subset(index+1);
	}

	private static boolean check() {
		if (acnt != 1) {
			team = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (visit[i])
					team[i] = true;
			}
			for (int i = 0; i < N; i++) {
				if (team[i]) {
					edge = 0;
					dfs(i);
					break;
				}
			}
			if (edge != acnt)
				return false;

		}
		if (bcnt != 1) {
			team = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (!visit[i])
					team[i] = true;
			}
			for (int i = 0; i < N; i++) {
				if (team[i]) {
					edge = 0;
					dfs(i);
					break;
				}
			}
			if (edge != bcnt)
				return false;

		}

		return true;

	}

	private static void dfs(int vertex) {
		team[vertex] = false;
		edge++;
		for (int i = 0; i < N; i++) {
			if (map[vertex][i] == 1 && team[i]) {
				dfs(i);
			}
		}

	}

}
