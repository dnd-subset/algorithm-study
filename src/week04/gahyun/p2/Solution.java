package week04.gahyun.p2;

import java.util.*;

/**
 https://school.programmers.co.kr/learn/courses/30/lessons/43163
 시간, 메모리:
 테스트 1 〉	통과 (0.29ms, 77.8MB)
 테스트 2 〉	통과 (0.54ms, 80.2MB)
 테스트 3 〉	통과 (0.37ms, 81.5MB)
 테스트 4 〉	통과 (0.30ms, 67.6MB)
 테스트 5 〉	통과 (0.06ms, 72MB)
 */

/**
 * BFS 탐색
 * 단어, 변환 수 저장하는 클래스 만들어서 큐에 삽입
 	* 문자열 요소 비교해서 하나만 다른지 확인
 	* 하나만 다르고, 기존 방문 내역 없으면 큐에 삽입
   		* 변환한 단어가 타켓과 같으면 큐에 삽입 전 바로 반환
 		* 기존 변환 수에서 1증가 시키기
 */
class Solution {
	public int solution(String begin, String target, String[] words) {
		if (!Arrays.asList(words).contains(target)) return 0; //배열에 target있는지 검증
		return BFS(begin, target, words);
	}

	public int BFS(String begin, String target, String[] words){
		Queue<WordDis> q = new LinkedList<>();
		q.offer(new WordDis(begin, 0));
		boolean[] visited = new boolean[words.length]; // 방문 여부

		while (!q.isEmpty()){
			WordDis cur = q.poll();

			for (int i=0;i<words.length;i++){ //words에 대해 반복
				String word = words[i];
				if (visited[i]) continue; // 한번만 방문

				if (isDifferOne(cur.word, word)) {
					if (word.equals(target)) return cur.dis+1; //큐에 넣지 말고 바로 반환
					q.offer(new WordDis(word, cur.dis+1));
					visited[i] = true;
				}
			}
		}
		return 0;
	}

	// 문자열에서 하나의 문자만 다른지 여부 반환
	public boolean isDifferOne(String cmp, String target){
		int cnt = 0;
		for (int i=0;i<cmp.length();i++){
			if (cmp.charAt(i)!=target.charAt(i)){
				cnt++;
				if (cnt>1) return false;
			}
		}
		if (cnt==1) return true;
		return false;
	}
}

class WordDis{
	String word; // 단어
	int dis; // 변환 수
	public WordDis(String word, int dis){
		this.word = word;
		this.dis = dis;
	}
}
