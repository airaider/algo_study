package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1215_회문1 {
	static Stack<Integer> st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			int len = Integer.parseInt(br.readLine());
			int map[][] = new int[8][8];
			for (int i = 0; i < 8; i++) {
				String input = br.readLine();
				for (int j = 0; j < 8; j++) {
					map[i][j] = input.charAt(j)-'0';
				}
			}
			int cnt=0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8-len; j++) {
					st = new Stack<Integer>();
					for(int k = 0;k<len;k++) {
						if(k==len/2&&len%2==1) {
							continue;
						}
						else if(k>=len/2) {
							int top = st.peek();
							if(map[i][j+k]!=top) break;
							else st.pop();
						}
						else st.add(map[i][j+k]);
					}
					if(st.isEmpty()) cnt++;
				}
				
			}
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i <= 8-len; i++) {
					st = new Stack<Integer>();
					for(int k = 0;k<len;k++) {
						if(k==len/2&&len%2==1) {
							continue;
						}
						else if(k>=len/2) {
							int top = st.peek();
							if(map[i+k][j]!=top) break;
							else st.pop();
						}
						else st.add(map[i+k][j]);
					}
					if(st.isEmpty()) cnt++;
				}
				
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
