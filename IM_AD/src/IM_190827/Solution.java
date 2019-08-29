package IM_190827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,M,K;
	static int dir[][] = {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int ans;
	static int map [][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int lx = Integer.parseInt(st.nextToken());
				int ly = Integer.parseInt(st.nextToken());
				int rx = Integer.parseInt(st.nextToken());
				int ry = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				if(color==0) continue;
				boolean flag = false;
				paint:
				for (int i = lx; i <= rx; i++) {
					for (int j = ly; j <= ry; j++) {
						if(map[i][j]>color) {
							flag=true;
							break paint;
						}
					}
				}
				if(flag) continue;
				for (int i = lx; i <= rx; i++) {
					for (int j = ly; j <= ry; j++) {
						map[i][j]=color;
					}
				}
				
			}
			int cnt[] = new int[11];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					cnt[map[i][j]]++;
				}
			}
			for (int i : cnt) {
				if(i>ans) ans = i;
			}
			System.out.println("#"+t+" "+ans);
			
		}
		
		
	}
	

}

