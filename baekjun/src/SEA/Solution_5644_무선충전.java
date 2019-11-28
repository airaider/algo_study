package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int M,P;
	static int A[],B[];
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			A = new int [M];
			B = new int [M];
			map = new int[M][M];
			st = new StringTokenizer(br.readLine());
			StringTokenizer sr = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(sr.nextToken());
			}
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
			}
			
			
			
			
			
		}
	}
}
