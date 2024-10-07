package week02.gahyun.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	* 문제 링크 : https://www.acmicpc.net/problem/7562
	* 메모리 : 72724 KM
	* 시간 : 268 ms
	*/
/*
 	최단 경로 -> BFS
 	각 레벨이 이동 횟수
 */

public class Main {
	static int n, x1, x2, y1, y2;
	static int[][] graph;
	static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};

	public static void main(String[] args) throws IOException {
		int tries;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tries = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < tries; i++) {
			n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			BFS();
			System.out.println(graph[y2][x2]); // 목표 지점 레벨
		}
	}

	public static void BFS() {
		boolean[][] visited = new boolean[n][n];
		graph = new int[n][n];
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(x1, y1));
		visited[y1][x1] = true;
		while (!queue.isEmpty()) {
			Pos cp = queue.remove();
			for (int i = 0; i < 8; i++) {
				int nx = cp.x + dx[i];
				int ny = cp.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx]) {
					queue.offer(new Pos(nx, ny));
					visited[ny][nx] = true;
					graph[ny][nx] = graph[cp.y][cp.x] + 1;
				}
				if (graph[y2][x2]!=0) return; // 목표 지점 도착 시 종료 -> 메모리 절약
			}

		}
	}
}

class Pos {
	int x, y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
