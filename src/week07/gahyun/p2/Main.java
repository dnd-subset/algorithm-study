package week07.gahyun.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14719
 * 메모리: 14316KB
 * 시간: 108ms
 */

/**
 * 왼쪽에서 오른쪽으로 순회 -> 최대 블록 높이 maxL 저장
 * 오른쪽에서 왼쪽으로 순회 -> 최대 블록 높이 maxR 저장
 * maxL, maxR 최소값에서 각 블록 높이 빼기 => 총합 계산
 */

public class Main {
	public static void main(String[] args) throws IOException {
		int total = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[W];
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] maxL = new int[W];
		int[] maxR = new int[W];

		// 순행하며 최대 높이 배열에 저장
		maxL[0] = arr[0];
		for (int i = 1; i < W; i++) {
			maxL[i] = Math.max(maxL[i - 1], arr[i]);
		}

		// 역행하며 최대 높이 배열에 저장
		maxR[W - 1] = arr[W - 1];
		for (int i = W - 2; i >= 0; i--) {
			maxR[i] = Math.max(maxR[i + 1], arr[i]);
		}

		// arr 순회하며 빗물 더하기
		for (int i = 0; i < W; i++) {
			total += Math.min(maxL[i], maxR[i]) - arr[i];
		}

		System.out.println(total);
	}
}
