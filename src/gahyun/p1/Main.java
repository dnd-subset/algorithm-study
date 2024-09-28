package gahyun.p1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
	- 문제 링크: https://www.acmicpc.net/problem/2178
	- 메모리: 19064KB
 	- 시간: 204ms
 */
/*
	- BFS 탐색
	- x,y 좌표 가지는 Pos
	- 큐에서 현재 노드의 좌표 추출
	- 현재 노드로부터 유효한 상하좌우 노드 거리 계산(현 노드 거리 + 1) 및 큐에 저장
 */
public class Main {
	static int[][] graph, dis;
	static int n, m;
	// 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void BFS() {
		Queue<Pos> queue = new LinkedList<>();
		//시작 노드 방문
		queue.offer(new Pos(0, 0));
		dis[0][0] = 1;
		graph[0][0] = 0;

		while (!queue.isEmpty()) {
			Pos cp = queue.poll(); //현재위치
			for (int i = 0; i < 4; i++) { //상하좌우
				int nx = cp.x + dx[i];
				int ny = cp.y + dy[i];
				if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= m - 1 && graph[nx][ny] == 1) {
					graph[nx][ny] = 0; //방문
					dis[nx][ny] = dis[cp.x][cp.y] + 1; //이전거리+1
					queue.offer(new Pos(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		graph = new int[n][m]; //이동가능여부
		dis = new int[n][m]; //거리

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}

		BFS();
		System.out.println(dis[n-1][m-1]);
	}
}

//x,y 좌표
class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
