package week11.gahyun.p5;

import java.util.*;

/**
 * 차 객체 생성해서 시간 관리
 * map : 차번호-차 객체
 * 차번호로 정렬 -> TreeMap
 */
class Solution {
	public int[] solution(int[] fees, String[] records) {

		Map<String, Car> map = new TreeMap<>(); //차번호, 차
		for (String record: records){
			String[] data = record.split(" ");

			String[] time = data[0].split(":");
			int hour = Integer.valueOf(time[0]);
			int min = Integer.valueOf(time[1]);

			String carNum = data[1];
			String cmd = data[2];
			if (!map.containsKey(carNum)){
				map.put(carNum,new Car());
			}

			Car car = map.get(carNum);
			if (cmd.equals("IN")){
				car.entry(hour,min);
			}
			else {
				car.out(hour,min);
			}

		}

		int[] answer = new int[map.size()];
		int idx = 0;
		for (Car car:map.values()){
			answer[idx++] = calculateFee(fees, car);
		}

		return answer;
	}

	private int calculateFee(int[] fees, Car car){
		int defaultMin = fees[0];
		int defaultFee = fees[1];
		int overMin = fees[2];
		int overFee = fees[3];

		int totalTime = car.getTotalTime();

		if (totalTime<=defaultMin) return defaultFee;
		else
			return defaultFee+(int)Math.ceil((totalTime-defaultMin)*1.0/overMin)*overFee;
	}
}

class Car {
	boolean isEntry; //입차 여부
	int entryHour; //입차 시간
	int entryMin; //입차 분
	int totalTime = 0;

	public void entry(int entryHour, int entryMin){//입차
		this.entryHour = entryHour;
		this.entryMin = entryMin;
		isEntry = true;
	}

	public void out(int outHour, int outMin){ //출차
		totalTime+= (outHour-entryHour)*60+(outMin-entryMin); //주차 시간 누적
		isEntry = false;
	}

	public int getTotalTime(){ //누적시간 반환
		if (isEntry){//아직 출차 안함
			totalTime+= (23-entryHour)*60+(59-entryMin);
		}
		return totalTime;
	}
}
