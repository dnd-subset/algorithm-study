package week01.gahyun.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	- 문제 링크: https://www.acmicpc.net/problem/7569
	- 메모리: 125604KB
	- 시간: 592ms
 */
/*
	- BFS 탐색 로직은 1번과 동일, 차원만 증가
	- BFS 호출 전 : graph 순회하며 1인 지점 -> queue 삽입
	- BFS 호출 중 : 상하좌우 이동하며 0인 지점 1로 바꾸고 queue 삽입
	- BFS 호출 후 : graph 하나라도 0이면 사과 안 익음 -> -1 출력
				  모두 익음 -> 최대 거리(=일수) 출력
 */
public class Main {
	static int[][][] graph, dis;
	static Queue<Pos> queue = new LinkedList<>(); //main에서도 쓰임
	// 이동 가능한 좌표
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {-1, 1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	static int h, n, m, remain;

	static void BFS() {
		while (!queue.isEmpty()) {
			Pos cp = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nx = cp.x + dx[i];
				int ny = cp.y + dy[i];
				int nz = cp.z + dz[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && graph[nz][nx][ny] == 0) {
					graph[nz][nx][ny] = 1;
					remain--;
					queue.offer(new Pos(nx, ny, nz));
					dis[nz][nx][ny] = dis[cp.z][cp.x][cp.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 열
		n = Integer.parseInt(st.nextToken()); // 행
		h = Integer.parseInt(st.nextToken()); // 높이

		graph = new int[h][n][m];
		dis = new int[h][n][m];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					graph[k][i][j] = Integer.parseInt(st.nextToken());
					if (graph[k][i][j]==0) remain++;
					if (graph[k][i][j] == 1) {
						queue.offer(new Pos(i, j, k));
					}
				}
			}
		}
		BFS();

		int ans = 0;
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					ans = Math.max(ans, dis[k][i][j]);
				}
			}
		}

		if (remain >0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}

class Pos {
	int x, y, z;

	public Pos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
