package week10.sunghee.p8;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 * 처음엔 dfs로 풀다 시간 초과 -> dp로 풀기(해설 보고)
 */

class Solution {

    int solution(int[][] land) {
        int n = land.length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;
                for(int k = 0; k < 4; k++) {
                    if(k == j) continue;
                    max = Math.max(max, land[i-1][k]);
                }
                land[i][j] += max;
            }
        }

        return Arrays.stream(land[n-1])
            .max().orElse(0);
    }

}
