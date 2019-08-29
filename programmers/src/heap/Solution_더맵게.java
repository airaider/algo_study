package heap;

import java.util.Arrays;

public class Solution_더맵게 {
	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        Arrays.sort(scoville);
	        for (int i = 0; i < scoville.length-1; i++) {
				scoville[i+1]=scoville[i]+scoville[i+1]*2;
				Arrays.sort(scoville, i+1, scoville.length);
				for (int j = i+1; j < scoville.length; j++) {
					if(scoville[j]<K) break;
					if(j==scoville.length-1) return answer;
				}
			}
	        return answer;
	    }
	}
}
