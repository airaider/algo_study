package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14863_서울에서경산까지 {
	static int N,K;
	static boolean visit[];
	static int[][] trip;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		trip = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			trip[i][0] = a;
			trip[i][1] = b;
			trip[i][2] = c;
			trip[i][3] = d;
		}
		visit = new boolean[N];
		subset(0);
		System.out.println(ans);
	}

	private static void subset(int index) {
		if(index==N) {
			int money = 0;
			int time = 0;
			for (int i = 0; i < N; i++) {
				if(visit[i]) {
					time+=trip[i][0];
					money+=trip[i][1];
				}else {
					time+=trip[i][2];
					money+=trip[i][3];
				}
				if(time>K) return;
			}
			if(money>ans) ans = money;
			return;
		}
		visit[index]=true;
		subset(index+1);
		visit[index]=false;
		subset(index+1);
		
	}

}
