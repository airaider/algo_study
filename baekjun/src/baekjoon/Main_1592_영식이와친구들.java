package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] human = new int[N];
		int i=0;
		int ans=0;
		while(true) {
			human[i]++;
			if(human[i]==M) break;
			ans++;
			if(human[i]%2==1) {
				i=i+L>=N?i+L-N:i+L;
			}else {
				i=i-L<0?i-L+N:i-L;
			}
		}
		System.out.println(ans);
	}

}
