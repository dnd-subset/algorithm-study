package week10.sunghee.p5;

import java.util.*;

class Solution {

    class Room {
        String uuid;
        boolean state;  //true Enter, false Levae

        public Room(String uuid, boolean state) {
            this.uuid = uuid;
            this.state = state;
        }
    }

    public String[] solution(String[] record) {

        Map<String, String> member = new HashMap<>();
        Queue<Room> queue = new LinkedList<>();

        for(String r : record) {
            String[] records = r.split(" ");
            switch(records[0]) {
                case "Enter":
                    member.put(records[1], records[2]);
                    queue.add(new Room(records[1], true));
                    break;
                case "Leave":
                    queue.add(new Room(records[1], false));
                    break;
                default:
                    member.put(records[1], records[2]);
            }
        }
        int queueSize = queue.size();
        String[] answer = new String[queueSize];
        for(int i = 0; i < queueSize; i++) {
            Room r = queue.poll();
            answer[i] = member.get(r.uuid) + "님이 " + (r.state ? "들어왔습니다." : "나갔습니다.");
        }

        return answer;
    }
}
