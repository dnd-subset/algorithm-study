package week06.p3;

import java.util.*;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 테스트 1 〉	통과 (67.68ms, 104MB)
 * 테스트 2 〉	통과 (8.39ms, 79.1MB)
 * 테스트 3 〉	통과 (8.39ms, 76MB)
 * 테스트 4 〉	통과 (11.27ms, 66.7MB)
 */

/**
 * 풀이(dfs)
 * 1. tickets를 도착 공항의 알파벳 순으로 정렬
 *
 * dfs시작 (target 을 "ICN"으로)
 * 1. 종료 조건 (tickets의 길이와 경로 지난 횟수인 cnt가 같으면 종료)
 * 2. tickets for문 돌면서
 *      2-1. 방문하지 않고 시작 공항이 target과 같으면
 *          2-1-1. 방문을 true 변경하고
 *          2-1-2. target을 도착 공항으로 route를 "," + 도착공항, cnt +1로 dfs 재귀 호출
 *          2-2-3. 방문을 false로 변경
 *
 * 방문을 다 확인하면 ","를 기준으로 경로를 리턴
 */


class Solution {
    boolean[] visited;
    ArrayList<String> answers;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        
        return answers.get(0).split(",");
    }
    
    void dfs(String target, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            answers.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(target)) {
                visited[i] = true;
                
                dfs(tickets[i][1], route + "," + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}
