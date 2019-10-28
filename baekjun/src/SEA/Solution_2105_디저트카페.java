package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	static int N;
	static int map[][];
	static int fx,fy;
	static int ans;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans=-1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					fx=i;
					fy=j;
					visit = new boolean[101];
					visit[map[i][j]]=true;
					search(i,j,0, 0);
				}
			}
			System.out.println("#"+t+" "+ans);
			
			
			
			
		}
		
	}
	private static void search(int x, int y, int count, int dir) {
		if(x<fx && y<fy) return;
		if(count>3 && x==fx && y==fy) {
			if(count>ans) ans=count;
			return;
		}
		switch (dir) {
		case 0:
			if(x+1<N && y+1<N) {
				if(x+1==fx && y+1==fy) {
					search(x+1, y+1, count+1, 0);
				}else if(!visit[map[x+1][y+1]]) {
					visit[map[x+1][y+1]]=true;
					search(x+1, y+1, count+1, 0);
					visit[map[x+1][y+1]]=false;
				}
			}
			if(x+1<N && y-1>=0) {
				if(x+1==fx && y-1==fy) {
					search(x+1, y+1, count+1, 1);
				}else if(!visit[map[x+1][y-1]]) {
					visit[map[x+1][y-1]]=true;
					search(x+1, y-1, count+1, 1);
					visit[map[x+1][y-1]]=false;
				}
			}
			break;
		case 1:
			if(x+1<N && y-1>=0) {
				if(x+1==fx && y-1==fy) {
					search(x+1, y+1, count+1, 1);
				}else if(!visit[map[x+1][y-1]]) {
					visit[map[x+1][y-1]]=true;
					search(x+1, y-1, count+1, 1);
					visit[map[x+1][y-1]]=false;
				}
			}
			if(x-1>=0 && y-1>=0) {
				if(x-1==fx && y-1==fy) {
					search(x-1, y+1, count+1, 2);
				}else if(!visit[map[x-1][y-1]]) {
					visit[map[x-1][y-1]]=true;
					search(x-1, y-1, count+1, 2);
					visit[map[x-1][y-1]]=false;
				}
			}
			break;
		case 2:
			if(x-1>=0 && y-1>=0) {
				if(x-1==fx && y-1==fy) {
					search(x-1, y-1, count+1, 2);
				}else if(!visit[map[x-1][y-1]]) {
					visit[map[x-1][y-1]]=true;
					search(x-1, y-1, count+1, 2);
					visit[map[x-1][y-1]]=false;
				}
			}
			if(x-1>=0 && y+1<N) {
				if(x-1==fx && y+1==fy) {
					search(x-1, y+1, count+1, 3);
				}else if(!visit[map[x-1][y+1]]) {
					visit[map[x-1][y+1]]=true;
					search(x-1, y+1, count+1, 3);
					visit[map[x-1][y+1]]=false;
				}
			}
			break;
		case 3:
			if(x-1>=0 && y+1<N) {
				if(x-1==fx && y+1==fy) {
					search(x-1, y+1, count+1, 3);
				}else if(!visit[map[x-1][y+1]]) {
					visit[map[x-1][y+1]]=true;
					search(x-1, y+1, count+1, 3);
					visit[map[x-1][y+1]]=false;
				}
			}
			if(x+1<N && y+1<N) {
				if(x+1==fx && y+1==fy) {
					search(x+1, y+1, count+1, 0);
				}else if(!visit[map[x+1][y+1]]) {
					visit[map[x+1][y+1]]=true;
					search(x+1, y+1, count+1, 0);
					visit[map[x+1][y+1]]=false;
				}
			}
			break;
		default:
			break;
		}
		
	}

}
