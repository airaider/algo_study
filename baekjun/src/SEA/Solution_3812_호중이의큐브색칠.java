package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3812_호중이의큐브색칠 {
	static int X,Y,Z,A,B,C,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			for (int x = 0; x < X; x++) {
				for (int y = 0; y < Y; y++) {
					for (int z = 0; z < Z; z++) {
						arr[Math.abs((x+y+z)-(A+B+C))%N]++;
					}
				}
			}
			
			System.out.println(Arrays.toString(arr));
			
			
			
		}
		
	}
}
