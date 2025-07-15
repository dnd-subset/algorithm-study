package week11.sunghee.p1;


import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //1. 조건에 안맞으면 크기가 0인 값을 넣기
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        int bridgeWeight = 0;
        int truckCont = 0;
        int time = 0;
        int idx = 0;


        while(idx < truck_weights.length) {
            //1. birdge pull
            int outWeight = bridge.poll();
            time++;
            if (outWeight > 0) {
                bridgeWeight -= outWeight;
                truckCont--;
            }

            int curTruckWeight = truck_weights[idx];
            if(truckCont + 1 <= bridge_length && bridgeWeight + curTruckWeight <= weight) {
                //조건 만족하면 트럭 add
                bridge.add(curTruckWeight);
                bridgeWeight += curTruckWeight;
                truckCont++;
                idx++;
            } else {
                //아니면 빈 stack 채우기
                bridge.add(0);
            }
        }

        while(!bridge.isEmpty()) {
            int truck = bridge.poll();
            time++;
        }

        return time;
    }
}
