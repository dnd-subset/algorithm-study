package week10.p8;

import java.util.*;

class Solution {
	int solution(int[][] land) {
		int[][] d = new int[land.length][4]; //d[i][j]: i열 j행까지의 최대점수
		// 초기항
		for (int c=0;c<4;c++){
			d[0][c] = land[0][c];
		}

		for (int r=1;r<land.length;r++){ //행
			for (int c=0;c<4;c++){ //열

				int prevMax = Integer.MIN_VALUE;
				for (int i=0;i<4;i++){ //이전행에서 최대값 구하기
					if (i==c) continue; //같은 열 밟을 수 없음
					prevMax = Math.max(d[r-1][i],prevMax);
				}
				d[r][c] = prevMax + land[r][c]; //이전 점수 최대값+ 현재 점수
			}
		}

		int answer = 0;
		for (int c=0;c<4;c++){
			answer = Math.max(d[land.length-1][c],answer);
		}

		return answer;
	}
}
