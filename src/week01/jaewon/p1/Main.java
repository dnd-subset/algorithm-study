import java.io.*;
import java.util.*;

/*
 * 메모리: 14768 kb
 * 시간: 112 ms
 *
 * 0, 0에서 시작해 N - 1, M - 1인 지점까지 BFS 탐색
 */

public class Main {
    StringBuilder rsb = new StringBuilder();
    int N, K;
    boolean[][] table;
    boolean[][] visited;

    private void solve() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        K = Integer.parseInt(tokens[1]);

        table = new boolean[N][K];
        visited = new boolean[N][K];

        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int k = 0; k < K; ++k) {
                table[i][k] = line.charAt(k) == '1';
            }
        }
        System.out.println(bfs());
    }

    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 2 }); // 시작 + 끝 위치 포함한 비용(2)
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int nextLine = cur[0] + d[0];
                int nextCol = cur[1] + d[1];
                if (nextLine == N - 1 && nextCol == K - 1) {
                    return cur[2];
                }
                if (nextLine < 0 || nextLine >= N || nextCol < 0 || nextCol >= K)
                    continue;
                if (visited[nextLine][nextCol])
                    continue;
                if (!table[nextLine][nextCol])
                    continue;
                visited[nextLine][nextCol] = true;
                q.add(new int[] { nextLine, nextCol, cur[2] + 1 });
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}
