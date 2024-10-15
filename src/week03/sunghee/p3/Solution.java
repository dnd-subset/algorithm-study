package week03.sunghee.p3;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *
 *테스트 1  〉 (0.02ms, 69.3MB)
 *테스트 2  〉 (0.02ms, 76.5MB)
 *테스트 3  〉 (0.03ms, 75.5MB)
 *테스트 4  〉 (0.03ms, 71.9MB)
 *테스트 5  〉 (0.01ms, 72.9MB)
 *테스트 6  〉 (0.11ms, 74.3MB)
 *테스트 7  〉 (0.03ms, 73.2MB)
 *테스트 8  〉 (0.09ms, 73.2MB)
 *테스트 9  〉 (0.04ms, 70.5MB)
 *테스트 10 〉 (0.04ms, 74.8MB)
 *테스트 11 〉 (0.32ms, 84.6MB)
 *테스트 12 〉 (0.18ms, 76.7MB)
 *테스트 13 〉 (0.14ms, 81.4MB)
 *
 */

/**
 * 모든 컴퓨테에 대해 반복
 *      방문하지 않았으면 dfs 호출
 *      한 네트워크의 모든 컴퓨터 방문했음로 answer증가
 * dfs
 * 현재 컴퓨터(start)를 방문 처리
 * 다른 컴퓨터들 확인
 *      자기 자신(start)이 아닌 경우 && 현재 컴퓨터와 연결된 경우 && 방문하지 않았을 경우
 *          해당 컴퓨터에 대해서 다시 dfs 호출
 */

public class Solution {

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers,i);
                answer++;
            }
        }

        return answer;
    }

    void dfs(int[][] computers, int start) {
        visited[start] = true;

        for (int i = 0; i < computers.length; i++) {
            if (start != i && computers[start][i] == 1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[][]{
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        }));
        System.out.println(new Solution().solution(3, new int[][]{
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        }));
    }
}
