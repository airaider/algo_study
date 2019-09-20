package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 청소년_교통카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int money = 20000;
		while(st.hasMoreTokens()) {
			int dis=Integer.parseInt(st.nextToken());
			if(40>=dis) {
				if(money-720<0) {
					System.out.println(money);
					return;
				}
				else {
					money-=720;
				}
			}
			else {
				dis-=41;
				dis/=8;
				int amount=720+(dis+1)*80;
				if(money-amount<0) {
					System.out.println(money);
					return;
				}
				else {
					money-=amount;
				}
			}
		}
		System.out.println(money);
		
		
	}

}
