package week09.gahyun.p2;

import java.util.HashMap;
import java.util.Map;
/*
헷갈렸던 점
- 1차시도: 다중집합되는줄 모르게 set으로 품
- 2차시도: 리스트로 품 -> 다중집합 교집합 구할 때 contains로 구해서 정확하지 않음
- 3차 시도: map

1. map 초기화
- 소문자화
- 두 자리 씩 -> 각 자리 추출하여 둘다 문자일 경우 map에 저장

2. 공집합 검증
3. n(A,B 교집합) 구하기
- A에 key에 대하여 반복
  - min(A key value, B key value)
  - B에 key 없으면 0 반환
4. n(A,B 합집합) 구하기
 n(A)+n(B)-n(A,B 교집합)
 */
class Solution {
	public int solution(String str1, String str2) {
		Map<String, Integer> mapA = new HashMap<>();
		Map<String, Integer> mapB = new HashMap<>();

		initMap(mapA, str1.toLowerCase());
		initMap(mapB, str2.toLowerCase());
		if (mapA.isEmpty()&&mapB.isEmpty()) return 65536;

		int multi = getMulti(mapA,mapB);
		int union = getCnt(mapA)+getCnt(mapB)-multi;
		return (int)((double)multi/union*65536);
	}

	private static void initMap(Map<String, Integer> map, String str){
		for (int i=0;i<str.length()-1;i++){
			char ch1 = str.charAt(i);
			char ch2 = str.charAt(i+1);
			if (ch1<'a'||ch1>'z'||ch2<'a'||ch2>'z') continue;
			String key = ""+ch1+ch2;
			map.put(key,map.getOrDefault(key,0)+1);
		}
	}

	private static int getMulti(Map<String, Integer> mapA, Map<String, Integer> mapB){
		int multi = 0;
		for (String k : mapA.keySet()){
			multi+=Math.min(mapA.get(k),mapB.getOrDefault(k,0));
		}
		return multi;
	}

	private static int getCnt(Map<String, Integer> map){
		int cnt = 0;
		for (String k : map.keySet()){
			cnt+=map.get(k);
		}
		return cnt;
	}
}
