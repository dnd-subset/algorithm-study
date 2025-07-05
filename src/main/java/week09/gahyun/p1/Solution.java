package week09.gahyun.p1;

/*
왼쪽에 작은거 두개 추출해서 다시 삽입 -> 우선순위 큐 사용
길이 2이상이므로 pq.empty()일 수 없음 -> isEmpty() 검사 안해도 됨

헷갈린 부분: 처음부터 조건을 만족할 수 있음 - 해당 조건문을 먼저 검사
 */

import java.util.*;
class Solution {
	public int solution(int[] scoville, int K) {
		int cnt = 0;
		Queue<Long> pq = new PriorityQueue<>();
		for (long x : scoville){
			pq.offer(x);
		}
		while(true){
			if (pq.peek()>=K) break; // 모든 음식 스코빌 지수 k이상
			if (pq.size()<=1) return -1; //더 이상 섞을 수 없음
			long n1 = pq.poll();
			long n2 = pq.poll();
			pq.offer(n1+n2*2);
			cnt++;
		}
		return cnt;
	}
}