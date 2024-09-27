import java.io.*;
import java.util.*;

/**
 * 148016 kb
 * 672 ms
 * 
 * - 익은 토마토 위치(line, col, height)를 큐에 저장
 * - 큐에서 하나씩 꺼내며 주변 토마토 상태(동, 서, 남, 북, 윗 칸, 아래 칸)를 익음으로 변경
 *   - 새로 익은 토마토는 시간 숫자를 1 늘리고, 큐에 추가
 * - 큐가 비거나(접근 가능한 모든 토마토 순회 완료),
 *   다 익을 때까지 반복
 */

public class Main {
    StringBuilder rsb = new StringBuilder();
    int N, K, H;

    int[][][] tomatoes;
    boolean[][][] visited;

    Queue<int[]> q = new LinkedList<>();
    int greenCnt = 0; // 덜 익은 토마토 개수

    private void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        K = Integer.parseInt(tokens[0]);
        N = Integer.parseInt(tokens[1]);
        H = Integer.parseInt(tokens[2]);

        tomatoes = new int[H][N][K];
        visited = new boolean[H][N][K];

        for (int h = 0; h < H; ++h) {
            for (int i = 0; i < N; ++i) {
                tokens = br.readLine().split(" ");
                for (int k = 0; k < K; ++k) {
                    tomatoes[h][i][k] = Integer.parseInt(tokens[k]);
                    if (tomatoes[h][i][k] == 0) {
                        greenCnt++;
                    } else if (tomatoes[h][i][k] == 1) {
                        q.add(new int[] { i, k, h, 0 });
                    }
                }
            }
        }

        int currentT = 0;

        while (greenCnt > 0) {
            while (!q.isEmpty() && q.peek()[3] == currentT) {
                changeNearby();
            }
            if (q.isEmpty() && greenCnt > 0) {
                System.out.println(-1);
                return;
            }
            currentT++;
        }

        System.out.println(currentT);
    }

    // line, col, h
    int[][] dirs = { { 1, 0, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

    void changeNearby() {
        if (q.isEmpty())
            return;

        int[] cur = q.poll();
        for (int[] d : dirs) {
            int nextLine = cur[0] + d[0];
            int nextCol = cur[1] + d[1];
            int nextHeight = cur[2] + d[2];

            if (nextLine < 0 || nextLine >= N || nextCol < 0 || nextCol >= K || nextHeight < 0 || nextHeight >= H)
                continue;
            if (visited[nextHeight][nextLine][nextCol])
                continue;
            if (tomatoes[nextHeight][nextLine][nextCol] != 0)
                continue;
            visited[nextHeight][nextLine][nextCol] = true;
            tomatoes[nextHeight][nextLine][nextCol] = 1; // change tomato
            greenCnt--;
            q.add(new int[] { nextLine, nextCol, nextHeight, cur[3] + 1 });
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}
