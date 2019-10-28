package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_5672_올해의조련사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i]=br.readLine().charAt(0);
			}
			int fp = 0;
			int lp = N-1;
			while(fp<lp) {
				if(arr[fp]==arr[lp]) {
					int lc=fp;
					int rc=lp;
					while(++lc<--rc) {
						if(arr[lc]!=arr[rc])break;
					}
					if(arr[lc]<arr[rc]) {
						sb.append(Character.toString(arr[fp++]));
					}else {
						sb.append(Character.toString(arr[lp--]));
					}
				}
				else if(arr[fp]<arr[lp]) {
					sb.append(Character.toString(arr[fp++]));
				}
				else {
					sb.append(Character.toString(arr[lp--]));
				}
			}
			sb.append(Character.toString(arr[fp]));
			System.out.println("#"+t+" "+sb);
		}
	}

}
