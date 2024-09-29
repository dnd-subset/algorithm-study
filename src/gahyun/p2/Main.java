package gahyun.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	- 문제 링크: https://www.acmicpc.net/problem/1303
	- 메모리: 16280KB
	- 시간: 132ms
 */
/*
	- 색깔 그래프 순회
	- DFS 탐색으로 연속된 영역 개수 세기
		- 매 호출마다 cnt++
		- 연속된 부분 있는지 탐색
	- 탐색 완료 후 cnt^2 더하기
 */
public class Main {
	static char[][] graph;
	static int[][] visited;
	static int cnt = 0, totalW = 0, totalB = 0;
	static int n, m;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void DFS(int x, int y, char t) {
		visited[x][y] = 1; // 현재 위치 방문
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[nx][ny] == t && visited[nx][ny] == 0) {
				DFS(nx, ny, t); // 연속된 영역 탐색
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //열
		m = Integer.parseInt(st.nextToken()); //행
		graph = new char[m][n];
		visited = new int[m][n];

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					if (graph[i][j] == 'W') {
						cnt = 0; // 개수 초기화
						DFS(i, j, 'W');
						totalW += cnt * cnt; //연속된 영역 개수^2
					} else { //'B'
						cnt = 0;
						DFS(i, j, 'B');
						totalB += cnt * cnt;
					}
				}
			}
		}

		System.out.println(totalW + " " + totalB);
	}
}
