package SEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_3074_입국심사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			long time=arr[0]-1;
			while(M>0) {
				time++;
				for (int i : arr) {
					if(time%i==0) {
						M--;
					}
				}
				
			}
			System.out.println("#"+t+" "+time);
		}
	}

}
