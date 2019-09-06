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
	static power[] info;
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
			for (int i = 0; i < M; i++) {
				A[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i]=Integer.parseInt(st.nextToken());
			}
			info = new power[P];
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				int charge = Integer.parseInt(st.nextToken());
				info[i] = new power(x, y, power, charge);
			}
			
			
			
			
			
			
			
			
		}
	}
	private static class power{
		int x;
		int y;
		int power;
		int charge;
		public power(int x, int y, int power, int charge) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
			this.charge = charge;
		}
		
	}

}
