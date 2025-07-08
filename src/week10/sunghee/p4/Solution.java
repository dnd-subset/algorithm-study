package week10.sunghee.p4;

import java.util.*;

class Solution {

    public String solution(int n, int t, int m, int p) {


        StringBuilder nNumbers = new StringBuilder();
        int num = 0;

        while (nNumbers.length() < m * t) {
            nNumbers.append(Integer.toString(num++, n));
        }

        StringBuilder results = new StringBuilder();

        for(int i = 0; i < t; i++) {
            results.append(nNumbers.charAt((m * i) + p - 1));
        }
        return results.toString().toUpperCase();
    }

}
