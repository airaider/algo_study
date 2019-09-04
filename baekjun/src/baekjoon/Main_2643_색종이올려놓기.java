package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2643_색종이올려놓기 {
	static int N;
	static int[][] paper;
	static int ans=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a>b) {
				paper[i][0] = a;
				paper[i][1] = b;
			}else {
				paper[i][0] = b;
				paper[i][1] = a;
			}
		}
		Arrays.sort(paper, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int a = -o1[0]+o2[0];
				return a==0?-o1[1]+o2[1]:a;
			}
		});
		dfs(0,Integer.MAX_VALUE,Integer.MAX_VALUE,0);
		System.out.println(ans);
		
	}
	private static void dfs(int index, int x, int y, int cnt) {
		if(N-index+cnt<ans) return;
		
		if(index==N) {
			if(cnt>ans) ans = cnt;
			return;
		}
		if(x>=paper[index][0] && y>=paper[index][1]) {
			dfs(index+1, paper[index][0], paper[index][1], cnt+1);
		}
		dfs(index+1, x,y, cnt);
		
	}
}
