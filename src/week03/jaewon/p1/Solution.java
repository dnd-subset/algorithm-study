import java.io.*;
import java.util.*;

/*
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 패턴 길이 만큼 반복하며 정답 개수 확인
 * 정답이 제일 큰 학생들 인덱스 반환
*/

public class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = { 1, 2, 3, 4, 5 };
        int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int count1 = 0, count2 = 0, count3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length])
                count1++;
            if (answers[i] == pattern2[i % pattern2.length])
                count2++;
            if (answers[i] == pattern3[i % pattern3.length])
                count3++;
        }

        int[] counts = { count1, count2, count3 };
        int maxCount = Math.max(counts[0], Math.max(counts[1], counts[2]));
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxCount) {
                answerList.add(i + 1);
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
