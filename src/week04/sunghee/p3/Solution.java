package week04.sunghee.p3;

/*
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * 테스트 1 〉	통과 (0.07ms, 77MB)
 */

public class Solution {
    public int solution(String s) {
        int answer = s.length();

        //단어 단위가 단어길의의 절반을 넘어가면 2번이상 반복하지 않기 때문에 소용 없음
        for (int i = 1; i <= s.length()/2; i++) {
            //비교 시 현재 단어
            String nowStr = s.substring(0, i);
            //단어 count, s.substring(0, i)에 대해서 미리 cnt +1
            int cnt = 1;

            //압축한 단어
            StringBuilder resultStr = new StringBuilder();

            //단어 비교하며 단어 압축
            for (int j = i; j <s.length(); j += i) {

                int endIdx = Math.min(j + i, s.length());
                //비교할 다음 단어
                String nextStr = s.substring(j ,endIdx);

                if (nowStr.equals(nextStr)) {
                    //현재 단어랑 다음 단어랑 같을 시 cnt++
                    cnt++;
                } else {
                    //다르면
                    if (cnt > 1) {
                        //cnt가 1보다 크면 cnt 앞축한 단어에 append
                        resultStr.append(cnt);
                    }
                    //단어 append
                    resultStr.append(nowStr);

                    nowStr = nextStr;
                    cnt = 1;
                }

            }
            //마지막 단어 append
            if (cnt > 1) {
                resultStr.append(cnt);
            }
            resultStr.append(nowStr);


            answer = Math.min(answer, resultStr.length());


        }

        return answer;
    }
}
