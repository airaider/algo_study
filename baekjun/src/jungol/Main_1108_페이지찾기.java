package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1108_페이지찾기 {
	static int map[][];
	public static final int INF = 10000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[500][500];
		int n=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1]=1;
			n=Math.max(n, Math.max(a, b));
		}
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	if(map[i][j]==0) map[i][j]=INF;
            }
        }
		for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
		double result=0;
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j) result+=map[i][j];
            }
        }
		System.out.printf("%.3f",result/(n*(n-1)));
		
	}

}
