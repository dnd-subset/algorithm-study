package week02.gahyun.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 링크 : https://www.acmicpc.net/problem/19951
 * 메모리 : 	62536 KM
 * 시간 : 576 ms
 */

/*
누적합
1 2 3 4 5 주어진 배열
1 4 2

2 0 0 0 -2 0
2 2 2 2 0 0 누적합
3 4 5 6 4 5 결과
a에 k, b+1에 -k 저장하고 1부터 누적합 구하기
마지막에 누적합 기존 배열에 더하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1]; // 1부터
		int[] order = new int[N + 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			order[a] += k;
			order[b + 1] -= k;
		}

		for (int i = 1; i <= N; i++) {
			order[i] += order[i - 1];
			sb.append(arr[i] + order[i]).append(" ");
		}
		System.out.println(sb);
	}
}