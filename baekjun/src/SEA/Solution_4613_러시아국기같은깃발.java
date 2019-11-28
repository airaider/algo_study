package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발 {
	static int N,M;
	static char[][] map;
	static int[] result;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map = new char[N][M];
			result=new int[2];
			for (int i = 0; i < N; i++) {
				map[i]=br.readLine().toCharArray();
			}
			ans=Integer.MAX_VALUE;
			combi(0,0);
			System.out.println("#"+t+" "+ans);
			
		}
	}
	private static void combi(int index, int before) {
		if(index==2) {
			color();
			return;
		}
		
		for (int i = before; i < N-1; i++) {
			result[index]=i;
			combi(index+1, i+1);
		}
	}
	private static void color() {
		int cnt=0;
		for (int i = 0; i <= result[0]; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!='W') cnt++;
			}
		}
		if(cnt>ans) return;
		for (int i = result[0]+1; i <= result[1]; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!='B') cnt++;
			}
		}
		if(cnt>ans) return;
		for (int i = result[1]+1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!='R') cnt++;
			}
		}
		if(cnt<ans) ans=cnt;
	}
}
