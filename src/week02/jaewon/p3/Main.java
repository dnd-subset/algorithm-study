import java.io.*;
import java.util.*;

/*
	* 문제 링크 : https://www.acmicpc.net/problem/19951
	* 메모리 : 67192 kb
	* 시간 : 656 ms
*/
/*
 	누적합, start부터 변화된 값을 따라서 누적된 값을 사용
    end + 1부터는 누적값을 0으로 초기화 (end + 1 부터는 변화 X)
 */

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N, K;
    int[] arr, deltas;

    private void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        N = Integer.parseInt(tokens[0]);
        K = Integer.parseInt(tokens[1]);
        arr = new int[N + 1];

        tokens = br.readLine().split(" ");
        for (int i = 1; i <= N; ++i) {
            arr[i] = Integer.parseInt(tokens[i - 1]);
        }

        deltas = new int[N + 1];
        for (int i = 0; i < K; ++i) {
            tokens = br.readLine().split(" ");
            int s = Integer.parseInt(tokens[0]);
            int e = Integer.parseInt(tokens[1]);
            int k = Integer.parseInt(tokens[2]);
            alterDirt(s, e, k);
        }

        for (int i = 1; i <= N; ++i) {
            deltas[i] = deltas[i - 1] + deltas[i];
            arr[i] += deltas[i];
            bw.append(arr[i] + " ");
        }
    }

    // end 포함 O
    void alterDirt(int start, int end, int delta) {
        deltas[start] += delta;
        if (end != N)
            deltas[end + 1] -= delta;
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
