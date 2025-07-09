package week10.p6;

import java.util.Arrays;
import java.util.Stack;

/**
 * 단조스택 감소 (Monotonic Stack Decreasing)
 * - 값 저장, 인덱스 저장 두 가지 방법 존재
 *   - 인덱스 저장이 더 활용도 높음 (ex: 기간 구하기)
 * - 스택에는 뒷 큰수 아직 못 만난 인덱스 남음
 *   - 현재 인덱스도 항상 push 됨
 * - 자신보다 작은 모든 이전 인덱스들의 인덱스 확정
 *   - 확정된 인덱스들은 스택에서 pop -> 더이상 필요없음
 */

/**
 * 시행착오
 * - 완전 탐색으로 풀 경우 시간 복잡도 O(N^2) -> 시간 초과
 * - 단조 스택은 시간 복잡도 O(N)으로 풀 수 있음
 */
class SolutionWithIndex {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Arrays.fill(answer,-1);
		Stack<Integer> stk = new Stack<>();

		for (int i=0;i<numbers.length;i++){
			while (!stk.isEmpty()&&numbers[i]>numbers[stk.peek()]){ // 현재 값으로 다른 값들 뒷 큰수 확정
				int ind = stk.pop(); // 확정 지을 인덱스 추출
				answer[ind] = numbers[i]; // 뒷 큰수 확정
			}
			stk.push(i); //현재 인덱스 push
		}

		return answer;
	}
}