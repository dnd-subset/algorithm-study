package week06.gahyun.p1;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 테스트 1 〉	통과 (2.69ms, 80MB)
 * 테스트 2 〉	통과 (3.57ms, 74MB)
 * 테스트 3 〉	통과 (3.15ms, 73.6MB)
 * 테스트 4 〉	통과 (3.58ms, 76.4MB)
 * 테스트 5 〉	통과 (5.11ms, 90.4MB)
 */

/**
 * V에 인덱스와 우선순위 함께 저장 -> queue에 삽입
 * 우선순위 내림차순 정렬
 * 우선순위 하나씩 꺼내면서 queue에 저장된 v.pri와 비교
 	* 같음 -> queue에서 꺼내고 v.ind 위치에 실행 순서 저장
 	* 다름 -> queue에 다시 삽입
 */
class Solution {
	public int solution(int[] priorities, int location) {
		int[] order = new int[priorities.length]; // 프로세스 실행 순서 저장
		Queue<V> que = new LinkedList<>();

		for (int i=0;i<priorities.length;i++){
			que.offer(new V(i,priorities[i]));
		}

		Integer[] sortedPri = Arrays.stream(priorities)
			.boxed().toArray(Integer[]::new);
		Arrays.sort(sortedPri, Collections.reverseOrder()); // 우선순위 내림차순 정렬

		int runCnt = 0;
		while(!que.isEmpty()){
			V v = que.poll();
			if (v.pri==sortedPri[runCnt]){
				order[v.ind] = ++runCnt;
			} else {
				que.offer(v);
			}

		}
		return order[location];
	}
}

class V {
	int ind; // 프로세스 인덱스
	int pri; // 프로세스 우선순위

	public V(int ind, int pri){
		this.ind = ind;
		this.pri = pri;
	}
}