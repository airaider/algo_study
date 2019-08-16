package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486_장훈이의높은선반 {
	static int N,B;
	static int[] arr;
	static boolean[] visit;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			min= Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			visit = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			permu(0);
			System.out.println("#"+t+" "+min);
		}
	}

	private static void permu(int index) {
		if(index == N) {
			int sum=0;
			for (int i = 0; i < N; i++) {
				if(visit[i]) {
					sum+=arr[i];
				}
			}
			if(sum>=B) {
				min=Math.min(min,Math.abs(B-sum));
			}
			return;
		}
		visit[index]=true;
		permu(index+1);
		visit[index]=false;
		permu(index+1);

		
	}

}
