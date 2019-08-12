package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1209_Sum {
	static int map[][];
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			ans=0;
			br.readLine();
			map = new int [100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int dia=0;
			int ver=0;
			int cnt=0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(i==j) dia+=map[i][j];
					cnt+=map[i][j];
					ver+=map[j][i];
				}
				ans = Math.max(ans, cnt);
				ans = Math.max(ans, dia);
				ans = Math.max(ans, ver);
				cnt=0;
				ver=0;
			}
			dia=0;
			System.out.println("#"+t+" "+ans);
		}
		
	}

}
