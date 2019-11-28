package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static int gear[][];
	static int[] visit;
	static int K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			gear = new int[4][8];
			K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken());
				visit = new int[4];
				visit[a]=b;
				int ch=a;
				while(ch-1>=0 && (gear[ch][6]!=gear[ch-1][2])) {
					visit[ch-1]=-visit[ch];
					ch--;
				}
				ch=a;
				while(ch+1<4 && (gear[ch][2]!=gear[ch+1][6])) {
					visit[ch+1]=-visit[ch];
					ch++;
				}
				for (int i = 0; i < 4; i++) {
					if(visit[i]>0) clock(i);
					else if(visit[i]<0) counter(i);
				}
			}
			int score=0;
			for (int i = 0; i < 4; i++) {
				if(gear[i][0]==1) {
					score+=Math.pow(2, i);
				}
			}
			System.out.println("#"+t+" "+score);
			
		}
	}
	private static void counter(int a) {
		int temp=gear[a][0];
		for (int i = 0; i < 7; i++) {
			gear[a][i]=gear[a][i+1];
		}
		gear[a][7]=temp;
	}
	private static void clock(int a) {
		int temp=gear[a][7];
		for (int i = 7; i > 0; i--) {
			gear[a][i]=gear[a][i-1];
		}
		gear[a][0]=temp;
	}

}
