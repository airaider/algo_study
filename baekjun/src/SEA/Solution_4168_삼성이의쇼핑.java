package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4168_삼성이의쇼핑 {
	static int N,M,P,S;
	static int arr[][];
	static int ans;
	static String line;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[M][2];
			visit = new boolean[M];
			ans=0;
			line="";
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				arr[m][0]=Integer.parseInt(st.nextToken());
				arr[m][1]=Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0,0,"");
			System.out.println("#"+t+line+" "+ans);
			
		}
	}
	private static void dfs(int index, int count, int happy,String result) {
		
		if(index==M) {
			if(happy>ans) {
				ans=happy;
				line=result;
			}
			return;
		}
		dfs(index+1,count,happy,result);
		if(count+arr[index][0]<N) {
			visit[index]=true;
			dfs(index+1,count+arr[index][0],happy+arr[index][1],result+" "+index);
		}
		
	}

}
