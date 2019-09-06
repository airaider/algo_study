package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {
	static int N,M,K;
	static int ans;
	static int map[][];
	static ArrayList<germ> micro;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int [N][N];
			ans=0;
			micro = new ArrayList<>();
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				micro.add(new germ(x, y, num, dir));
			}
			
			while(M-->0) {
				for (int i = 0, size = micro.size(); i < size; i++) {
					germ g = micro.get(i);
					switch (g.dir) {
					case 1:
						if(g.x==1) {
							g.x--;
							g.num=g.num/2;
							if(g.num==0) {
								micro.remove(i);
								size--;
								i--;
								continue;
							}
							g.dir=2;
						}else {
							g.x--;
						}
						break;
					case 2:
						if(g.x==N-2) {
							g.x++;
							g.num=g.num/2;
							if(g.num==0) {
								micro.remove(i);
								size--;
								i--;
								continue;
							}
							g.dir=1;
						}else {
							g.x++;
						}
						break;

					case 3:
						if(g.y==1) {
							g.y--;
							g.num=g.num/2;
							if(g.num==0) {
								micro.remove(i);
								size--;
								i--;
								continue;
							}
							g.dir=4;
						}else {
							g.y--;
						}
						break;

					case 4:
						if(g.y==N-2) {
							g.y++;
							g.num=g.num/2;
							if(g.num==0) {
								micro.remove(i);
								size--;
								i--;
								continue;
							}
							g.dir=3;
						}else {
							g.y++;
						}
						break;
					}
				}
				
				Collections.sort(micro);
				
				for (int i = 1, size = micro.size(); i < size; i++) {
					if(micro.get(i).x==micro.get(i-1).x && micro.get(i).y==micro.get(i-1).y) {
						micro.get(i).num+=micro.get(i-1).num;
						micro.remove(i-1);
						size--;
						i--;
					}
				}
				
			}
			for (germ g : micro) {
				ans+=g.num;
			}
			System.out.println("#"+t+" "+ans);
		}
	}

	private static class germ implements Comparable<germ>{
		int x;
		int y;
		int num;
		int dir;
		public germ(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
		@Override
		public int compareTo(germ o) {
			int a = o.x-this.x;
			int b = o.y-this.y;
			if(a==0 && b==0) return -o.num+this.num;
			if(a==0) return -b; 
			return -a;
		}
		
	}
}