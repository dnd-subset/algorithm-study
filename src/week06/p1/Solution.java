package week06.p1;

import java.util.*;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 테스트 1  〉	통과 (0.46ms, 77.1MB)
 * 테스트 2  〉	통과 (0.94ms, 76.7MB)
 * 테스트 3  〉	통과 (0.61ms, 77.6MB)
 * 테스트 4  〉	통과 (0.41ms, 78.4MB)
 * 테스트 5  〉	통과 (0.99ms, 77.3MB)
 * 테스트 6  〉	통과 (0.47ms, 82.7MB)
 * 테스트 7  〉	통과 (0.50ms, 79MB)
 * 테스트 8  〉	통과 (0.71ms, 77.9MB)
 * 테스트 9  〉	통과 (0.37ms, 76.1MB)
 * 테스트 10 〉	통과 (0.46ms, 66.8MB)
 * 테스트 11 〉	통과 (0.84ms, 73MB)
 * 테스트 12 〉	통과 (0.38ms, 72.6MB)
 * 테스트 13 〉	통과 (0.93ms, 75.1MB)
 * 테스트 14 〉	통과 (0.35ms, 72.5MB)
 * 테스트 15 〉	통과 (0.38ms, 75.9MB)
 * 테스트 16 〉	통과 (0.42ms, 75.3MB)
 * 테스트 17 〉	통과 (0.72ms, 75.6MB)
 * 테스트 18 〉	통과 (0.47ms, 72.5MB)
 * 테스트 19 〉	통과 (0.71ms, 78MB)
 * 테스트 20 〉	통과 (0.45ms, 75.6MB)
 */

/**
 * 풀이
 * 1. 우선 순위로 큐 정렬
 * 2. 정렬한 큐의 제일 위의 값과 priorities의 i에 해당하는 값이 같으면 poll하고 answer++함
 * 3. i의 값이 구하고 싶은 프로세스 위치일 경우 answer값을 리턴
 */

class Solution {
    
    public int solution(int[] priorities, int location) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p : priorities) {
            q.offer(p);
        }
        
        int answer = 0;
        
        while(!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == q.peek()) {
                    q.poll();
                    answer++;
                    
                    if(i == location) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}
