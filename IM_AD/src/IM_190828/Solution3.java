package IM_190828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {
	static int N;
	static atom[] info;
	static boolean[] visit;
	static int ans;
	static int loss;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			loss = 0;
			ans = 0;
			info = new atom[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				info[i]=new atom(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			visit = new boolean[N];
			while(true) {
				if(loss==N) break;
				if(!possible()) break;
				for (int i = 0; i < N; i++) {
					if(!visit[i]) {
						switch (info[i].dir) {
						case 0:
							info[i].y+=0.5;
							break;
						case 1:
							info[i].y-=0.5;	
							break;
						case 2:
							info[i].x-=0.5;
							break;
						case 3:
							info[i].x+=0.5;
							break;
						}
					}
				}
				check();
				die();
			}
			System.out.println("#"+t+" "+ans);
		}
			
			
			
			
		}
	
	private static boolean possible() {
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				return true;
			}
		}
		return false;
	}

	private static void die() {
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				if(info[i].x >1000|| info[i].y<-1000 ) {
					visit[i]=true;
					loss++;
				}
			}
		}
		
	}

	private static void check() {
		for (int i = 0; i < N-1; i++) {
			boolean exist=false;
			if(!visit[i]) {
				for (int j = i+1; j < N; j++) {
					if(i!=j && !visit[j] && info[i].x==info[j].x && info[i].y==info[j].y) {
						exist=true;
						visit[j]=true;
						loss++;
						ans+=info[j].K;
					}
				}
				if(exist) {
					visit[i]=true;
					loss++;
					ans+=info[i].K;
				}
				
			}
		}
	}

	

}

class atom{
	double x;
	double y;
	int dir;
	int K;
	public atom(double x, double y, int dir, int k) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		K = k;
	}
	
}