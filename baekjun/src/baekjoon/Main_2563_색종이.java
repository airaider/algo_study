package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		int ans=0;
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a; j < a+10 ; j++) {
				for (int j2 = b; j2 < b+10; j2++) {
					if(map[j][j2]==0) {
						map[j][j2]=1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
