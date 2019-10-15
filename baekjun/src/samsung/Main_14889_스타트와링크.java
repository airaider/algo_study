package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N;
	static int [][] map;
	static int [] start;
	static int [] link;
	static int ans = Integer.MAX_VALUE;
	static int result1, result2;
 	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		visit = new boolean [N];
		StringTokenizer st =null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(ans);
	
	}
	private static void dfs(int v, int len) {
		if(len == N/2) {
			divideTeam();
		}
		else {
			for(int i=v;i<N;i++) {
				if(!visit[i]) {
					visit[i]=true;
					dfs(i, len+1);
				}
			}
			
		}
		visit[v]=false;
		
		
	}
	private static void divideTeam() {
		start = new int[N/2];
		link = new int[N/2];
		int s=0;
		int	l=0;
		for(int i=0;i<N;i++) {
			if(visit[i]) {
				start[s++]=i;
			}else {
				link[l++]=i;
			}
		}
		calculate(start, link);
		
	}
	private static void calculate(int[] a, int[] b) {
		result1=0;
		result2=0;
		for(int i=0;i<N/2-1;i++) {
			for(int j=i+1;j<N/2;j++) {
				result1+=map[start[i]][start[j]];
				result2+=map[link[i]][link[j]];
				result1+=map[start[j]][start[i]];
				result2+=map[link[j]][link[i]];
			}
		}
		ans=Math.min(ans, Math.abs(result1-result2));
		
		
	}
}
