package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5607_조합 {
    static long x, y, gcd, temp;
    public static void main(String[] ar) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			long p = 1234567891;
			long[] fac = new long[N+1];
			fac[0] = 1;
			fac[1] = 1;
			for(int i=2; i<=N; i++) {
				fac[i] = (fac[i-1]*i)%p;
			}
			long denom = (fac[K]*fac[N-K])%p;
			System.out.println(denom);
			System.out.println(Arrays.toString(fac));
			euclidean(p, denom);
			long result = ((fac[N]%p)*(y%p))%p;
			if(result<0) result += p;
			System.out.println("#"+t+" "+result);
		}

    }

    public static void euclidean(long B, long p){
        if(B%p>0){
            euclidean(p, B%p);
            temp = y;
            y = x - (B/p)*y;
            x = temp;
        }else{
            x = 0;
            y = 1;
            gcd = p;
        }
    }
}