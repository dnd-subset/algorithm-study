package week03.sunghee.p2;


/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/431650
 *테스트 1 〉 (4.33ms, 77.6MB)
 *테스트 2 〉 (6.52ms, 78.6MB)
 *테스트 3 〉 (0.18ms, 74.6MB)
 *테스트 4 〉 (0.34ms, 74.9MB)
 *테스트 5 〉 (0.67ms, 73.5MB)
 *테스트 6 〉 (0.32ms, 74.2MB)
 *테스트 7 〉 (0.22ms, 77MB)
 *테스트 8 〉 (0.42ms, 74.3MB)
 */

/**
 * dfs 구현
 * depth가 numbers 길이와 같을 때 종료
 * sum과 target이 같으면 1, 다르면 0을 반환
 * numbers의 값을 더할 경우와 뺄 경우로 나눠서 dfs 각각 호출
 * 각각의 경우의 리턴 값을 더해서 리턴
 */

public class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, target, depth + 1, sum + numbers[depth]) +
            dfs(numbers, target, depth + 1,sum - numbers[depth]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new Solution().solution(new int[]{4, 1, 2, 1}, 4));
    }
}
