package simul;

import java.io.IOException;
import java.util.Scanner;

public class simul_1051 {
	static int x,y;
	static int dir[][] = {
			{0,1},
			{1,0},
			{1,1}
	};
	static int stoi(String s){
		return Integer.parseInt(s);
	}
	static int ans=1;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		x=sc.nextInt();
		y=sc.nextInt();
		sc.nextLine();	
		map = new int[x][y];
		for (int i = 0; i < x; i++) {
			String st = sc.nextLine();
			for (int j = 0; j < y; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		int max = (x>y)?y:x;
		outerloop:
		for(int m=max-1;m>=1;--m) {
			for (int i = 0; i < x-m; i++) {
				for (int j = 0; j < y-m; j++) {
					check(i,j,m);
					if(ans>1) break outerloop;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	private static void check(int a, int b, int c) {
		int nx,ny,nz;
		int check=map[a][b];
		for(int i=0;i<3;i++) {
			nx=a+dir[i][0]*c;
			ny=b+dir[i][1]*c;
			if(map[nx][ny]!=check) return;
		}
		ans=(c+1)*(c+1);
		return;
		
		
	}


}
