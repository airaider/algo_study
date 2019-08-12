package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1213_String {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			br.readLine();
			String st = br.readLine();
			String input = br.readLine();
			int end = st.length();
			int cnt = 0;
			for(int i=0, size = input.length();i<=size-end;i++) {
				System.out.println(input.substring(i, i+st.length()));
				if(input.substring(i, i+st.length()).equals(st)) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
			
		}
		
		
	}

}
