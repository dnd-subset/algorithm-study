package week07.sunghee.p2;

import java.io.*;
import java.util.*;

/**
 * 문제 링크 :https://www.acmicpc.net/problem/14719
 * 메모리 : 11644 KB
 * 시간 : 72 ms
 */

/**
 * 왼쪽 기둥과, 오른쪽 기둥의 최대 높이에 따리 빗물이 고임
 * 따라서 왼쪽에서 오늘쪽으로 가면서 기둥의 최대 값을 저장(LM)
 * 오른쪽에서 왼쪽으로 가면서 기둥의  최대 값을 저장(RM)
 * LM과 RM 중 작은 값이 빗물의 높이라고 생각하고
 * 빗물이 고인 량을 구하기 위해 빗물의 높이 - 블로의 크기를 구함
 * 
 * ex)
 * block  : 3 1 2 3 4 1 1 2
 * 
 * LM     : 3 3 3 3 4 4 4 4
 * RM     : 4 4 4 4 4 2 2 2
 * 빗물H  : 3 3 3 3 4 2 2 2
 * 
 * 빗물량 : 0 2 1 0 0 1 1 0
 */

public class Main {
    
    public static void main(String[] args) throws Exception{
        new Main().sol_14719();
    }


    public void sol_14719() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] blocks = new int[W];
        int[] leftToRightMax = new int[W];
        int[] rain = new int[W];

        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            //1. block 값 저장
            int b = Integer.parseInt(st.nextToken());
            blocks[i] = b;

            //2. left -> right로 가면서 가장 큰값 저장
            max = Math.max(max, b);
            leftToRightMax[i] = max;
        }

        max = 0;
        int rianCnt = 0;

        for(int i = W-1; i >= 0; i--) {
            //3. right -> left로 가면서 가장 큰값 저장
            max = Math.max(max, blocks[i]);
            
            // 4. right -> left의 큰값과 left -> right 큰값 중 비교해서 작은 값이 빗물의 높이
            rain[i] = Math.min(max, leftToRightMax[i]);
            //5. 블록 높이 - 빗물 높이가 고이는 빗물의 량
            rianCnt += rain[i] -  blocks[i];
        }

        System.out.println(rianCnt);
    }
}
