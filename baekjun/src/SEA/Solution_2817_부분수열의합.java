package SEA;

import java.util.Scanner;

public class Solution_2817_부분수열의합 {
	static int N,K;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans=0;
			N=sc.nextInt();
			K=sc.nextInt();
			arr=new int[N];
			for (int i = 0; i < N; i++) {
				arr[i]=sc.nextInt();
			}
			for (int i = 0; i < (1<<N); i++) {
				int cnt=0;
				for (int j = 0; j < N; j++) {
					if((i&(1<<j))!=0) {
						cnt+=arr[j];
						if(cnt>K) continue;
					}
				}
				if(cnt==K) ans++;
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}
