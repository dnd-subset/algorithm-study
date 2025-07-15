package week11.sunghee.p1;

import java.util.*;

/**
 * 0 패딩 -> exitTime으로 변경
 */
public class RefactorSolution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>(); // [트럭무게, 다리에서 내려야하는 시간]
        int time = 0;
        int idx = 0;
        int totalWeight = 0;

        while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++;
            //
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                totalWeight -= bridge.poll()[0];
            }

            // 2) 다음 트럭 진입 가능 여부 체크
            if (idx < truck_weights.length) {
                int nextTruck = truck_weights[idx];
                if (totalWeight + nextTruck <= weight && bridge.size() < bridge_length) {
                    bridge.add(new int[]{nextTruck, time + bridge_length});
                    totalWeight += nextTruck;
                    idx++;
                }
            }
        }

        return time;
    }
}
