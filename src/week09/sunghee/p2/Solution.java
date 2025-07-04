package week09.sunghee.p2;


import java.util.*;

public class Solution {
    private static final int num = 65536;

    public int solution(String str1, String str2) {

        //1. A, B 생성 (대문자로 변경, 영문자만 가능)
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<Integer> A = toMultiSet(str1);
        List<Integer> B = toMultiSet(str2);

        if(A.isEmpty() && B.isEmpty()) return (num);


        int intersectCount = 0;

        for(Integer aValue : A) {
            boolean hasValue = B.remove(aValue);
            if (!hasValue) continue;
            intersectCount++;
        }

        int unionCount = A.size() + B.size();
        double result = ((double) intersectCount / unionCount) * num;


        return (int) result;
    }

    private List<Integer> toMultiSet(String str) {
        List<Integer> multiset = new ArrayList<>();
        for (int i = 0; i < str.length() -1; i++) {
            int cur = str.charAt(i);
            int next = str.charAt(i+1);
            if (isNotAlphabet(cur) || isNotAlphabet(next)) continue;
            multiset.add(cur * 100 + next);
        }
        return multiset;
    }

    private boolean isNotAlphabet(int char1) {
        return char1 < 65 || char1 > 90;
    }
}
