package week04.gahyun.p1;

import java.util.*;
/**
 https://school.programmers.co.kr/learn/courses/30/lessons/43163
 시간, 메모리:
 테스트 1 〉	통과 (0.29ms, 77.8MB)
 테스트 2 〉	통과 (0.54ms, 80.2MB)
 테스트 3 〉	통과 (0.37ms, 81.5MB)
 테스트 4 〉	통과 (0.30ms, 67.6MB)
 테스트 5 〉	통과 (0.06ms, 72MB)
 */

/**
 * BFS 탐색
 * 단어, 변환 수 저장하는 클래스 만들어서 큐에 삽입
 * 문자열 요소 비교해서 하나만 다른지 확인
 * 하나만 다르고, 기존 방문 내역 없으면 큐에 삽입
 * 변환한 단어가 타켓과 같으면 큐에 삽입 전 바로 반환
 * 기존 변환 수에서 1증가 시키기
 */
class Solution {

	static int[][] dis;
	static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int n,m;

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;
		dis = new int[n][m];


		BFS(maps);
		if (dis[n-1][m-1]==0) return -1;
		else return dis[n-1][m-1];
	}

	public static void BFS(int[][] maps){
		Queue<int[]> q = new LinkedList<>();
		dis[0][0] = 1;
		q.offer(new int[]{0,0});

		while (!q.isEmpty()){
			int[] cur = q.poll();
			for (int[] d : move){
				int nx = cur[0]+d[0];
				int ny = cur[1]+d[1];

				if ((nx>=0 && nx<m && ny>=0 && ny<n) &&
					maps[ny][nx]==1 && dis[ny][nx]==0){
					dis[ny][nx] = dis[cur[1]][cur[0]] + 1;
					if (dis[n-1][m-1]>0) return;
					q.offer(new int[]{nx,ny});
				}
			}
		}
	}
}
