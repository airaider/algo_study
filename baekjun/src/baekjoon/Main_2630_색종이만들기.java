package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int N;
	static int map[][];
	static boolean visit[][];
	static int state;
	static int blue,white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		split(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
		
	}
	private static void split(int x, int y, int size) {
		int sum=0;
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(map[i][j]==1) sum++;
			}
		}
		
		if(sum == size*size) {
			blue++;
		}else if(sum==0) {
			white++;
		}else {
			split(x,y,size/2);
			split(x+size/2,y,size/2);
			split(x,y+size/2,size/2);
			split(x+size/2,y+size/2,size/2);
			
		}
		
	}
	
}
