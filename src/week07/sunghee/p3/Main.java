package week07.sunghee.p3;

import java.io.*;
import java.util.*;

 /**
 * 문제 링크 :https://www.acmicpc.net/problem/21939
 * 메모리 : 57196 KB
 * 시간 : 556 ms
 */

/**
 * problems : TreeSet으로 문제를 난이도 순, 문제 번호 순으로 정렬 함
 * map : HashMap으로 문제 번호와 난이도를 관리
 * 
 * problems의 문제를 지울 때, map에서 난이도를 값을 찾아서 이용
 */

public class Main {
    
    public static void main(String[] args) throws Exception{
        new Main().sol_21939();
    }

    class Problem{
        int p, l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }

    public void sol_21939() throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Problem> problems = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) { // 문제 난이도가 같다면
				return o1.p - o2.p; // 문제 번호가 작은 것 순서대로
			}
			return o1.l - o2.l;
        });


        // 문제 번호와 난이도를 관리하기 위한 map
        Map<Integer, Integer> map = new HashMap<>();


        for(int i =0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            problems.add(new Problem(P, L));
            map.put(P, L);
        }


        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    Problem problem = (x == 1 ? problems.last() : problems.first());
                    sb.append(problem.p).append("\n");
                    break;
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    problems.add(new Problem(p, l));
                    map.put(p, l);
                    break;
                default:
                    //solve
                    int s = Integer.parseInt(st.nextToken());
                    //treeset은 모든 객체 비교를 comparTo()로 비교하기 때문에 equals를 오버라이딩 안해도 동일한 객체로 간주
                    problems.remove(new Problem(s, map.get(s)));
                    break;
            }
        }
        System.out.println(sb);
    }
}
