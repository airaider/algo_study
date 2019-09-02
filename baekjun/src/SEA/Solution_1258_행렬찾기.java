package SEA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기 {
	static int N;
	static int [][] map;
	static LinkedList<area> ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = new LinkedList<area>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]!=0) {
						search(i,j);
						count++;
					}
				}
			}
			Collections.sort(ans);
			String result=" ";
			for (area a : ans) {
				result+=a.r+" "+a.c+" ";
			}
			System.out.println("#"+t+" "+count+result);
			
	}

}
	private static void search(int a, int b) {
		int r=1;
		int c=0;
		Queue<Point>q = new LinkedList<>();
		q.add(new Point(a,b));
		map[a][b]=0;
		while(a+1<N && map[a+1][b]!=0) {
			r++;
			map[a+1][b]=0;
			q.add(new Point(a+1,b));
			a=a+1;
		}
		while(!q.isEmpty()) {
			int size = q.size();
			c++;
			for (int i = 0; i < size; i++) {
				Point p = q.remove();
				int x = p.x;
				int y = p.y;
				if(y+1<N && map[x][y+1]!=0) {
					map[x][y+1]=0;
					q.add(new Point(x,y+1));
				}
			}
		}
		ans.add(new area(r,c));
	}
	
	
}
class area implements Comparable<area>{
	int r;
	int c;
	int sqr;
	public area(int r, int c) {
		this.r = r;
		this.c = c;
		this.sqr=r*c;
	}
	@Override
	public int compareTo(area o) {
		int a = this.sqr-o.sqr;
		if(a==0) {
			return this.r-o.r;
		}
		return a;
	}
	
	
	
}
