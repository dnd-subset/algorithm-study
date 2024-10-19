import java.util.*;

/*
    문제 링크 : https://www.acmicpc.net/problem/43163
    시간, 메모리:
    테스트 1 〉	통과 (0.14ms, 81.8MB)
    테스트 2 〉	통과 (0.23ms, 82.5MB)
    테스트 3 〉	통과 (0.53ms, 82.6MB)
    테스트 4 〉	통과 (0.11ms, 72.4MB)
    테스트 5 〉	통과 (0.10ms, 77.2MB)
 */

/**
 * BFS 탐색
 * words 인덱스, 변환한 횟수를 queue에 넣기
 * 큐에서 꺼내며 target과 동일한지 비교
 * target과 다르면 words에 있는 문자열과 비교하며 문자 개수가 1개만 차이난다면 해당 word 방문
 */
class Solution {

    int countDiff(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < words.length; ++i) {
            if (countDiff(begin, words[i]) == 1) {
                q.add(new int[] { i, 1 });
                visited[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (target.equals(words[cur[0]])) {
                return cur[1];
            }

            for (int i = 0; i < words.length; ++i) {
                if (visited[i]) continue;
                if (countDiff(words[cur[0]], words[i]) == 1) {
                    q.add(new int[] { i, cur[1] + 1 });
                    visited[i] = true;
                }
            }
        }

        return 0;
    }
}