package week07.sunghee.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 링크 :https://www.acmicpc.net/problem/16926
 * 메모리 : 32220 KB
 * 시간 : 672ms
 */

/**
 * 두 변 중 작은 변 / 2 : 회전하는 태두리 수
 * ex) 4X5 한다면 2개의 태두리 가 나온다고 생각
 * 가장 바깥 테두리:(0,0), (0,1), (0,2), (0,3), (0,4), (1,4),(2,4),(3,4),(3,3),...
 * 가장 안쪽 테두리:(1,1), (1,2), (1,3), (2,3), (2,2), (2,1)
 * 
 * 좌표 이동
 * 테두리 마다 회전하는 규칙 (왼, 위, 오, 아래) 순으로 이동
 *      죄표 움직임을 dy, dx로 지정,
 *      idx 는 범위가 벗어 날 경우 +1함
 * idx가 4보다 작을 동안 좌표를 움직여 주면 한 테두리의 좌표가 이동됨
 * 
 * 회전 수 만큼, 회전하는 태두리 수 만큼 좌표 이동을 반복해줌
 */

public class Main {

    public static void main(String[] args) throws Exception{
        new Main().sol_16926();
    }

    int[][] map;

    void sol_16926() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < R; i++) {
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for(int[] arr : map) {
            for(int a: arr){
                sb.append(a).append(" ");
            }

            sb.append("\n");
        }


        System.out.println(sb);

    }


    void rotate() {
        
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};

        int n = map.length;
        int m = map[0].length;

        //작은 수가 짝수
        int min = Math.min(n, m);

        for(int i = 0; i < min/2; i++) {
            int x = i;
            int y = i;

            int tmp = map[y][x];

            int idx = 0;
            while(idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if(ny >= n-i || ny < i || nx >= m -i || nx < i) {
                    idx++;
                    continue;
                }

                map[y][x] = map[ny][nx];
                y = ny;
                x = nx;
            }
            map[i + 1][i] = tmp;
        }
    }
}
