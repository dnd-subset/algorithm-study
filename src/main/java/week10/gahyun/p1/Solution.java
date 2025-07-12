package week10.gahyun.p1;

/**
 * 완전 탐색인데 조건 존재 -> 백트래킹
 * 함수 파라미터에 남은 피로도 계산
 * 파라미터로 넣지 않으면 DFS 호출 전후로 +-해야 함
 * 최소 피로도 만족하지 않을 경우 가지치기
 * 개수가 정해져 있지 않고, 최대값만 넣으면 됨 cnt 비교해서 가지치는 건 필요없음
 */
class Solution {
	static int[] cost, limit;
	static boolean[] visited;
	static int len, result;

	public int solution(int k, int[][] dungeons) {
		len = dungeons.length;
		cost = new int[len];
		limit = new int[len];
		visited = new boolean[len];
		for (int i=0;i<dungeons.length;i++){
			limit[i] = dungeons[i][0];
			cost[i] = dungeons[i][1];
		}

		DFS(0,k);
		return result;
	}

	private static void DFS(int cnt, int remain){
		result = Math.max(result, cnt);

		for (int i=0;i<len;i++){
			if (visited[i]) continue;
			if (remain<limit[i]) { //최소 피로도 만족x
				continue;
			}
			visited[i] = true;
			DFS(cnt+1,remain-cost[i]);
			visited[i] = false;
		}
	}
}
