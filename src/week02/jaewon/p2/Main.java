import java.io.*;
import java.util.*;

/*
	* 문제 링크 : https://www.acmicpc.net/problem/7562
	* 메모리 : 73652 kb
	* 시간 : 268 ms
*/
/*
 	BFS, 한점에서 다른 점으로 이동하는 최단 횟수
 */

public class Main {
    int N;
    int l, c, tL, tC;

    void solve() throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            String[] tokens = br.readLine().split(" ");
            l = Integer.parseInt(tokens[0]);
            c = Integer.parseInt(tokens[1]);
            tokens = br.readLine().split(" ");
            tL = Integer.parseInt(tokens[0]);
            tC = Integer.parseInt(tokens[1]);
            System.out.println(bfs());
        }
    }

    int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new int[] { l, c, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == tL && cur[1] == tC) {
                return cur[2];
            }
            for (int[] d : dirs) {
                int nl = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nl < 0 || nl >= N || nc < 0 || nc >= N)
                    continue;
                if (visited[nl][nc])
                    continue;

                q.add(new int[] { nl, nc, cur[2] + 1 });
                visited[nl][nc] = true;
            }
        }
        return -1;
    }

    int[][] dirs = {
            { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }
    };

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}
