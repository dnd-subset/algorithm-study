package week05.gahyun.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1202
 * 메모리: 127064KB
 * 시간: 1512ms
 */

/**
 * 보석 무게, 가격 담은 클래스 생성
 * 보석 객체 리스트 -> 무게 오름차순, 가격 내림차순 정렬
 * 가방 무게 리스트 -> 오름차순 정렬
 * 가방 리스트에 대해 반복
 * - 보석 객체 리스트 순회하며 가방 무게 초과하지 않는지 확인
 * - 초과하지 않으면 우선순위 큐에 저장( 가격 내림차순 정렬)
 * - 첫번째 요소 빼서 무게 더해줌
 * - 다음 반복부터는 기존에 봤던 인덱스 다음부터 보면됨
 */

public class Main {
	public static void main(String[] args) throws IOException {
		long answer = 0; // int 아님
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] bags = new int[K];
		List<Jewel> jewels = new ArrayList<>();

		// 보석 무게, 가격 입력 받아 객체 리스트 생성하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels.add(new Jewel(M, V));
		}

		// 무게 오름차순, 가격 내림차순 정렬
		jewels.sort((j1, j2) -> {
			int c = Integer.compare(j1.weight, j2.weight);
			if (c != 0)
				return c;
			c = Integer.compare(j2.price, j1.price);
			return c;
		});

		// 가방 초기화
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags); // 오름차순 정렬
		// System.out.println(jewels);


		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 가격 내림차순 정렬
		for (int i = 0, j = 0; i < K; i++) {// i-> 가방 인덱스, j -> 보석 객체 인덱스
			while (j < N && bags[i] >= jewels.get(j).weight) { // 가방이 용량 초과하지 않을 때까지 더하기
				pq.add(jewels.get(j).price);
				j++; // 가방 무게 무거워지므로 이전 보석들은 다 들어감 -> 다음 보석부터 검사하면 됨
			}
			// 제일 높은 가격 더하기
			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}

		System.out.println(answer);
	}
}

class Jewel {
	int weight;
	int price;

	public Jewel(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("{weight = %d, price = %d} ", weight, price);
	}
}