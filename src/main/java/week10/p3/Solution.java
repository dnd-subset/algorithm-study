package week10.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * 접근 방식
 * - 수량 계속 관리해야 하므로 map 사용
 * - 처음에 mapB에게 모든 토핑을 할당하고 mapB의 토핑을 뺏어서 mapA에게 주는 방식
 * 헷갈렸던 점
 * - map.get.keySet(x).size()로만 비교하면 수량이 0인 경우까지 카운트됨
 * - 수량이 0이하일 때 map에서 제거해야 함
 */
class Solution {
	public int solution(int[] topping) {
		Map<Integer, Integer> mapA = new HashMap<>();
		Map<Integer, Integer> mapB = new HashMap<>();

		for (int x: topping){
			mapB.put(x,mapB.getOrDefault(x,0)+1);
		}

		int cnt = 0;
		for (int x : topping){
			mapA.put(x,mapA.getOrDefault(x,0)+1);
			mapB.put(x,mapB.get(x)-1);
			if (mapB.get(x)==0) mapB.remove(x); //수량 0개이면 제거

			if (mapA.size()== mapB.size()) cnt++;
		}

		return cnt;
	}
}
