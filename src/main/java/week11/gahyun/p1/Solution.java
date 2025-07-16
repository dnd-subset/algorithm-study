package week11.gahyun.p1;

import java.util.*;

class Solution {
	static char[][] block;
	static boolean[][] marked;
	public int solution(int m, int n, String[] board) {
		int totalRemoveCnt = 0;
		block = new char[m][n];
		marked = new boolean[m][n];

		initBlock(board,m,n); //board-> block

		while (true){
			//1) 2x2 체크
			mark(m,n);

			//2) 체크된 곳 빈칸 처리
			int removeCnt = erase(m,n);
			if (removeCnt==0) break;
			totalRemoveCnt+=removeCnt;

			//3) 지워진 곳 채우기
			fall(m,n);
		}

		return totalRemoveCnt;
	}

	private static void fall(int m, int n) {
		for (int c = 0; c < n; c++) {
			int writeRow = m-1;
			for (int r=m-1;r>=0;r--){
				if (block[r][c]!=' '){
					block[writeRow][c] = block[r][c];
					writeRow--;
				}
			}
			for (int r = writeRow;r>=0;r--){
				block[r][c] = ' ';
			}
		}
	}

	private static int erase(int m, int n){
		int removeCnt =0;
		for (int r=0;r<m;r++){
			for (int c=0;c<n;c++){
				if (marked[r][c]) {
					block[r][c] = ' ';
					removeCnt++;
				}
			}
		}
		return removeCnt;
	}

	private static void mark(int m, int n){ //2x2 체크
		marked = new boolean[m][n];

		for (int r=0;r<m-1;r++){
			for (int c=0;c<n-1;c++){
				char key = block[r][c];
				if (key==' ') continue;
				if (block[r+1][c]!=key||block[r][c+1]!=key||block[r+1][c+1]!=key) continue;
				marked[r][c] = true; marked[r+1][c] = true; marked[r][c+1] = true; marked[r+1][c+1] = true;
			}
		}
	}

	private static void initBlock(String[] board,int m, int n){
		for (int r=0;r<m;r++){
			block[r] = board[r].toCharArray();
		}
	}
}
