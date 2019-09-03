package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N,M,D;
	static int map[][];
	static int num[] = new int[3];
	static int ans=0;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0,0);
	}
	private static void combi(int before, int index) {
		if(index == 3) {
			System.out.println(Arrays.toString(num));
			defense();
			return;
		}
		for (int i = before; i < M; i++) {
			num[index]=i;
			combi(i+1, index+1);
		}
		
	}
	private static void defense() {
		for(int i=N-1;i>=0;i--) {
			for (int loc : num) {
				if(map[i][loc]==1) {
					ans++;
					map[i][loc]=0;
				}else {
					
				}
			}
			
			
		}
	}

}
