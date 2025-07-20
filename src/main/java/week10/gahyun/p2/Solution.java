package week10.gahyun.p2;

/**
 * 접근 방식:
 * - 주식 가격 요소들에 대해 반복
 * - 현재 주식 가격이 뒤 주식 가격보다 크거나 같을 때까지 카운트
 * - 해당 카운트 배열로 저장해서 반환
 */
class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i=0;i<answer.length;i++){
			for (int j=i+1;j<answer.length;j++){
				answer[i]++;
				if (prices[j]<prices[i]) break;
			}
		}
		return answer;
	}
}
