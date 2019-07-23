package simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simul_10219 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
		}
	static int N;
	static int M;
	static char[][] map;
	static char[][] fp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T=stoi(st.nextToken());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N=stoi(st.nextToken());
			M=stoi(st.nextToken());
			map = new char [N][M];
			fp = new char [N][M];
			for (int i = 0; i < N; i++) {
				String a = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j]=a.charAt(j);
				}
			}
			flip();
			show();
		}
		
		

	}
	private static void flip() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				fp[i][M-j-1]=map[i][j];
			}
			
		}
	}
	private static void show() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(fp[i][j]);
			}
			System.out.println();
		}
		
	}

}