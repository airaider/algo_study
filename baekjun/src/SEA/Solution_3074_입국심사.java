package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3074_입국심사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			long high = (long)arr[N-1]*M;
			long low = 0;
			long mid=0;
			long temp=0;
			loop:
			while(low<=high) {
				mid=(low+high)/2;
				long cnt=0;
				for (int i = 0; i < N; i++) {
					cnt+=mid/arr[i];
					if(cnt>=M) {
						if(mid==temp) {
							break loop;
						}
						temp=mid;
						high=mid-1;
						continue loop;
					}
				}
				low=mid+1;
			}
			System.out.println("#"+t+" "+low);
		}
	}
}
