package week10.p1;

import java.util.*;

class Solution {
    int max = -1;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }

    void dfs(int depth, int k, int[][] dungeons) {
        max = Math.max(max, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}
