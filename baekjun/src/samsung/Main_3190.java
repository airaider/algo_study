package samsung;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_3190 {
	static int map[][];
	static int N,K,L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		map = new int[N][N];
		K=sc.nextInt();
		for (int i = 0; i < K; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			map[x][y]=1;
		}
		L=sc.nextInt();
		ArrayList<Point> move = new ArrayList<Point>();
		for (int i = 0; i < L; i++) {
			int x=sc.nextInt();
			int y=sc.nextByte();
			move.add(new Point(x,y));
		}
		System.out.println();
	}

}
