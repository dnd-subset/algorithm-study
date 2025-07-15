package week11.sunghee.p2;

import java.util.*;


public class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] table = new char[m][n];
        for(int i=0; i<m; i++){
            table[i] = board[m-i-1].toCharArray();
        }

        while (true) {
            boolean noRemove = true;
            boolean[][] isFourBlock = new boolean[m][n];
            //1. 블록 찾기
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(table[i][j] == 'X') continue;

                    char c = table[i][j];
                    if (table[i][j + 1] == c && table[i + 1][j] == c && table[i + 1][j + 1] == c) {
                        //4*4인 블록
                        isFourBlock[i][j] = true;
                        isFourBlock[i+1][j] = true;
                        isFourBlock[i][j+1] = true;
                        isFourBlock[i+1][j+1] = true;
                        noRemove = false;
                    }
                }
            }

            //
            if(noRemove) break;

            //블록 삭제
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isFourBlock[i][j]) {
                        table[i][j] = 'X';
                        answer++;
                    }
                }
            }

            //블록 내리기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][j] == 'X') {
                        for (int k = i; k < m; k++) {
                            if (table[k][j] == 'X') continue;

                            table[i][j] = table[k][j];
                            table[k][j] = 'X';
                            break;
                        }
                    }
                }
            }

        }

        return answer;
    }
}
