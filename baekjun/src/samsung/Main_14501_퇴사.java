package samsung;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14501_퇴사 {
	static int N;
	static int ans=-1;
	static talk[] schedule;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		schedule = new talk[N+1];
		for (int i = 1; i <= N; i++) {
			int s = i;
			int f = sc.nextInt()+s;
			int p = sc.nextInt();
			schedule[i]=new talk(s,f,p);
		}
		find(1,0);
		System.out.println(ans);
	}
	private static void find(int index, int result) {
		if(index>N+1) return;
		if(index<=N+1) {
			if(ans<result) ans=result;
		}
		
		for (int i = index; i <= N; i++) {
			find(schedule[i].fin, result+schedule[i].pay);
		}
	}
}

class talk{
	int start;
	int fin;
	int pay;
	public talk(int start, int fin, int pay) {
		this.start = start;
		this.fin = fin;
		this.pay = pay;
	}
	
}

