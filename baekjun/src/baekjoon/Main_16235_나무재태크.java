package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_16235_나무재태크 {
	static int N,M,K;
	static int map[][];
	static int add[][];
	static int dir[][] = {
			{-1,-1}, {1,1}, {1,-1}, {-1,1}, {0,1}, {1,0}, {0,-1}, {-1,0}	
	};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		add = new int[N][N];
		ArrayList<Tree> tree = new ArrayList<>();
		Deque<Tree> life = new LinkedList<>();
		Stack<Point> plant = new Stack<>();
		Stack<Tree> dead = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=5;
				add[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			tree.add(new Tree(x,y,age));
		}
		Collections.sort(tree);
		for (int i = 0; i < tree.size(); i++) {
			life.add(tree.get(i));
		}
		for (int k = 0; k < K; k++) {
			for (int i = 0, size = life.size(); i < size; i++) {
				Tree t = life.pollFirst();
				int x = t.x;
				int y = t.y;
				int age = t.age;
				if(map[x][y]-age<0) {
					dead.add(new Tree(x,y,age));
				}
				else {
					map[x][y]-=age;
					if((age+1)%5==0) plant.add(new Point(x,y));
					life.addLast(new Tree(x,y,age+1));
				}
			}
			while(!dead.isEmpty()) {
				Tree p = dead.pop();
				map[p.x][p.y]+=p.age/2;
			}
			while(!plant.isEmpty()) {
				Point p = plant.pop();
				int x = p.x;
				int y = p.y;
				for (int i = 0; i < 8; i++) {
					int nx = x+dir[i][0];
					int ny = y+dir[i][1];
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					life.addFirst(new Tree(nx,ny,1));
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]+=add[i][j];
				}
			}
		}
		System.out.println(life.size());
		
		
	}
	private static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
	}
}
