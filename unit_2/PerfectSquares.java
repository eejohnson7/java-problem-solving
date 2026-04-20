/*
You are given an array of n integers. Your task is to return an array in which the i-th element of the array is the number of divisors of the closest perfect square to the i-th integer in the input array. The "closest" perfect square to a number x is defined as the perfect square that is nearest to x in terms of the smallest absolute distance.

Please note that you are expected to solve this problem within 100 milliseconds. 
*/

package unit_2;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public List<Integer> solution(List<Integer> arr) {            
        List<Integer> result = new ArrayList<>();
        
        for (int x : arr) {      
            result.add(numDivisors(closestSquare(x)));
        }
        
        return result;
    }
    
    private int closestSquare(int x) {
        double root = Math.sqrt(x);            
        int round = (int) Math.round(root);            
        int square = round * round;
        
        return square;
    }
    
    private int numDivisors(int square) {
        int numDivisors = 1;
        int p = 2;
        
        while (p * p <= square) {
            if (square % p == 0) {
                int exponent = 0;
                while (square % p == 0) {
                    square /= p;
                    exponent++;
                }
                numDivisors *= exponent + 1;
            }
            p++;
        }
        
        if (square > 1) {
            numDivisors *= 2;
        }
        
        return numDivisors;
    }
}
