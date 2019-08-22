package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.awt.Point;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int N; 
	static int[][] map;
	static int M, size;
	static boolean visit[];
	static int ans=Integer.MAX_VALUE;
	static ArrayList<Point> cloc = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		int a;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a=Integer.parseInt(st.nextToken());
				map[i][j]=a;
				if(a==2) {
					cloc.add(new Point(i,j));
				}
			}
		}
		size = cloc.size();
		visit = new boolean [size];
		combi(0, 0);
		System.out.println(ans);
		
		
	}

	private static void combi(int before, int index) {
		if(index == M) {
			spread();
			return;
		}
		for (int i = before; i < size; i++) {
			if(!visit[i]) {
				visit[i]=true;
				combi(i, index+1);
				visit[i]=false;
			}
		}
	}

	private static void spread() {
		int street=0;
		int min=0;
		int cdis=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					min=Integer.MAX_VALUE;
					for (int k = 0; k < size; k++) {
						if(visit[k]) {
							cdis=0;
							Point p = cloc.get(k);
							cdis=Math.abs(i-p.x)+Math.abs(j-p.y);
							if(cdis<min) min = cdis;
						}
					}
					street+=min;
				}
			}
		}
		if(street<ans) ans = street;
		
		
	}

}
