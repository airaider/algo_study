package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class permu_test {

	static int stoi(String s) { return Integer.parseInt(s);}
	static int size;
	static int[] b;
	static int[] a;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		size = st.countTokens();
		a = new int[size];
		b = new int[size];
		visit = new int [size];
		for (int i = 0; i < size; i++) {
			a[i]=stoi(st.nextToken());
		}
		System.out.println(Arrays.toString(a));
		
		dfs(0);
	}

	private static void dfs(int i) {
		if(i==size) {
			for (int j = 0; j < size; j++) {
				if(visit[j]==1) {
					System.out.printf("%d ", a[j]);
				}
			}
			System.out.println();
			return;
		}

		visit[i]=1;
		dfs(i+1);
		visit[i]=0;
		dfs(i+1);
		
//		for (int j = 0; j < size; j++) {
//		if(visit[j]==0) {
//			b[i]=a[j];
//			visit[j]=1;
//			dfs(i+1);
//			visit[j]=0;
//		}
//		
//	}
		
		
	}
		

}
