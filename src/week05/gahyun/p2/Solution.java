package week05.gahyun.p2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579#
 * 테스트 1 〉	통과 (2.95ms, 76.2MB)
 * 테스트 2 〉	통과 (3.02ms, 75.2MB)
 * 테스트 3 〉	통과 (2.54ms, 69.5MB)
 * 테스트 4 〉	통과 (3.65ms, 78MB)
 * 테스트 5 〉	통과 (4.50ms, 77.5MB)
 */

/**
 * 장르별 플레이수 treeMap으로 저장해 내림차순 정렬
 * Music 객체 리스트에 인덱스, 장르수, 플레이수 저장
 * 해당 리스트에서 map 장르순, 재생횟수 내림 차순 정렬
 * 정렬된 리스트 순회하며 인덱스를 장르별 최대 2개씩 담기
 */
class Solution {
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> genreMap = new TreeMap<>(Collections.reverseOrder()); //장르별 플레이수 내림차순 정렬
		List<Music> musicList = new ArrayList<>(); // 노래 정보 저장

		for (int i=0;i<genres.length;i++){
			genreMap.put(genres[i],genreMap.getOrDefault(genres[i],0)+plays[i]); // 장르별 플레이수 구하기
			musicList.add(new Music(i,genres[i],plays[i])); // 인덱스, 장르, 플레이 수
		}

		musicList.sort((m1, m2) -> {
			// 장르별
			int c = Integer.compare(genreMap.get(m2.genre), genreMap.get(m1.genre)); //인덱스 비교 map에서 m1이 더 앞에 있어야 함
			if (c != 0)
				return c;

			// 재생횟수 내림차순
			c = Integer.compare(m2.cnt, m1.cnt);
			return c;
		});

		String preGenre=""; // 이전 장르
		int genreCnt = 0; // 연속된 장르 등장수

		for (Music music : musicList) {
			if (music.genre.equals(preGenre)) {
				genreCnt++;
				if (genreCnt >= 3)
					continue; // 최대 2곡
			} else { // 장르 갱신
				genreCnt = 1;
				preGenre = music.genre;
			}
			answer.add(music.ind); // 정답 배열에 인덱스 삽입
		}

		// list -> int[]
		return answer.stream()
			.mapToInt(i -> i)
			.toArray();
	}

}

class Main {
	public static void main(String[] args) {
		int[] answer = new Solution().solution(new String[] {"classic", "classic", "classic", "classic", "pop"},
			new int[] {50, 60, 100, 30, 8000});
		System.out.println(Arrays.toString(answer));
	}
}

class Music{
	int ind;
	String genre;
	int cnt;

	public Music(int ind, String genre, int cnt){
		this.ind = ind;
		this.genre = genre;
		this.cnt = cnt;
	}
	//디버깅
	@Override
	public String toString() {
		return String.format("Music{ind=%d, genre='%s', cnt=%d}", ind, genre, cnt);
	}
}