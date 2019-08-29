package dfs_bfs;

public class Solution_타켓넘버 {
	static int ans=0; // 실행시에는 아래 라인으로 이동
	class Solution {
	    public int solution(int[] numbers, int target) {
	        int answer = 0;
	        dfs(numbers,0,0,target);
	        answer=ans;
	        return answer;
	    }

		private void dfs(int[] num, int index, int sum, int t) {
			if(index==num.length) {
				if(sum == t) {
					ans++;
				}
				return;
			}
			
			dfs(num, index+1, sum+num[index],t);
			dfs(num, index+1, sum-num[index],t);
		}
	}
}
