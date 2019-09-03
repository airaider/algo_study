package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

	static int N, M, K;
	static int[][] A;
	static int[][] Acopy;
	static int[][] cycle;
	static int[] arr;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		A = new int[N + 1][M + 1];
		Acopy = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cycle = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cycle[i][0] = Integer.parseInt(st.nextToken());
			cycle[i][1] = Integer.parseInt(st.nextToken());
			cycle[i][2] = Integer.parseInt(st.nextToken());
		}

		arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = i;
		}
		perm(0, K);
		System.out.println(min);
	}

	private static void perm(int index, int K) {
		if(index==K) {
			for (int i = 0; i < A.length; i++) {
				Acopy[i]=A[i].clone();
			}
			for (int i = 0; i < arr.length; i++) {
				rotate(cycle[arr[i]]);
			}
			for (int i = 1; i <= N; i++) {
				int sum=0;
				for (int j = 1; j <= M; j++) {
					sum+=Acopy[i][j];
				}
				if(sum<min) min=sum;
			}
			
			return;
		}
		
		for (int i = index; i < K; i++) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			perm(index+1, K);
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		
	}

	private static void rotate(int[] cycle) {
		for (int s = cycle[2]; s > 0; s--) {
			int size = s*2;
			int r=cycle[0]-s;
			int c=cycle[1]-s;
			int temp = Acopy[r][c];
			for (int i = 0; i < size; i++) {
				Acopy[r][c]=Acopy[r+1][c];
				r++;
			}
			for (int i = 0; i < size; i++) {
				Acopy[r][c]=Acopy[r][c+1];
				c++;
			}
			for (int i = 0; i < size; i++) {
				Acopy[r][c]=Acopy[r-1][c];
				r--;
			}
			for (int i = 0; i < size; i++) {
				Acopy[r][c]=Acopy[r][c-1];
				c--;
			}
			Acopy[r][c+1]=temp;
		}
		
	}

}
