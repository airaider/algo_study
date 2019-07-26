package practice;

import java.util.Scanner;

public class Main_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int [7];
		for (int i = 0; i < 7; i++) {
			arr[i]=sc.nextInt();
		}
		int sum=0;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < 7; i++) {
			if(arr[i]%2==1) {
				sum+=arr[i];
				if(arr[i]<min) {
					min=arr[i];
				}
			}
			
		}
		if(sum==0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(min);
		
		
	}

}
