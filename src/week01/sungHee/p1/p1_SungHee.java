package week01.sungHee.p1;

import java.io.*;
import java.util.*;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/2178
 * 메모리 : 12304 KM
 * 시간 : 76 ms
 */

/**
 * 적용 알고리즘 : BFS(최단 경로를 찾는 문제)
 * 
 * miro[y][x]의 값을 depth로 생각
 * miro[0][0]을 2로 설정하여
 * miro[y][x]의 값이 1인 경우에만 지나갈 수 있다.
 * (0이면 못지나가는 칸, 1초과면 이미 지나간 칸)
 */

public class p1_SungHee {

    static int[][] miro;
    static int N, M;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0}; //x방향배열
    static int[] dy = {0, -1, 0, 1}; //y방향배열

    private static class State {
        public final int y;
        public final int x;

        public State(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j =0; j<M; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }


        miro[0][0] = 2;

        bfs(0,0);
        System.out.println(miro[N-1][M-1] -1);
    }

    public static void bfs(int y, int x) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(y, x));

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            
            //방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                //범위 확인
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                //조건 확인 후 큐에 추가
                if(miro[ny][nx] == 1) {
                    miro[ny][nx] = miro[cur.y][cur.x] +1;
                    queue.offer(new State(ny, nx));
                }
            }

        }
    }
}
