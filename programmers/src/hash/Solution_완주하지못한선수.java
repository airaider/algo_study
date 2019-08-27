package hash;
import java.util.HashMap;
import java.util.Map;

public class Solution_완주하지못한선수 {

	class Solution {
	    public String solution(String[] participant, String[] completion) {
	        HashMap<String, Integer> map = new HashMap<>();
			for (String st : participant) {
				if(!map.containsKey(st)) {
					map.put(st, 1);
				}else {
					map.put(st,map.get(st)+1);
				}
			}
			for (String st : completion) {
				map.replace(st, map.get(st)-1);
			}
	        String answer = "";
			for (String st : map.keySet()) {
				if(map.get(st)!=0) {
					answer=st;
				}
			}
	        return answer;
	    }
	}
}
