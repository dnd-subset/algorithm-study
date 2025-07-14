package week10.sunghee.p9;

import java.util.*;

/**
 * dp[1] ~ dp[8]까지의 각 단계에서 만들 수 있는 숫자를 저장
 * i단계에서 j, i-j로 나눠서 만들 수 있는 숫자들을 연산 조합
 * i단계에서 number가 만들어졌으면 i 리턴
 * 끝까지 못 만들면 -1 리턴
 */
public class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        //dp[i] = N을 i번 사용해서 만들 수 있는 수들의 집합
        Set<Integer>[] dp = new HashSet[9];

        for(int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();

            //같은 숫자 반복해서 붙인 숫자
            int repeatedNum = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(repeatedNum);

            // j번 + (i-j)번 조합
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                    }
                }
            }

            // number가 현재 단계에서 만들어졌는지 확인
            if(dp[i].contains(number)) return i;
        }

        return -1;
    }
}
