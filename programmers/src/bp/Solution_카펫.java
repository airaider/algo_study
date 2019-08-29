package bp;

import java.util.Arrays;

public class Solution_카펫 {
	class Solution {
		public int[] solution(int brown, int red) {
			int[] answer = {};
			int area = brown + red;
			for (int i = 2; i <= Math.sqrt(area); i++) {
				if (i % area == 0) {
					int h = i;
					int w = area / i;
					if ((h - 2) * (w - 2) == red) {
						answer[0] = h;
						answer[1] = w;
						return answer;
					}
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		int[] answer = {};
		answer = new int[2];
		int brown = 10;
		int red = 2;
		int area = brown + red;
		for (int i = 2; i <= Math.sqrt(area); i++) {
			if (i % area == 0) {
				int h = i;
				int w = area / i;
				if ((h - 2) * (w - 2) == red) {
					answer[0] = h;
					answer[1] = w;
					System.out.println(Arrays.toString(answer));
				}
			}
		}
	}
}
