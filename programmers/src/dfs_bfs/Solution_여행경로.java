package dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_여행경로 {
	class Solution {
		public String[] solution(String[][] tickets) {
			String[] answer = {};
			Queue<String> q = new LinkedList<String>();
			boolean visit[] = new boolean[tickets.length];
			q.add("ICN");
			String result="";
			int ans=0;
			while(!q.isEmpty()) {
				String city = q.remove();
				result=result+city+",";
				String line = "";
				for(int i=0;i<tickets.length;i++) {
					if(tickets[i][0].equals(city) && !visit[i]) {
						if(line.equals(null)) {
							line=tickets[i][1];
							ans=i;
						}else {
							if(line.compareTo(tickets[i][1])<0) {
								continue;
							}else {
								line=tickets[i][1];
								ans=i;
							}
						}
					}
				}
				visit[ans]=true;
				q.add(line);
			}
			answer=result.split(",");
			return answer;
		}
	}
	public static void main(String[] args) {
		String a = "abc";
		String b = "add";
		String[][] tickets = {
				{"ICN", "JFK"}
				,{"HND", "IAD"}
				,{"JFK", "HND"}
		};
		System.out.println(Arrays.toString(Solution(tickets)));
		System.out.println(a.compareTo(b));
		int map [][] = new int [7][8];
		System.out.println(map.length);
		
	}
	private static String[] Solution(String[][] tickets) {
		String[] answer = {};
		Queue<String> q = new LinkedList<String>();
		boolean visit[] = new boolean[tickets.length];
		q.add("ICN");
		String result="";
		int ans=0;
		while(!q.isEmpty()) {
			String city = q.remove();
			if(city.equals("")) break;
			result=result+city+",";
			String line = "";
			for(int i=0;i<tickets.length;i++) {
				if(tickets[i][0].equals(city) && !visit[i]) {
					if(line.equals("")) {
						line=tickets[i][1];
						ans=i;
					}else {
						if(line.compareTo(tickets[i][1])<0) {
							continue;
						}else {
							line=tickets[i][1];
							ans=i;
						}
					}
				}
			}
			visit[ans]=true;
			q.add(line);
		}
		answer=result.split(",");
		return answer;
	}
}
