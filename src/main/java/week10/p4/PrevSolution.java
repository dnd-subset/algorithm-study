package week10.p4;

import java.util.HashMap;
import java.util.Map;

public class PrevSolution {
	public String solution(int n, int t, int m, int p) {

		char[] arr = new char[m*t+1]; //1-based
		initArr(arr,n,m,t);

		//순서에 맞는 숫자 구하기
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<t;i++){
			sb.append(arr[p+m*i]);
		}
		return sb.toString();
	}

	// 진수 변환해서 한자리씩 배열에 넣어주기
	private static void initArr(char[] arr, int n, int m, int t){
		arr[1] = '0'; //0부터 시작
		int ind = 2, num = 1;
		boolean flag = false;

		while (true){
			String s = convert(num++,n);
			for (int i=0;i<s.length();i++){
				if (ind>m*t) { //배열 길이만큼 구하기
					flag = true; break;
				}
				arr[ind++] = s.charAt(i);
			}
			if (flag) break;
		}
	}

	//num을 n진수로 변환
	private static String convert(int num, int n){
		StringBuilder sb = new StringBuilder();

		while (num!=0){
			sb.append(getKey(num%n));
			num/=n;
		}
		return sb.reverse().toString();
	}

	// 10진수 넘어가면 알파벳 변환
	private static char getKey(int key){
		Map<Integer, Character> map = new HashMap<>();
		map.put(10,'A'); map.put(11,'B'); map.put(12,'C');
		map.put(13,'D'); map.put(14,'E'); map.put(15,'F');


		return map.getOrDefault(key,(char)(key+'0'));
	}
}
