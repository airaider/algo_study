package hash;

import java.util.HashMap;

public class Solution_베스트앨범 {
	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	        int[] answer = {};
	        HashMap<String, Integer> map = new HashMap<>();
	        for (int i = 0; i < genres.length; i++) {
	        	if(!map.containsKey(genres[i])) {
					map.put(genres[i], plays[i]);
				}else {
					map.put(genres[i], map.get(genres[i])+plays[i]);
				}
	        	
			}
	        int max=0;
	        String music;
	        for (String st : map.keySet()) {
				int a = map.get(st);
				if(a>max) {
					max = a;
					music = st;
				}
			}
	        
	        
	        
	        return answer;
	    }
	}
}
