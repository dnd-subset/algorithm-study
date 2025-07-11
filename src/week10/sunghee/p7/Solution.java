package week10.sunghee.p7;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */
class Solution {
    public int solution(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees)
            .map(s -> s.replaceAll("[^"+skill+"]", ""))
            .filter(skill::startsWith)
            .count();
    }
}
