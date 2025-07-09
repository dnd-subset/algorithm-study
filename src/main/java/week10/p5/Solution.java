package week10.p5;

import java.util.*;

/**
 * 접근 방식
 * - map으로 닉네임 계속 최신화
 * - 채팅방 출입 기록은 리스트에 저장
 * - 최신화 후 해상 아이디로 닉네임 찾아서 기록 출력
 */
class Solution{
	public String[] solution(String[] record) {
		Map<String, String> map = new HashMap<>();
		List<Event> history = new ArrayList<>();

		for (int i=0;i<record.length;i++){
			String[] arr = record[i].split(" ");
			String cmd = arr[0];
			String id = arr[1];

			if (cmd.equals("Enter")) {
				String name = arr[2];
				map.put(id,name);
				history.add(new Event(id, "님이 들어왔습니다."));
			}
			else if (cmd.equals("Leave")) {
				history.add(new Event(id, "님이 나갔습니다."));
			}
			else {
				String name = arr[2];
				map.put(id,name);
			}
		}

		String[] result = new String[history.size()];
		for (int i=0;i<result.length;i++){
			Event event = history.get(i);
			result[i] = map.get(event.id)+event.msg;
		}
		return result;
	}
}

class Event{
	String id;
	String msg;
	public Event(String id, String msg){
		this.id = id;
		this.msg = msg;
	}
}
