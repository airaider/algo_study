package jungol;

import java.util.Scanner;

public class Main_2074_홀수마방진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		int limit=N*N;
		int cnt=1;
		int x=0;
		int y=N/2;
		map[x][y]=cnt;
		while(cnt<limit) {
			if(cnt%N==0) {
				x=x+1>=N?0:x+1;
			}else {
				x=x-1<0?N-1:x-1;
				y=y-1<0?N-1:y-1;
			}
			map[x][y]=++cnt;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
