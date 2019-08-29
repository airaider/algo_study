package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8444_IM기출1 {

	private static int N;
	private static int[] num;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			ans = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				if(num[i]==1) {
					num[i]=0;
					for (int j = i+1; j < N; j++) {
						if((j+1)%(i+1)==0) {
							num[j]=num[j]==1?0:1;
						}
					}
					ans++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
