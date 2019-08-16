package samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683 {
	static int N,M;
	static int map[][];
	static boolean visit[][];
	static int dir[][] = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int permu[];
	static ArrayList<Point> ar;
	static boolean check[];
	static int poss[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		ar = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==6) {
					visit[i][j]=true;
				}
				else if(map[i][j]!=0) {
					ar.add(new Point(i,j));
				}
			}
		}
		poss = new int[ar.size()];
		check = new boolean[ar.size()];
		permu(0);
		System.out.println();
	}
	private static void permu(int index) {
		if(index == ar.size()) {
			System.out.println(Arrays.toString(poss));
			return;
		}
		
		for (int i = 0, size= ar.size(); i < size; i++) {
			if(!check[i]) {
				check[i]=true;
				Point p = ar.get(i);
				int x=p.x;
				int y=p.y;
				switch (map[x][y]) {
				case 1:
					poss[index]=i;
					break;
				case 2:
					poss[index]=i;
					break;
				case 3:
					poss[index]=i;
					break;
				case 4:
					poss[index]=i;
					break;
				case 5:
					poss[index]=i;
					break;
				
				default:
					break;
				}
				permu(index+1);
				check[i]=false;
			}
		}
	}
}
