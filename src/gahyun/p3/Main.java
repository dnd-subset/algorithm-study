package gahyun.p3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
	- 문제 링크: https://www.acmicpc.net/problem/7569
	- 메모리: 330176KB
	- 시간: 1524ms
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
	static Queue<Pos> queue = new LinkedList<>(); //main에서도 쓰인
	// 이동 가능한 좌표
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {-1, 1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	static int h, n, m;

	static void BFS() {
		while (!queue.isEmpty()) {
			Pos cp = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nx = cp.x + dx[i];
				int ny = cp.y + dy[i];
				int nz = cp.z + dz[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && graph[nz][nx][ny] == 0) {
					graph[nz][nx][ny] = 1;
					queue.offer(new Pos(nx, ny, nz));
					dis[nz][nx][ny] = dis[cp.z][cp.x][cp.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt(); // 열
		n = sc.nextInt(); // 행
		h = sc.nextInt(); // 높이

		graph = new int[h][n][m];
		dis = new int[h][n][m];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					graph[k][i][j] = sc.nextInt();
					if (graph[k][i][j] == 1) {
						queue.offer(new Pos(i, j, k));
					}
				}
			}
		}
		BFS();
		boolean flag = true; // 사과 익었는지 여부

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[k][i][j] == 0) {
						flag = false;
						break;
					}
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		if (flag) {
			for (int k = 0; k < h; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						ans = Math.max(ans, dis[k][i][j]);
					}
				}
			}
			System.out.println(ans);
		} else {
			System.out.println(-1);
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
