package bp;

public class Solution_소수찾기 {
	public int solution(String numbers) {
        int answer = 0;
        int[] num = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
			num[i] = numbers.charAt(i)-'0';
		}
        subset(num, 0, 0);
        return answer;
    }

	private static void subset(int[] num, int flag, int index) {
		
		if(index==num.length) {
			for (int i = 0; i < num.length; i++) {
				if((flag&1<<i)==0) {
					System.out.print(num[i]);
				}
			}
			System.out.println();
			return;
			
		}
		
		subset(num, flag|1<<index,index+1);
		subset(num, flag,index+1);
		
	}
	public static void main(String[] args) {
		int[] num = {1,2,3};
		subset(num, 0, 0);
	}
}
