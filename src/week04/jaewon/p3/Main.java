/*
    문제 링크 : https://www.acmicpc.net/problem/60057
    시간, 메모리:
    테스트 1 〉	통과 (0.08ms, 75.8MB)
    테스트 2 〉	통과 (0.54ms, 79MB)
    테스트 3 〉	통과 (0.31ms, 84.2MB)
    테스트 4 〉	통과 (0.09ms, 73.5MB)
    테스트 5 〉	통과 (0.02ms, 75.4MB)
 */

/**
 * 문자 단위 개수 당 이전에 등장한 문자열과 동일한지 비교
 * 비교후, 같다면 streak 1 증가
 *       다르면 길이 cnt 변수에 현재 문자 단위 길이와 streak 길이 만큼 추가하고, streak 1로 초기화
 * 마지막에는 streak 숫자에 해당하는 문자열 길이 추가
 */

class Solution {

    int compress(String str, int tokenLen) {
        int streak = 1;
        int cnt = 0;
        String prev = "";

        for (int i = 0; i < str.length(); i += tokenLen) {
            String token = str.substring(i, Math.min(i + tokenLen, str.length()));
            if (prev.equals(token)) {
                streak++;
            } else {
                if (streak != 1) {
                    cnt += String.valueOf(streak).length();
                    streak = 1;
                }
                cnt += token.length();
                prev = token;
            }
        }
        if (streak != 1) {
            cnt += String.valueOf(streak).length();
        }
        return cnt;
    }

    public int solution(String s) {
        int answer = compress(s, 1);
        for (int i = 2; i < s.length(); ++i) {
            answer = Math.min(answer, compress(s, i));
        }
        return answer;
    }
}
