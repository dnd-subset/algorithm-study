package week05.sunghee.p3;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87694
 * 테스트 1 〉	통과 (0.18ms, 78.1MB)
 * 테스트 2 〉	통과 (0.19ms, 75.8MB)
 * 테스트 3 〉	통과 (0.21ms, 76.5MB)
 * 테스트 4 〉	통과 (0.17ms, 78.1MB)
 * 테스트 5 〉	통과 (0.16ms, 77.2MB)
 * 테스트 6 〉	통과 (0.12ms, 77.5MB)
 * 테스트 7 〉	통과 (0.24ms, 86.3MB)
 * 테스트 8 〉	통과 (0.27ms, 71.7MB)
 * 테스트 9 〉	통과 (1.68ms, 72.6MB)
 * 테스트 10 〉	통과 (1.29ms, 71MB)
 * 테스트 11 〉	통과 (2.00ms, 73.2MB)
 * 테스트 12 〉	통과 (1.89ms, 78.1MB)
 * 테스트 13 〉	통과 (0.90ms, 77MB)
 * 테스트 14 〉	통과 (0.40ms, 81.2MB)
 * 테스트 15 〉	통과 (0.22ms, 73.9MB)
 */

/**
 * 풀이보고 품(배율 조절 관련해서 -> 안하면 겹치는 모서리 생김)
 * bfs 사용
 * map에서 테두리는 2, 도형이 포함된 부부는 1로 지정
 */

import java.util.*;

public class Solution {
    int[][] map = new int[101][101];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for(int x = x1; x < x2 +1; x++) {
                for(int y = y1; y < y2 + 1; y ++) {
                    if(map[y][x] == 1) continue;
                    map[y][x] = 1;
                    if(y == y1 || y == y2 || x == x1 || x == x2) {
                        map[y][x] = 2;
                    }
                }
            }
        }

        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return (map[itemY * 2][itemX * 2] - 3) /2;
    }

    void bfs(int characterX, int characterY, int itemX, int itemY) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        map[characterY][characterX] = 3;
        queue.offer(new int[]{characterY, characterX});

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if(ny < 0 || ny > 100 || nx< 0 || nx > 100 || map[ny][nx] != 2) continue;

                map[ny][nx] = map[curY][curX] + 1;

                if(ny == itemY && nx == itemX) return;

                queue.offer(new int[]{ny, nx});
            }
        }

    }
}
