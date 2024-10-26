package week05.sunghee.p1;


/**
 * 문제 링크 :https://www.acmicpc.net/problem/1202
 * 메모리 : 125456 KB
 * 시간 : 1616ms
 */

/**
 * 다른 사람 풀이 보고 품
 * 보석은 무게(오름차순), 가격(내림차순) 으로 정렬
 * 가방은 무게(오름차순) 정렬
 * 가방 기준으로 for문
 *  현재 가방의 무게보다 무게가 작거나 같은 보석을 우선순위큐(가격기준)에 추가
 *  큐.poll() 해서 정답에 더해줌
 *
 * 3퍼 에러  -> 최대 리턴 값 1,000,000 * 300,000 = 300,000,000,000 -> int 범위 벗어남
 */


import java.util.*;
import java.io.*;

class Main {

    static class Jewelry implements Comparable<Jewelry> {
        int mass, value;

        public Jewelry(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }

        // 오름차순으로 정렬 
        // 1(크다), (0) 같다, -1 작다
        @Override
        public int compareTo(Jewelry o) {
            if(this.mass == o.mass) {
                //무게가 같을경우 가격을 내림차순으로 정렬.
                // this 작은거, o가 큰거
                // 큰 - 작은  -> 큰순으로
                return o.value - this.value;
            }
            //작은거 - 큰거 -> 음수 -> 작은 순으로
            return this.mass - o.mass;
        }
        
    }

    static int N, K;
    static int[] bags;
    static Jewelry[] jewelries;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[N];
        bags = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(m, v);
        }

        for(int i = 0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        //오름차순 정렬(가방)
        Arrays.sort(bags);
        Arrays.sort(jewelries);

        //가방 기준으로
        // 큰값이 먼저 나오게(value)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;

        for(int i = 0, j = 0; i < K; i++) {
            //현재 가방의 무게보다 작거나, 같은 보석을 모두 큐에
            while (j < N && jewelries[j].mass <= bags[i]) {
                pq.offer(jewelries[j++].value);
            }

            if(!pq.isEmpty()) {
                //value가 가장 큰 값으로
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}
