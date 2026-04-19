/*
You are given two arrays, arrA and arrB, each containing n integers. Your task is to write a function that returns a pair of distinct indices [i, j] such that the sum of the elements at i and j in array arrA equals the sum of the elements at the same indices in array arrB. If there are multiple valid pairs, return the pair in which i is minimal. If there is still ambiguity, choose the one with minimal j among the latter.

Consider arrA = [2, 5, 1, 4] and arrB = [3, 6, 3, 2]. In this case, the output should be [2, 3] because arrA[2] + arrA[3] = arrB[2] + arrB[3], i.e., 1 + 4 = 3 + 2.

Your solution should work within 1 second for each test.

Constraints:

1 ≤ n ≤ 1000000
-1000000 ≤ arrA[i], arrB[i] ≤ 1000000 for all valid i
At least one pair [i, j] exists such that arrA[i] + arrA[j] = arrB[i] + arrB[j]
 */

package unit_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingIndexSum {
        public int[] findIndices(int[] arrA, int[] arrB) {
        // TODO: Implement the solution here
    
        Map<Integer, Integer> diffs = new HashMap<>();
        List<int[]> matches = new ArrayList<>();
            
        for (int i = 0; i < arrA.length; i++) {
            int diff = arrA[i] - arrB[i];
            
            if (diffs.containsKey(-diff)) {
                matches.add(new int[]{diffs.get(-diff), i});
            }
            
            diffs.putIfAbsent(diff, i);
        }
        
        matches.sort((a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if (cmp != 0) return cmp;
            return Integer.compare(a[1], b[1]);
        });
        
        return matches.get(0);
    }
}
