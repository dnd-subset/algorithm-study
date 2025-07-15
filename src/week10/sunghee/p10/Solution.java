package week10.sunghee.p10;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int[] edge : edges) {
            int[] out = map.getOrDefault(edge[0], new int[]{0, 0});
            out[0] = out[0] + 1;
            map.put(edge[0], out);

            int[] in = map.getOrDefault(edge[1], new int[]{0, 0});
            in[1] = in[1] + 1;
            map.put(edge[1], in);
        }

        int[] answer = new int[4];
        for(int node : map.keySet()) {
            //1. 정점 찾기 (out : 2이상, in : 0)
            int[] outIn = map.get(node);
            if(outIn[1] == 0 && outIn[0] >= 2) {
                answer[0] = node;
                continue;
            }

            //2. 직선 (out : 0, in 1이상)
            if(outIn[0] == 0 && outIn[1] >= 1) {
                answer[2] += 1;
                continue;
            }
            //4. 8자 (순환 된는 애 찾기, out 2, in 2 이상)
            if (outIn[0] == 2 && outIn[1] >= 2) {
                answer[3] += 1;
            }
        }

        //정점의 out수가 전체 그래프 수 : 전체 그레프 수 - 직선 - 8자 = 도넛
        int graphCnt = map.get(answer[0])[0];
        answer[1] = graphCnt - answer[2] - answer[3];
        return answer;
    }
}
