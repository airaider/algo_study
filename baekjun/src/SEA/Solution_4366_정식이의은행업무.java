package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무 {
	static char[] temp;
	static char[] two;
	static char[] three;
	static boolean flag;
	static int number;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			two = br.readLine().toCharArray();
			three = br.readLine().toCharArray();
			temp = new char[two.length];
			flag=false;
			for (int i = 0; i < two.length; i++) {
				temp=two.clone();
				if(two[i]=='1') {
					temp[i]='0';
				}else temp[i]='1';
				
				test();
				if(flag)break;
			}
			System.out.println("#"+t+" "+number);
		}
	}

	private static void test() {
		String convert="";
		for (int i = 0; i < temp.length; i++) {
			convert=convert+temp[i];
		}
		number = Integer.parseInt(convert, 2);
		char[] compare = Integer.toString(number,3).toCharArray();
		if(compare.length==three.length) {
			int cnt=0;
			for (int i = 0; i < compare.length; i++) {
				if(compare[i]!=three[i]) {
					cnt++;
					if(cnt==2) return;
				}
			}
			if(cnt==1) {
				flag=true;
			}
		}
		
	}
}
