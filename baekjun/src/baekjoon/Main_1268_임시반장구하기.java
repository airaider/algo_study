package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1268_임시반장구하기 {
	static int N;
	static int map[][];
	static boolean f[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 map = new int[N][5];
		 for (int i = 0; i < N; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		f = new boolean[N][N];
		int[] count = new int[N];
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					if(i!=k && map[k][j] == map[i][j]) {
						if(!f[i][k]) {
							f[i][k]=true;
							count[i]++;
						}
					}
				}
			}
		}
		int max=0;
		int ans=1;
		for (int i = 0; i < N; i++) {
			if(count[i]>max) {
				max=count[i];
				ans=i+1;
			}
		}
		System.out.println(ans);
		 
	}

}
