package week10.p7;


/**
 * 배운점
 * - 처음: skill.contains(t+"")로 함
 * 		- char가 들어갈 수 없고 String만 들어갈 수 있기 때문에
 * - 개선: indexOf로 포함여부를 판단
 */
class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (String tree : skill_trees){
			if (isValid(tree,skill)) answer++;
		}

		return answer;
	}

	private static boolean isValid(String tree , String skill){
		int pointer = 0;

		for (char t: tree.toCharArray()){
			if (skill.indexOf(t)!=-1){ //선행 스킬 트리에 존재할 경우
				if (t==skill.charAt(pointer)) pointer++; //pointer가 가리키는 스킬이어야함
				else return false;
			}
		}

		return true;
	}
}
