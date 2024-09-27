import java.io.*;
import java.util.*;

/**
 * 18392 kb
 * 136 ms
 * 
 * - 2차원 배열인 table 생성 후 입력 값 저장 (white면 true)
 * - 2차원 배열을 순회하며 방문하지 않은 칸이라면 bfs 탐색
 * - 탐색 후 (방문한 칸수)^2를 색상 결과 변수(whiteCnt, blackCnt)에 추가
 */
public class Main {
    StringBuilder rsb = new StringBuilder();
    int N, K;
    boolean[][] table; // W is true
    boolean[][] visited;
    int whiteCnt, blackCnt;

    private void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        K = Integer.parseInt(tokens[0]);
        N = Integer.parseInt(tokens[1]);

        table = new boolean[N][K];
        visited = new boolean[N][K];

        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int k = 0; k < K; ++k) {
                table[i][k] = line.charAt(k) == 'W';
            }
        }
        
        for (int i = 0; i < N; ++i) {
            for (int k = 0; k < K; ++k) {
                if (!visited[i][k]) {
                    int n = bfs(i, k);
                    if (table[i][k]) { // White
                        whiteCnt += n * n;
                    } else {
                        blackCnt += n * n;
                    }
                }
            }
        }
        System.out.println(whiteCnt + " " + blackCnt);
    }

    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    int bfs(int line, int col) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { line, col });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            for (int[] d : dirs) {
                int nextLine = cur[0] + d[0];
                int nextCol = cur[1] + d[1];

                if (nextLine < 0 || nextLine >= N || nextCol < 0 || nextCol >= K)
                    continue;
                if (visited[nextLine][nextCol])
                    continue;
                if (table[nextLine][nextCol] != table[line][col])
                    continue;

                visited[nextLine][nextCol] = true;
                q.add(new int[] { nextLine, nextCol });
            }
        }
        if (cnt == 1) // 1 * 1이라면 1 반환
            return 1;
        return cnt - 1;
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}
