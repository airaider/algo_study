package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int L = input.length;
		int R=0;
		for (int i = 1; i <= Math.sqrt(L); i++) {
			if(L%i==0) {
				R=i;
			}
		}
		int C=L/R;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(input[i+R*j]);
			}
			
		}
		System.out.println(sb);
		
	}

}
