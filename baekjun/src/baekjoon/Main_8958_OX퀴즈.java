package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String input = br.readLine();
			int ans=0;
			int cnt=1;
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i)=='O') {
					ans+=cnt++;
				}else {
					cnt=1;
				}
			}
			System.out.println(ans);
		}
		
	}

}
