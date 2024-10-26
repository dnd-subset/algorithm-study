package week04.sunghee.p2;


/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * 테스트 1 〉	통과 (0.42ms, 75.5MB)
 */

/**
 * bfs로 풀이
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static class State {
        public final String word;
        public final int step;

        private State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    private static boolean isConvertable(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) diffCnt++;
        }

        return diffCnt == 1;
    }


    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));

        //5. 탐색 진행
        while (!queue.isEmpty()) {
            State state = queue.poll();

            //6. 현재 상태 처리
            if (state.word.equals(target)) {
                return state.step;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];
                if (!isConvertable(state.word, next) || isVisited[i]) continue;

                //9. 방문 처리 && 상태 정의
                isVisited[i] = true;    //검사 통과한 상태는 전이될 수 있는 상태로 방문 처리
                queue.add(new State(next, state.step + 1));     //탐색 공간에 추가
            }

        }

        //모든 공간을 탐색 했는데 정답 상태를 방문하지 못하면 0를 반환
        return 0;

    }




    public static void main(String[] args) {
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
