package week10.gahyun.p4;

/**
 * 배운 점
 * - 10진수-> n진수
 * - i) Integer.toString(num, n진법)
 * - ii) sb+=num%n -> num/=n -> sb.reverse.toString()
 *    - n>=10인 경우
 *      기존 방법: map으로 가져오기
 *      더 나은 방법: {0~15}까지 배열 저장 -> arr[n%10]
 */
class Solution {
	public String solution(int n, int t, int m, int p) {

		//0부터 진법 변환해서 더하기
		StringBuilder total = new StringBuilder(); int num = 0;
		while (total.length()<=m*t){
			total.append(Integer.toString(num++, n).toUpperCase());
		}

		//순서에 맞는 숫자 구하기
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<t;i++){
			sb.append(total.charAt(m*i+p-1));
		}

		return sb.toString();
	}
}
