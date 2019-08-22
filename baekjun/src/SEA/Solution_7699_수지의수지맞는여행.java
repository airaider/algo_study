package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    private static char[][] map;
    private static int[] visited;
    private static int max;
    private static int R;
    private static int C;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray(); //1차원 배열을 통째로 받기
            }
             
            visited = new int['Z'+1]; // A:65 Z:90 연산 시간을 줄이기 위해 앞에 index는 버림
//          0,0 부터 시작해서 DFS로 탐색
            visited[map[0][0]]++; // 방문 체크
            max = 1; // 최대 전진할 수 있는 칸수;
            dfs(0,0,1);
            sb.append('#').append(t).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }
/** (r,c) step 칸수만큼 진행한 상태 */
    private static void dfs(int r, int c, int step) {
//      반복문 : 같은 구조이면 재귀함수보다 더 빠르다
//      재귀함수 : 깊이우선, 너비우선 등, 가지치기 들을 자유롭게 할수 있다는 장점
//      백트래킹의 포커스는 가지치기
        if(max == 26) return; // 가지치기, 최대 step을 달성한 경우
        if(max < step) max = step; // 최대칸구이면 업데이트
        // 상하좌우
        if(0 <= r-1 && visited[map[r-1][c]] == 0) { // 상
            visited[map[r-1][c]]++;// 방문 체크
            dfs(r-1,c,step+1);// 재귀 호출
            visited[map[r-1][c]]--;// 방문 체크 해제
             
        }
        if(r+1 < R && visited[map[r+1][c]] == 0) { // 하
            visited[map[r+1][c]]++;// 방문 체크
            dfs(r+1,c,step+1);// 재귀 호출
            visited[map[r+1][c]]--;// 방문 체크 해제
             
        }
        if(0 <= c-1 && visited[map[r][c-1]] == 0) { // 좌
            visited[map[r][c-1]]++;// 방문 체크
            dfs(r,c-1,step+1);// 재귀 호출
            visited[map[r][c-1]]--;// 방문 체크 해제
             
        }
        if(c+1 < C && visited[map[r][c+1]] == 0) { // 우
            visited[map[r][c+1]]++;// 방문 체크
            dfs(r,c+1,step+1);// 재귀 호출
            visited[map[r][c+1]]--;// 방문 체크 해제
             
        }
         
         
    }
     
 
}