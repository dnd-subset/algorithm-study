package week10.sunghee.p3;

import java.util.*;

class Solution {

    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for(int t : topping) {
            mapA.put(t , mapA.getOrDefault(t, 0) + 1);
        }

        for(int t : topping) {
            mapB.put(t , mapB.getOrDefault(t, 0) + 1);
            //mapA에서 제거
            int toppingCount = mapA.get(t) - 1;
            if(toppingCount == 0) {
                mapA.remove(t);
            } else {
                mapA.put(t, toppingCount);
            }

            if(mapA.size() == mapB.size()) answer++;
        }


        return answer;
    }

}
