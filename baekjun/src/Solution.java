import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int T;
	static int map [][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t = 1 ; t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String st = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j]=st.charAt(j)-'0';
				}
			}
			int cnt=0;
			int incr=0;
			int flag = 0;
			int center=N/2;
			for (int i = 0; i < N; i++) {
				if(incr > center) {
					flag=-1;
				}
				if(incr == 0) {
					cnt+=map[i][center];
					incr++;
					flag=1;
					continue;
				}
				if(flag==-1) {
					cnt+=map[i][center];
					incr--;
					for(int j=1;j<incr;j++) {
						cnt+=map[i][center+j];
						cnt+=map[i][center-j];
					}
				}
				if(flag == 1) {
					cnt+=map[i][center];
					for(int j=1;j<=incr;j++) {
						cnt+=map[i][center+j];
						cnt+=map[i][center-j];
					}
					incr++;
				}
				
			}
			System.out.println("#"+t+" "+cnt);
			
		}
		
		
	}

}
