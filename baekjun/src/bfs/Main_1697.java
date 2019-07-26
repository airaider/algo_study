package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {
	static int N;
	static int K;
	static int visit[] = new int[100001]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		bfs();
		
		
		
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		visit[N]=1;
		while(!q.isEmpty()) {
			N=q.poll();
			if(N==K) break;
			if(N+1<=100000 && visit[N+1]==0) {
				q.add(N+1);
				visit[N+1]=visit[N]+1;
			}
			if(N-1>=0 && visit[N-1]==0) {
				q.add(N-1);
				visit[N-1]=visit[N]+1;
			}
			if(2*N<=100000 && visit[2*N]==0) {
				q.add(2*N);
				visit[2*N]=visit[N]+1;
			}
		}
		System.out.println(visit[K]-1);
	}
}
