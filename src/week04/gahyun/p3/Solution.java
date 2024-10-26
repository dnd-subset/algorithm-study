package week04.gahyun.p3;
/**
 https://school.programmers.co.kr/learn/courses/30/lessons/60057
 시간, 메모리:
 테스트 1 〉	통과 (0.10ms, 75.4MB)
 테스트 2 〉	통과 (0.39ms, 75MB)
 테스트 3 〉	통과 (0.21ms, 74.5MB)
 테스트 4 〉	통과 (0.11ms, 76.9MB)
 테스트 5 〉	통과 (0.03ms, 76.2MB)
 */

/**
 * l에 따라 압축되는 길이 구해서 최소 길이 구하기
 * target==cur?
 	* O -> cnt++;
 	* X -> 이전 cnt, target 더해주기; cnt, target 갱신
 * 마지막 문자열 더해주기
 */
class Solution {
	public static void main(String[] args) {
		String s = "ababcdcdababcdcd";
		int answer = s.length(); // 문자열 줄이지 못하는 경우

		for (int l = 1; l <= s.length() / 2; l++) { // 자르는 단위
			StringBuilder sb = new StringBuilder();
			int cnt = 1; // 연속으로 몇 번 일치하는지
			String target = s.substring(0, l);

			for (int i = l; i < s.length(); i += l) {
				String cur = s.substring(i, Math.min(i + l, s.length()));
				if (target.equals(cur)) {
					cnt++;
				} else {
					if (cnt == 1) { // 이전에 연속되지 않았을 경우
						sb.append(target);
					} else { // 연속된 경우
						sb.append(cnt).append(target);
					}
					target = cur;
					cnt = 1;
				}
			}
			if (cnt == 1) { // 이전에 연속되지 않았을 경우
				sb.append(target);
			} else { // 연속된 경우
				sb.append(cnt).append(target);
			}
			answer = Math.min(sb.length(), answer);
		}

		System.out.println(answer);
	}
}
