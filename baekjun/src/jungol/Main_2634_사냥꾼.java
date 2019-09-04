package jungol;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2634_사냥꾼 {
	static int M,N;
	static long L;
	static boolean shoot[];
	static int loc[];
	static Point animal[];
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 사대
		N = Integer.parseInt(st.nextToken()); // 동물
		L = Long.parseLong(st.nextToken()); // 좌표
		loc = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			loc[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(loc);
		shoot = new boolean[N];
		animal = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			animal[i]=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(animal, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				int a = o1.x-o2.x; 
				if(a==0) return o1.y-o2.y;
				return a;
			}
		});
		
		for (int i = 0; i < N; i++) {
			Point p = animal[i];
			int x = p.x;
				
			for (int j = 0; j < M; j++) {
				if(Math.abs((long)loc[j]-(long)p.x)+(long)p.y<=L) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}

}
