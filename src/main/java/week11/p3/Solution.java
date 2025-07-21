package week11.p3;

import java.util.*;

/**
 * 접근 방식
 * - 처음에는 Queue로 풀었는데 split하는게 더 효율적
 * - 0+는 0이 한개 이상인 것
 * - n을 k진수로 변환: Intereger.toString(n,k)
 */
class Solution {
	public int solution(int n, int k) {
		int cnt = 0;

		String numK = Integer.toString(n,k);
		String[] subset = numK.split("0+");
		for (String num : subset){
			if (num.equals("")) continue;
			if (isPrime(Long.parseLong(num))) cnt++;
		}

		return cnt;
	}

	private static boolean isPrime(long num){ //소수여부 판별
		if (num<2) return false;
		for (long i=2;i*i<=num;i++){
			if (num%i==0) return false;
		}
		return true;
	}
}
