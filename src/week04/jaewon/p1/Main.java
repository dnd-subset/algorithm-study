import java.util.*;

/*
    문제 링크 : https://www.acmicpc.net/problem/1844
    시간, 메모리:
    테스트 1 〉	통과 (0.22ms, 87.2MB)
    테스트 2 〉	통과 (0.19ms, 79.4MB)
    테스트 3 〉	통과 (0.21ms, 80MB)
    테스트 4 〉	통과 (0.15ms, 71.5MB)
    테스트 5 〉	통과 (0.15ms, 72.3MB)
 */

/**
 * BFS 탐색
 * (0, 0) -> (n - 1, m - 1) 최단 경로 거리 계산
 */

class Solution {

    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[100][100];

        int N = maps.length - 1;
        int M = maps[0].length - 1;

        q.add(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int nl = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nl == N && nc == M) {
                    return maps[cur[0]][cur[1]] + 1;
                }

                if (nl < 0 || nl > N || nc < 0 || nc > M)
                    continue;
                if (maps[nl][nc] == 0)
                    continue;

                if (!visited[nl][nc]) {
                    visited[nl][nc] = true;
                    q.add(new int[] { nl, nc });
                    maps[nl][nc] = maps[cur[0]][cur[1]] + 1;
                }
            }
        }

        return -1;
    }
}