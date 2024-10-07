package week02.gahyun.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 문제 링크 : https://www.acmicpc.net/problem/1138
 * 메모리 : 	14228 KM
 * 시간 : 100 ms
 */
/*
 배열 요소 역순으로 리스트에 삽입
 arr[i] = 인덱스
 i = 키
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> answer = new ArrayList<>();
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 입력 받기
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		answer.add(N); // 최초 삽입
		for (int i = N - 1; i > 0; i--) {
			answer.add(arr[i], i);
		}

		// 출력
		for (Integer x : answer) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
	}
}
