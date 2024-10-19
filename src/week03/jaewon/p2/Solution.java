/*
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * DFS로 탐색하며 target 수가 될 수 있는 경우의 수를 더함
*/

class Solution {
    private int N;
    private int[] numbers;
    private int target;
    private int count = 0;

    private void dfs(int index, int sum) {
        if (index == N) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        N = numbers.length;
        dfs(0, 0);
        return count;
    }
}
