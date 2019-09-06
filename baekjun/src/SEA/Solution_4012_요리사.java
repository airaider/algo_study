package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N;
	static int map[][];
	static int ans;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans=Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			visit = new boolean[N];
			combi(0,0);
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void combi(int index, int before) {
		if(index==N/2) {
			calcu();
			return;
		}
		
		for (int i = before; i < N; i++) {
			visit[i]=true;
			combi(index+1, i+1);
			visit[i]=false;
		}
	}
	private static void calcu() {
		int a[] = new int[N];
		int b[] = new int[N];
		int ax=0;
		int bx=0;
		for (int i = 0; i < N; i++) {
			if(visit[i]) {
				a[ax]=i;
				ax++;
			}else {
				b[bx]=i;
				bx++;
			}
		}
		int suma=0;
		int sumb=0;
		for (int i = 0; i < N/2-1; i++) {
			for (int j = i+1; j < N/2; j++) {
				suma+=map[a[i]][a[j]];
				suma+=map[a[j]][a[i]];
				sumb+=map[b[i]][b[j]];
				sumb+=map[b[j]][b[i]];
			}
		}
		ans = Math.min(ans, Math.abs(suma-sumb));
	}

}
