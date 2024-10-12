package week03.gahyun.p3;

import java.util.*;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 메모리 : 	81.1MB
 * 시간 : 0.54ms
 */

/**
 * 방문 안한 그래프 BFS 탐색
 * 탐색 마친 후 네트워크 수 증가시키기
 * 인접행렬 computers[i][i]도 1로 표시되므로 방문 시 제외해야 함
 */
class Solution {
	static boolean[] visited;
	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		for (int i=0;i<n;i++){
			if (!visited[i]){
				BFS(i,computers); // 한 네트워크
				answer++;
			}

		}
		return answer;
	}

	public static void BFS(int v, int[][] computers){
		Queue<Integer> que = new LinkedList<>();
		que.offer(v);
		visited[v] = true;
		while (!que.isEmpty()){
			int cur = que.poll();
			for (int i = 0;i<computers[0].length;i++){
				if (!visited[i]&&i!=cur&&computers[cur][i]==1){// 방문하지 않음&자기자신 아님&인접함
					que.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
