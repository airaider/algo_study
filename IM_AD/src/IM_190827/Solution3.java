package IM_190827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution3 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			atom[] info = new atom[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				info[i] = new atom(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			boolean[] visit = new boolean[N];
			for (atom a : info) {
				switch (a.dir) {
				case 0:
					
					break;
				case 1:
									
					break;
				
				case 2:
					
					break;
				
				case 3:
					
					break;
				
					
				default:
					break;
				}
			}
			
			
		}
	}

}

class atom{
	int x;
	int y;
	int dir;
	int K;
	public atom(int x, int y, int dir, int k) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		K = k;
	}
	
}