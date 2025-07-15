package week10.sunghee.p6;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;

        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = n -1; i >= 0; i--) {
            //작거나 같으면 제거
            while(!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            //가장 가까운 큰 수 있으면 추가, 없으면 -1
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        return answer;
    }

}
