package week09.sunghee.p1;

import java.util.*;


public class Solution {
    public int solution(int[] scoville, int K) {
        //우선 순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int s : scoville) {
            queue.add(s);
        }
        int answer = 0;

        while(queue.peek() < K) {
            if(queue.size() == 1) {
                return -1;
            }

            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }

        return answer;
    }
}
