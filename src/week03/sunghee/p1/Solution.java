package week03.sunghee.p1;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 테스트 1  〉(4.13ms, 78.3MB)
 * 테스트 2  〉(4.81ms, 82.2MB)
 * 테스트 3  〉(11.37ms, 75MB)
 * 테스트 4  〉(6.62ms, 79.3MB)
 * 테스트 5  〉(5.00ms, 72.9MB)
 * 테스트 6  〉(3.27ms, 76.6MB)
 * 테스트 7  〉(6.22ms, 82.1MB)
 * 테스트 8  〉(3.22ms, 74.3MB)
 * 테스트 9  〉(4.02ms, 68.5MB)
 * 테스트 10 〉(4.23ms, 77.2MB)
 * 테스트 11 〉(4.33ms, 77.6MB)
 * 테스트 12 〉(5.04ms, 79.7MB)
 * 테스트 13 〉(4.27ms, 78.5MB)
 * 테스트 14 〉(4.14ms, 81.6MB)
 */

/**
 * 각 수포자의 반복되는 규칙을 randomAnswers에 저장
 * answers의 길이만큼 반복해서 각 문제별 각 수포자가 해당 문제 정답을 맞췄는지 확인
 *      각 수포자의 정답은 randomAnswers에 저장된 각자의 크기의 나머지로 확인하고
 *      정답과 같으면 score++
 * 각 수포자의 score의 최대 값을 확인하고
 * 최대값과 같은 수포자의 번호를 리턴
 */

public class Solution {

    public int[] solution(int[] answers) {

        int[][] randomAnswers = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if (randomAnswers[0][i % 5] == answers[i]) score[0]++;
            if (randomAnswers[1][i % 8] == answers[i]) score[1]++;
            if (randomAnswers[2][i % 10] == answers[i]) score[2]++;
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        return IntStream.range(0, 3)
            .filter(i -> score[i] == maxScore)
            .map(i -> i + 1).toArray();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1,3,2,4,2})));
    }
}
