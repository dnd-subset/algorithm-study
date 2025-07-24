package week11.gahyun.p7;

import java.util.*;

/**
 * 접근 방법: 각 분을 인덱스화하여 카운트
 */
class Solution {
	static int maxCnt = 0;
	public int solution(String[][] book_time) {
		int limit = 23*60+59;
		int[] cnt = new int[limit+1]; //00:00~23:59 점유 객실 수

		for (int i=0;i<book_time.length;i++){
			String startTime = book_time[i][0];
			String endTime = book_time[i][1];

			int startH = Integer.valueOf(startTime.split(":")[0]);
			int startM = Integer.valueOf(startTime.split(":")[1]);
			int endH = Integer.valueOf(endTime.split(":")[0]);
			int endM = Integer.valueOf(endTime.split(":")[1]);

			int startIdx = startH*60+startM;
			int endIdx = endH*60+endM+9;
			if (endIdx>limit) endIdx = limit;
			occupy(startIdx, endIdx,cnt);
		}

		return maxCnt;
	}

	private static void occupy(int startIdx, int endIdx, int[] cnt){
		for (int i=startIdx;i<=endIdx;i++){
			cnt[i]++;
			maxCnt = Math.max(cnt[i],maxCnt);
		}
	}
}
