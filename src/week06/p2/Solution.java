package week06.p2;

import java.util.*;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 테스트 1  〉	통과 (1.98ms, 77.9MB)
 * 테스트 2  〉	통과 (2.37ms, 76.6MB)
 * 테스트 3  〉	통과 (1.98ms, 74.5MB)
 * 테스트 4  〉	통과 (2.46ms, 72.5MB)
 * 테스트 5  〉	통과 (3.34ms, 76.3MB)
 * 테스트 6  〉	통과 (1.91ms, 81.6MB)
 * 테스트 7  〉	통과 (1.96ms, 73.7MB)
 * 테스트 8  〉	통과 (4.45ms, 75.7MB)
 * 테스트 9  〉	통과 (2.70ms, 80.7MB)
 * 테스트 10 〉	통과 (3.16ms, 71.2MB)
 * 테스트 11 〉	통과 (2.17ms, 73.4MB)
 * 테스트 12 〉	통과 (2.36ms, 78.9MB)
 */

/**
 * 풀이(dfs)
 * 1. num의 값이 소수 값이면 primes Set에 추가
 * 2. for문으로 숫자 조합 시작
 * 3. 사용된 숫자면 continue, 아니면 nextNum = num * 10 + arr[i]로 다움 숫자 구하고
 * 4. isUsed[i]를 ture로 바꾼다음 dfs(nextNum)으로 재귀 호출
 * 5. 다음 조합을 위해 재귀를 완료하면 isUsed[i]를 false로 변경
 */


class Solution {
    
    boolean[] isUsed;
    int[] arr;
    Set<Integer> primes = new HashSet<>();
    
    boolean isPrime(int n){
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    void dfs(int num) {
        if(isPrime(num)) primes.add(num);
        for(int i =0; i < arr.length; i++) {
            if(isUsed[i]) continue;
            int next = num * 10 + arr[i];
            isUsed[i] = true;
            dfs(next);
            isUsed[i] = false;
        }
    }
    
    public int solution(String numbers) {
        arr = numbers.chars().map(c -> c - '0').toArray();
        isUsed = new boolean[arr.length];
        dfs(0);
        return primes.size();
    }
}
