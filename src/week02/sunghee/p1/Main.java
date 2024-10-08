package week02.sunghee.p1;

import java.io.*;
import java.util.*;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/1138
 * 메모리 : 11596 KM
 * 시간 : 68 ms
 */

/**
 * arr에 값 받기
 * 키가 가장 큰 순부터 for문 돌기
 *     ArrayList에 왼쪽에 키가 큰 사람 수를 index로 하여 추가
 */

public class Main {
    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> resultList = new ArrayList<>();
        for(int i = N; i > 0 ; i--) {
            resultList.add(arr[i-1], i);
        }

        StringBuilder sb = new StringBuilder();
        for(Integer p : resultList) {
            sb.append(p +  " ");
        }

        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}