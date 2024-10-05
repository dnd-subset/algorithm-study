import java.io.*;
import java.util.*;

/*
	* 문제 링크 : https://www.acmicpc.net/problem/1138
	* 메모리 : 15860 kb
	* 시간 : 144 ms
	*/
/*
	주어진 배열의 값이 큰 사람이 왼쪽에 몇 명인지 의미
	빈 자리 띄우고 왼쪽부터 오른쪽으로 채우기
*/

public class Main {
    private void sol() throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] tokens = br.readLine().split("	");
        int[] res = new int[N];
        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(tokens[i]);
            for (int k = 0; k < N; ++k) {
                if (num == 0 && res[k] == 0) {
                    res[k] = i + 1;
                    break;
                } else if (res[k] == 0)
                    num--;
            }
        }
        for (int i = 0; i < N; ++i) {
            System.out.print(res[i] + "	");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
