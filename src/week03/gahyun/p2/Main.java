package week03.gahyun.p2;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 메모리 : 	75.2MB
 * 시간 : 4.52ms
 */

/**
 * DFS
 * 값 +- 여부로 분기처리되는 트리 형태 (->전위순회)
 * 각 레벨 진행될 때마다 배열값 더하거나 뺌
 * 리프 노드에서 총합이 타겟 넘버면 카운트 증가
 */
class Solution {
	static int answer = 0;
	public int solution(int[] numbers, int target) {
		DFS(0, 0, numbers, target);
		return answer;
	}
	public static void DFS(int lv, int total, int[] arr, int target){
		if (lv==arr.length){
			if (total==target) {
				answer++;
			}
		} else {
			DFS(lv+1, total+arr[lv], arr, target);
			DFS(lv+1, total-arr[lv], arr, target);
		}
	}
}
