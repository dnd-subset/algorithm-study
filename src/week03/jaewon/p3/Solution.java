import java.util.*;

/*
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 그래프를 BFS로 순회하며 연결 여부 확인
 * 방문 여부를 확인하며 새로 방문하는 경우에 네트워크의 개수를 1 증가
*/

public class Solution {
    boolean[] visited = new boolean[202];
    int cnt = 0;

    public void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < n; ++i) {
                if (visited[i])
                    continue;
                if (computers[node][i] == 0 || node == i)
                    continue;
                visited[i] = true;
                q.add(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                cnt++;
                bfs(i, n, computers);
            }
        }
        return cnt;
    }
}
