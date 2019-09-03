package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int predict=-1;
		int fa = 0,ra=0;
		int[] cake = new int[L+1];
		int count[] = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if((b-a+1)>predict) {
				predict=(b-a+1);
				fa=i;
			}
			for (int j = a; j <= b; j++) {
				if(cake[j]==0) {
					cake[j]=i;
					count[cake[j]]++;
				}
			}
			
		}
		int max=0;
		for (int i = 0; i <=N ; i++) {
			if(count[i]>max) {
				max=count[i];
				ra=i;
			}
		}
		System.out.println(fa);
		System.out.println(ra);
		
		
	}

}
