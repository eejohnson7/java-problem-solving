package unit_5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
You are provided with a list of queries. Each query represents an operation in which integers are added to a list. Your task is to 
implement a Java function, solution(), that processes these queries. After each addition operation, the function returns the smallest 
absolute distance between any pair of added numbers. If fewer than two numbers have been added, it should return -1.

The function is defined as public List<Integer> solution(List<Integer> queries), where queries is a list of integers to be added. 
The function should return a list of integers, with each integer representing the smallest absolute distance after each operation.

Constraints:
1≤queries.size()≤100000
−1000000≤queries[i]≤1000000

Example: For List<Integer> queries = Arrays.asList(3, 9, 5, 1, 8), the output should be Arrays.asList(-1, 6, 2, 2, 1).

Explanation:
After adding 3, since the set contains only one number, the smallest distance is -1.
After adding 9, the smallest distance between any pair (3, 9) becomes 6.
After adding 5, the smallest distance between any pair (3, 5) is 2.
After adding 1, the smallest distance remains unchanged, i.e., the distance between the pair (3, 5) remains at 2.
Finally, after adding 8, the smallest distance between any pair (8, 9) becomes 1.
 */

public class SmallestAbsoluteDistance {
    public List<Integer> solution(List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer> sortedStream = new TreeSet<>();
        int minDistance = Integer.MAX_VALUE;
        
        for (Integer query : queries) {          
            if (sortedStream.size() < 1) {
                result.add(-1);
            } else {
                int min = sortedStream.first();
                int max = sortedStream.last();
                
                int distanceToLeft = Integer.MAX_VALUE;
                int distanceToRight = Integer.MAX_VALUE;
                
                if (query <= min) {
                    distanceToRight = min - query;
                } else if (query >= max) {
                    distanceToLeft = query - max;
                } else {
                    distanceToLeft = query - sortedStream.lower(query);
                    distanceToRight = sortedStream.ceiling(query) - query;
                }
                
                if (distanceToLeft < minDistance) {
                    minDistance = distanceToLeft;
                } 
                
                if (distanceToRight < minDistance) {
                    minDistance = distanceToRight;
                }
                
                result.add(minDistance);
            }
            
            sortedStream.add(query);
        }
        
        return result;
    }
}
