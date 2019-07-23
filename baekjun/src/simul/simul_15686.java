package simul;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class simul_15686 {
	static int N;
	static int ch;
	static int[][] map;
	static int[][] chicken;
	static int c=0;
	static int[] visit;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("15686.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		ch=sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==2) c++;
			}
		}
		chicken = new int[c][2];
		visit = new int [c];
		c=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==2) {
					chicken[c][0]=i;
					chicken[c][1]=j;
					++c;
				}
			}
		}
		for (int i = 0; i < c; i++) {
			System.out.println(chicken[i][0]+","+chicken[i][1]);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					//System.out.println(cal(i,j));
				}
			}
		}
		System.out.println("c:"+c);
		System.out.println("ch:"+ch);
		System.out.println(combi(c,ch));
	}
	
	public static int combi(int n, int r) { 
		if(n == r || r == 0) return 1; 
		else return combi(n - 1, r - 1) + combi(n - 1, r); 
		}

	
	
	private static int cal(int x, int y) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<c;i++) {
			int di=Math.abs(chicken[i][0]-x)+Math.abs(chicken[i][1]-y);
			if(di<min) {
				min=di;
			}
		}
		return min;
		
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
