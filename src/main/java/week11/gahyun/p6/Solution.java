package week11.gahyun.p6;

import java.util.*;

/**문제 요약
 * 	- 알파벳으로 단어 초기화
 * 	- 단어 일정 부분 자르기
 *     - 해당 단어 있으면 한 글자 더해서 새로운 단어 만듦
 * 	- 기존 단어의 사전 번호 출력
 * 	- 새로운 단어 사전에 저장
 * 헷갈린 점
 * - w+=c를 하는 게 아니라 nextIdx계속 더해서 substring하기
 */
class Solution {
	public int[] solution(String msg) {
		Map<String, Integer> dict = new HashMap<>();
		List<Integer> output = new ArrayList<>();
		initDict(dict);
		int curIdx = 0, dictIdx=27;

		while (curIdx<msg.length()){
			int nextIdx = curIdx+1;
			String w = ""+msg.charAt(curIdx);
			while (nextIdx<=msg.length()&&dict.containsKey(msg.substring(curIdx,nextIdx))){
				w = msg.substring(curIdx,nextIdx);
				nextIdx++;
			}
			output.add(dict.get(w)); // 기존 단어 찾기

			if (nextIdx<=msg.length())
				dict.put(msg.substring(curIdx,nextIdx),dictIdx++); //새로운 단어 추가
			curIdx += w.length();
		}

		int[] answer = new int[output.size()];
		for (int i=0;i<output.size();i++){
			answer[i] = output.get(i);
		}

		return answer;
	}

	private static void initDict(Map<String, Integer> dict){
		int dictIdx = 1;
		for (char c = 'A';c<='Z';c++){
			dict.put(c+"",dictIdx++);
		}
	}
}
