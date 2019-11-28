package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R,C;
	static char map[][];
	static boolean visit[];
	static int max=0;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i]=br.readLine().toCharArray();
		}
		visit = new boolean[100];
		visit[map[0][0]]=true;
		dfs(0,0,1);
		System.out.println(max);
	}
	private static void dfs(int x, int y, int cnt) {
		if(cnt>max) max=cnt;
		if(x-1>=0 && !visit[map[x-1][y]]) {
			visit[map[x-1][y]]=true;
			dfs(x-1,y,cnt+1);
			visit[map[x-1][y]]=false;
		}
		if(x+1<R && !visit[map[x+1][y]]) {
			visit[map[x+1][y]]=true;
			dfs(x+1,y,cnt+1);
			visit[map[x+1][y]]=false;
		}
		if(y-1>=0 && !visit[map[x][y-1]]) {
			visit[map[x][y-1]]=true;
			dfs(x,y-1,cnt+1);
			visit[map[x][y-1]]=false;
		}
		if(y+1<C && !visit[map[x][y+1]]) {
			visit[map[x][y+1]]=true;
			dfs(x,y+1,cnt+1);
			visit[map[x][y+1]]=false;
		}
	}

}
