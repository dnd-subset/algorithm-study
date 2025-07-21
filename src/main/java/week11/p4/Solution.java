package week11.p4;

import java.util.Stack;

class Solution {
	public int solution(int[] order) {
		//박스 초기화
		int[] boxes = new int[order.length];
		Stack<Integer> stk = new Stack<>();
		int boxInd = 0,cnt = 0;

		for (int i=0;i<order.length;i++)
			boxes[i] = i+1;


		for (int orderInd=0;orderInd<order.length;orderInd++){
			int target = order[orderInd];
			if (!stk.isEmpty()&&stk.peek()==target){ //타깃이 스택 상단에 있을 경우
				stk.pop(); cnt++;
				continue;
			}
			while (boxInd<order.length&&boxes[boxInd]!=target){//타깃을 찾을 때까지 스택에 삽입
				stk.push(boxes[boxInd]);
				boxInd++;
			}
			if (boxInd<order.length&&boxes[boxInd]==target){
				cnt++; boxInd++;
			}
			else break;
		}

		return cnt;
	}
}
