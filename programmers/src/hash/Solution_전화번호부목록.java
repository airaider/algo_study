package hash;

public class Solution_전화번호부목록 {
	class Solution {
	    public boolean solution(String[] phone_book) {
	       boolean answer = true;
	        int size = phone_book.length;
	        for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(i!=j) {
						if(phone_book[i].startsWith(phone_book[j])) return false;
					}
				}
			}
	        return answer;
	    }
	}
}
