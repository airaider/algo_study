package greedy;

import java.util.Arrays;

public class Solution_체육복 {
	class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
			int answer = 0;
			int c[] = new int[n+1];
			for (int i : lost) {
				c[i]--;
			}
			for (int i : reserve) {
				c[i]++;
			}
			for (int i = 1; i < n+1; i++) {
				if(c[i]<0) {
					if(i+1<n+1 && c[i+1]==1) {
						c[i+1]--;
						c[i]++;
					}
					if(i-1>=0 && c[i-1]==1) {
						c[i-1]--;
						c[i]++;
					}
				}
			}
			for (int i = 1; i < n+1; i++) {
				if(c[i]==0) answer++;
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		solution(5,lost,reserve);
	}
	private static void solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int c[] = new int[n+1];
		for (int i : lost) {
			c[i]--;
		}
		for (int i : reserve) {
			c[i]++;
		}
		for (int i = 1; i < n+1; i++) {
			if(c[i]<0) {
				if(i+1<n+1 && c[i+1]==1) {
					c[i+1]--;
					c[i]++;
					continue;
				}
				if(i-1>=0 && c[i-1]==1) {
					c[i-1]--;
					c[i]++;
				}
			}
		}
		for (int i = 1; i < n+1; i++) {
			if(c[i]>=0) answer++;
		}
		System.out.println(answer);
		
	}
	
	
}
