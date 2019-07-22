package simul;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class simul_15686 {
	static int N;
	static int ch;
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("15686.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		ch=sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[])
			}
		}
		check();
		show();
	}
	private static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
