package dfs_bfs;

public class Solution_네트워크 {
	class Solution {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        answer=n;
	        for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(computers[i][j]==1) {
						answer--;
					}
				}
			}
	        return answer;
	    }
	}
}
