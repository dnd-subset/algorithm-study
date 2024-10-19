package week04.sunghee.p1;


/**
 * 문제 링크 :https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 테스트 1  〉	통과 (0.13ms, 76.8MB)
 */

/**
 * bfs로 풀이
 * queue의 값을 꺼내 동,서,남,북 방향을 돌면서 만족하는 값(ny, nx가 범위 안에 속하고 maps[ny][nx]의 값이 1인 경우)
 * maps[ny][nx] 에 현재 maps의 값 + 1을 더해줌(depth계산)
 * queue에 값을 넣음
 * 위의 과정을 queue가 빌때까지 또는 ny, nx가 적군의 위치이면 종료
 *
 * maps의 적군의 위치 값 -1을 반환
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        bfs(maps);
        int answer = maps[maps.length-1][maps[0].length-1] -1;
        return answer == 0 ? -1 : answer;
    }

    void bfs(int[][] maps) {
        int x = 0;
        int y = 0;

        maps[y][x] = 2;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if(ny < 0 || nx < 0 || ny > maps.length-1 || nx > maps[0].length-1 ||  maps[ny][nx] != 1) continue;

                maps[ny][nx] = maps[curY][curX] + 1;

                if(ny == maps.length-1 && nx == maps[0].length-1) return;
                queue.offer(new int[]{ny, nx});
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(new Solution().solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0},{0,0,0,0,1}}));
    }
}
