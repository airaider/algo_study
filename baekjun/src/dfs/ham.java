package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ham {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int N;
	static int max_cal;
	static int[][] menu;
	static int[] visit;
	static int max=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=stoi(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	        N = stoi(st.nextToken());
	        max_cal = stoi(st.nextToken());
	        menu = new int[N][2];
	        visit = new int[N];
	        for(int n=0;n<N;n++) {
	        	st = new StringTokenizer(br.readLine());
	        	menu[n][0]=stoi(st.nextToken());
	        	menu[n][1]=stoi(st.nextToken());
	        	
	        }
	        dfs(0);
	        System.out.println("#"+(t+1)+" "+max);
	        max=0;
	        
	        
	        
		}
	}
	
	
	
	
	private static void dfs(int k) {
		if(k==N) {
			int sum = 0;
			int hap = 0;
			for (int j = 0; j < N; j++) {
				if(visit[j]==1) {
					sum+=menu[j][1];
					hap+=menu[j][0];
				}
				
			}
			if(sum<=max_cal) {
				if(hap>max) max=hap;
			}
			return;
		}

		visit[k]=1;
		dfs(k+1);
		visit[k]=0;
		dfs(k+1);
		
		
		
//		if(k==N) {
//			System.out.printf("cal:%d hap:%d\n", cal, hap);
//			return;
//		}
//		for (int i = 0; i < menu.length; i++) {
//			if(visit[i]==0 && cal+menu[i][1]<=max_cal) {
//				cal+=menu[k][1];
//				hap+=menu[k][0];
//				visit[i]=1;
//				dfs(k+1);
//				visit[i]=0;
//			}
//			dfs(k+1);
//		}
//		
//		cal+=menu[k][1];
//		hap+=menu[k][0];
//		for(int i = k; i < N; i++) {
//			if(visit[i]==0 && cal+menu[i][1]<=max_cal) {
//				visit[i]=1;
//				dfs(i);
//			}
//		}
//		System.out.println(cal);
		
	}


}

/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400
*/

