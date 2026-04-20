/*
You are given an array of n integers and several queries. Each query is a pair (l, r), where l and r represent inclusive indices within the array. Your task is to define a function named solution that returns an array reflecting the maximum cumulative sum of integers between the indices l and r. More formally, for each (l, r), you should find the maximum sum of elements in the array with indices in the interval from l to m inclusive, where m in its turn is a number from l to r inclusive.

The array's element count, n, ranges from 1 to 1000, inclusive, with each element being an integer from -1000 to 1000, inclusive. The length of the list queries is at most 1000000. The index l is a non-negative number and is less than or equal to r, while r is non-negative and less than the total number of elements in the array.

Example:

For arr = [3, 1, -4, 2, -5, 1, 3, 6] and queries = [(0, 4), (2, 6), (2, 7)] the output should be [4, -2, 3].
*/

package unit_2;

import java.util.ArrayList;
import java.util.List;

public class MaxCumulativeSum {
    public List<Integer> solution(int[] arr, List<int[]> queries) {
        int n = arr.length;
        int[][] precalcMaxSums = new int[n][n];
        
        for (int i = 0; i < n; i++) {            
            int maxSum = -1001;
            int sum = 0;
            
            for (int j = i; j < n; j++) {
                sum = sum + arr[j]; 
                
                if (sum > maxSum) { 
                    maxSum = sum; 
                }
                
                precalcMaxSums[i][j] = maxSum;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int[] query: queries) {
            result.add(precalcMaxSums[query[0]][query[1]]);
        }
                
        return result;
    }
}