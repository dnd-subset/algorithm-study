package week10.p6;

import java.util.Arrays;
import java.util.Stack;

/**
 * 단조감소스택 값 저장 ver
 * 역방향으로 진행해야 함
 * 참고: https://www.youtube.com/watch?v=Dq_ObZwTY_Q&ab_channel=AlgoMonster
 */
public class SolutionWithValue {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Arrays.fill(answer,-1);
		Stack<Integer> stk = new Stack<>();
		for (int i=numbers.length-1;i>=0;i--){
			while (!stk.isEmpty()&&numbers[i]>=stk.peek()){
				stk.pop();
			}
			if (!stk.isEmpty()) answer[i] = stk.peek();
			stk.push(numbers[i]);
		}
		return answer;
	}
}
