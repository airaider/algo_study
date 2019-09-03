package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2651_자동차경주대회 {
	static int one;
	static int N;
	static int dis[];
	static int time[];
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		one = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		dis = new int[N+1];
		time = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i <= N; i++) {
			dis[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			time[i]=Integer.parseInt(st.nextToken());
		}
		dfs(1,one-dis[0]);
		
	}
	private static void dfs(int travel, int left) {
		if(travel==N) {
			for (int i = 0; i <= N; i++) {
				if(visit[i]) System.out.print(i);
			}
			System.out.println();
			return;
		}
		
		if(left-dis[travel]>=0) {
			dfs(travel+1, left-dis[travel]);
		}
		
		visit[travel]=true;
		dfs(travel+1, one);
		
		
		
		
		
	}
}
