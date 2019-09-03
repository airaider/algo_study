package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2303_숫자게임 {
	static int card[][];
	static int result[];
	static int N;
	static int max,ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[N][5];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				card[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		ans=0;
		result=new int[3];
		combi(0,0);
		System.out.println(ans);
		
	}
	private static void combi(int index, int before) {
		if(index==3) {
			for (int i = 0; i < N; i++) {
				int sum=0;
				for (int j = 0; j < 3; j++) {
					sum+=card[i][result[j]];
				}
				sum=sum%10;
				if(sum>=max) {
					if(sum==max && i+1>ans) {
						max=sum;
						ans=i+1;
					}
					else if(sum>max){
						max=sum;
						ans=i+1;
					}
				}
			}
			return;
		}
		for (int i = before; i < 5; i++) {
			result[index]=i;
			combi(index+1,i+1);
		}
		
	}

}
