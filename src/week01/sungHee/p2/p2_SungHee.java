package week01.sungHee.p2;

import java.io.*;
import java.util.*;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/1303
 * 메모리 : 11852 KM
 * 시간 : 72 ms
 *
 * 풀이
 * DFS(같은 부류를 찾는 문제) 사용
 * 가로가 N, 세로가 M 확인!!
 * 
 * 방문 여부는 배열의 문자로 구분(방문했으면 'V'로 변환)
 * 0,0 부터 배열 방문
 * W, M 기준을 dfs 호출
 * dfs 호출 시 어떤 팀을 나타내는지 팀 문자를 인자로 같이 넘김
 * 하나의 dfs가 끝나면 cnt(뭉쳐있는 인원수) 제곱 후 각 팀의 병사의 위력에 더함
 */

public class p2_SungHee {

    static int[] dx = { 1, 0, -1, 0 }; // x방향배열
    static int[] dy = { 0, -1, 0, 1 }; // y방향배열

    static char map[][];

    static int N, M;
    static int w, b; // 병사 위력의 합

    static int cnt;

    private static void dfs(int y, int x, char team) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[ny][nx] != team) continue;

            map[ny][nx] = 'V'; // 방문 표기
            cnt++;
            dfs(ny, nx, team);
        }

    }

    public static void main(String[] args) throws IOException {
        // setting
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // dfs
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 1; // cnt 초기화

                if (map[i][j] == 'W') {
                    // visited
                    map[i][j] = 'V';
                    dfs(i, j, 'W');
                    w += (cnt * cnt);
                }
                if (map[i][j] == 'B') {
                    map[i][j] = 'V';
                    dfs(i, j, 'B');
                    b += (cnt * cnt);
                }
            }
        }

        System.out.println(w + " " + b);
    }
}
