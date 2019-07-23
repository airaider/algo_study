package simul;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class simul_15686 {
	static int N;
	static int cmax;
	static int[][] map;
	static int[][] chicken;
	static int c=0;
	static int[] visit;
	static int street = Integer.MAX_VALUE;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		cmax=sc.nextInt();
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
		combi(0,0);
		System.out.println(street);
	}
	
	public static void combi(int i, int v) { 
		if(i==c || v==cmax) {
			int sum=0;
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if(map[a][b]==1) {
						sum+=cal(a,b);
					}
				}
			}
			if(sum<street) street=sum;
			return;
		}
		visit[i]=1;
		if(i+1==c && v+1==cmax-1) return;
		combi(i+1,v+1);
		visit[i]=0;
		if(i+1==c) return;
		combi(i+1,v);
	}

	
	
	private static int cal(int x, int y) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<c;i++) {
			if(visit[i]==1) {
				int di=Math.abs(chicken[i][0]-x)+Math.abs(chicken[i][1]-y);
				if(di<min) {
					min=di;
				}
			}
			
		}
		return min;
		
	}
	
	
}
