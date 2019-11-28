package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[i][0]=Integer.parseInt(st.nextToken());
			dp[i][1]=Integer.parseInt(st.nextToken());
			dp[i][2]=Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
		}
		int ans=Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(dp[N-1][i]<ans) ans=dp[N-1][i];
		}
		System.out.println(ans);
	}
}
