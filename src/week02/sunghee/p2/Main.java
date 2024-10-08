package week02.sunghee.p2;

import java.io.*;
import java.util.*;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/7562
 * 메모리 : 68976 KM
 * 시간 : 212 ms
 */

/**
 * chess에 depth값 저장하여 출력
 * 
 * 테스트 케이스 for문 돌기
 * fromY, fromX, toY, toX 값 받아 bfs에 인자값으로 넘겨줌
 * bfs
 * 1. 시작 좌표을 큐에 넣어주고 chess[fromY][fromX] = 1;
 * 2. 큐가 빌때 까지 반복 
 *      2-1. 이동 방향 도안 for문 돌기
 *      2-2. 다음 방향이 접합한지 판단
 *      2-3. 적합하면 depth 값 1 올려서 chess 해당 좌표에 저장
 *      2-4. 해당 좌표가 이동하려는 좌표 값이면 retrun, 아니면 큐에 저장
 */

public class Main {

    int[][] dir = { { 2, -1 }, { -2, -1 }, { 1, -2 }, { -1, -2 }, { 2, 1,}, { 1, 2 }, { -1, 2 }, { -2, 1 } };
    int[][] chess;

    int I;

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromY = Integer.parseInt(st.nextToken());
            int fromX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int toY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());

            chess = new int[I][I];

            bfs(fromY, fromX, toY, toX);

            System.out.println(chess[toY][toX] -1);
        }
    }

    private void bfs(int fromY, int fromX, int toY, int toX) {
        Queue<int[]> q = new LinkedList<>();
        chess[fromY][fromX] = 1;
        q.offer(new int[]{fromY, fromX});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int[] movePoint : dir) {
                int ny = cur[0] + movePoint[0];
                int nx = cur[1] + movePoint[1];

                if (ny < 0 || ny >= I || nx < 0 || nx >= I || chess[ny][nx] != 0) continue;
                chess[ny][nx] = chess[cur[0]][cur[1]] + 1;
                if (ny == toY && nx == toX) return;
                
                q.offer(new int[]{ny, nx});
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
    
