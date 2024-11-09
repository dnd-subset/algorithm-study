package week05.sunghee.p2;

/**
 * 문제 링크 :https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 테스트 1 〉	통과 (2.92ms, 76MB)
 * 테스트 2 〉	통과 (2.99ms, 73.9MB)
 * 테스트 3 〉	통과 (2.98ms, 81.4MB)
 * 테스트 4 〉	통과 (3.26ms, 75.4MB)
 * 테스트 5 〉	통과 (3.47ms, 74.5MB)
 * 테스트 6 〉	통과 (4.26ms, 74.9MB)
 * 테스트 7 〉	통과 (4.10ms, 80.2MB)
 * 테스트 8 〉	통과 (4.19ms, 75.2MB)
 * 테스트 9 〉	통과 (2.91ms, 76.4MB)
 * 테스트 10 〉	통과 (3.26ms, 74.3MB)
 * 테스트 11 〉	통과 (4.12ms, 67.1MB)
 * 테스트 12 〉	통과 (3.23ms, 75.6MB)
 * 테스트 13 〉	통과 (4.04ms, 73.9MB)
 * 테스트 14 〉	통과 (3.54ms, 73.1MB)
 * 테스트 15 〉	통과 (5.01ms, 82.3MB)
 */

/**
 * 1. 장르별 재생횟수 많은 순으로 정렬
 * 2. 정렬한 장르 순으로 반복
 *    재생 횟수가 많은 기준응로 정렬
 *    제일 많은 곡 2곡(없으면 1곡만) 정답에 추가
 */
import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genresTotalCnt = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> songsPlays = new HashMap<>();

        for (int i =0; i < genres.length; i++) {
            String genre = genres[i];
            int playCnt = plays[i];
            int totalCnt = 0;
            HashMap<Integer, Integer> songsMap = new HashMap<>();

            if (genresTotalCnt.containsKey(genre)) {
                totalCnt = genresTotalCnt.get(genre);
                songsMap = songsPlays.get(genre);
            }

            genresTotalCnt.put(genre, totalCnt + playCnt);
            songsMap.put(i, playCnt);
            songsPlays.put(genre, songsMap);
        }

        List<String> genreSet = new ArrayList<>(genresTotalCnt.keySet());
        genreSet.sort((g1, g2) -> (genresTotalCnt.get(g2) - genresTotalCnt.get(g1)));

        ArrayList<Integer> answer = new ArrayList<>();

        for(String genre : genreSet) {
            HashMap<Integer, Integer> play = songsPlays.get(genre);
            List<Integer> songSet = new ArrayList<>(play.keySet());
            songSet.sort((s1, s2) -> (play.get(s2) - play.get(s1)));

            answer.add(songSet.get(0));
            if(songSet.size() > 1) answer.add(songSet.get(1));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
