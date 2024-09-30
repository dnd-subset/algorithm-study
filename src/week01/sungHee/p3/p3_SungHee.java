package week01.sungHee.p3;

import java.util.*;
import java.io.*;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/7569
 * 메모리 : 121148 KM
 * 시간 : 552ms
 *
 * 풀이
 * - 최소 일수구하는 문제 -> BFS 사용
 * 
 * 익은 토마토의 위치를 queue에 저장함
 * bfs
 * 1. queue에서 익은 토마토 꺼냄
 * 2. 위(z방향), 아래(z방향), 상(y방향), 하(y방향), 좌, 우 방향을 돌며
 * 3. 익을 수 있는 토마토가 있는지 확인(0인경우)
 * 4. 익을 수 있는 토마토면
 *      4-1. queue에 저장
 *      4-2. box에 이전 위치의 box값 + 1로 저장 (날짜 확인 위해)
 * 5. 1~4의 과정을 queue가 비워질 때 까지 반복(익을 수 있는 토마토가 다 익을 때까지)
 * 
 * 6. 날짜 출력
 * 
 */

public class p3_SungHee {

    static int dz[] = {1, -1, 0, 0, 0, 0}; // z방향배열
    static int dy[] = {0, 0, 0, 0, 1, -1}; // y방향배열
    static int dx[] = {0, 0, 1, -1, 0, 0}; // x방향배열

    static int box[][][];

    static int N, M, H;

    static Queue<Apple> ripeApplesQueue; //익은 사과 큐

    private static class Apple { 
        public final int z;
        public final int y;
        public final int x;

        public Apple(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        ripeApplesQueue = new LinkedList<>();

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) ripeApplesQueue.offer(new Apple(i, j, k));
                }
            }
        }

        bfs();
        System.out.println(findDay());
    }

    static void bfs() {
        while (!ripeApplesQueue.isEmpty()) {
            Apple cur = ripeApplesQueue.poll();

            for(int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                // 익을 수 있는지 체크
                if (nz < 0 || nx < 0 || ny <0 || nz >= H || ny >= N || nx >= M || box[nz][ny][nx] != 0 ) continue;

                box[nz][ny][nx] = box[cur.z][cur.y][cur.x] + 1;
                ripeApplesQueue.offer(new Apple(nz, ny, nx));
            }
        }

    }

    static int findDay() {
        // box에 하나라도 0이 있으면 -1 출력
        int result = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k=0; k < M; k++) {
                    if (box[i][j][k] == 0) return -1;
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }
        return result -1;
    }
}
