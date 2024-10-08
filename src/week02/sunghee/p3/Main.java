package week02.sunghee.p3;

import java.io.*;
import java.util.*;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/19951
 * 메모리 : 63416KM
 * 시간 : 472ms
 */

/**
 * 조교 지시의 처음과 끝만 저장한 후 누적합 + dp로 풀기
 * 
 * height가 1부터 시작으로 크기를 N+1로 잡음
 * 누적 합 배열(prefixSum)는 N+2 크기로 설정
 * 지시 상항의 시작인덱스(start)인 prefixSum값에 k값을 더하고
 * 끝인덱스(end)인 prefixSum값에 k값을 빼준다.
 * 
 * 이후 prefixSum을 돌면서
 * prefixSum[i] = prefixSum[i-1] + prefixSum[i] (점화식)을 진행하고
 * height의 값과 더해서 연병장 각 칸의 높이을 구한다.
 */

public class Main {

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] height = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[N+2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            prefixSum[start] += k;
            prefixSum[end + 1] -= k;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + prefixSum[i];
            sb.append(height[i]+prefixSum[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
    
