package SEA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static int N;
	static int [][] map;
	static int [] poss;
	static boolean[][] check;
	static ArrayList<Point> ar;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			ar = new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(i==0 || j==0) {
							check[i][j]=true;						}
						else{
							ar.add(new Point(i,j));
							check[i][j]=true;						}
						}
					}
				}
			}
			poss = new int[ar.size()];
			dfs(0,0,0);
		
			
			
			
		}
	private static void dfs(int index, int line, int connect) {
		
		
		
		
	}
	
	

}
