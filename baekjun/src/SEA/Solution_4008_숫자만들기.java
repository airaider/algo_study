package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	static int N;
	static int plus[];
	static int num[];
	static int arr[];
	static int min,max;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			plus = new int[4];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				plus[i]=Integer.parseInt(st.nextToken());
			}
			num = new int[N];
			arr = new int[N-1];
			visit = new boolean[N-1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			permu(0);
			System.out.println("#"+t+" "+(max-min));
		}
	}
	private static void permu(int index) {
		if(index==N-1) {
			calcu();
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(plus[i]!=0) {
				plus[i]--;
				arr[index]=i;
				permu(index+1);
				plus[i]++;
			}
			
		}
	}
	private static void calcu() {
		int a=num[0];
		for (int i = 0; i < N-1; i++) {
			switch (arr[i]) {
			case 0:
				a+=num[i+1];
				break;
			case 1:
				a-=num[i+1];
				break;
			case 2:
				a*=num[i+1];
				break;
			case 3:
				a/=num[i+1];
				break;
			
			}
		}
		max = Math.max(a, max);
		min = Math.min(a, min);
		
	}

}
