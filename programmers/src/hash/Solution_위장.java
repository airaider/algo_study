package hash;

import java.util.HashMap;

public class Solution_위장 {
	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 1;
	        HashMap<String, Integer> wear = new HashMap<>();
	        for (String[] strings : clothes) {
				if(!wear.containsKey(strings[1])) {
					wear.put(strings[1], 1);
				}else {
					wear.put(strings[1], wear.get(strings[1])+1);
				}
			}
	        for (Integer i : wear.values()) {
	        	answer=answer*(i+1);
	        }
	        
	        return answer-1;
	    }
	}
}
	
