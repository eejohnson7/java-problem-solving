/*
You are given a list of operations that need to be performed on a set of numbers. The operations are as follows:

'Add': This operation takes a single integer parameter, x, and adds it to the set.
'Max': This operation does not take any parameters. It returns the largest number currently in the set.
'RemoveMax': This operation also does not take any parameters. It removes the maximum number from the set.
Initially, the set is empty. 'Max' and 'RemoveMax' operations are assured to be called only when the set is not empty.

You need to create a Java function solution() that takes in a list of operations and performs them in sequence. Each operation is represented as an array of strings, where the first element is the string indicating the type of operation, and the second element is the parameter for the 'Add' operation (for 'Max' and 'RemoveMax', the second element is an empty string).

Your function should return a list of outcomes of the 'Max' operations in the sequence they were executed.

Constraints:

The list of operations has a length of n, 1 ≤ n ≤ 100
'Add' operations are assured to be valid
There won't be more than 50 'Add' operations
'Max' and 'RemoveMax' operations are initiated only when the set is not empty
The numbers to be added are integers ranging from -100 to 100, inclusive.
Your solution should execute within a time limit of 1 second for all inputs.
Example:

For operations = {{"Add", "3"}, {"Add", "10"}, {"Max", ""}, {"Add", "5"}, {"Max", ""}, {"RemoveMax", ""}, {"Max", ""}}, the output should be {10, 10, 5}.
*/

package unit_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RemoveMax {
    public List<Integer> solution(List<String[]> operations) throws Exception {
        // operations = {{"Add", "3"}, {"Add", "10"}, {"Max", ""}, {"Add", "5"}, {"Max", ""}, {"RemoveMax", ""}, {"Max", ""}}
        
        // set.add(3) {3}
        // set.add(10) {3, 10}
        // set.last() -> add to result -> 10
        // set.add(5) {3, 5, 10}
        // set.last() -> add to result -> 10
        // set.remove(set.last()) {3, 5}
        // set.last() -> add to result -> 5
        
        PriorityQueue<Integer> set = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> results = new ArrayList<>();
        
        for (String[] operation : operations) {
            String command = operation[0];
            
            if ("Add".equals(command)) {
                set.add(Integer.parseInt(operation[1]));
            } else if ("Max".equals(command)) {
                results.add(set.peek());
            } else if ("RemoveMax".equals(command)) {
                set.poll();
            } else {
                throw new Exception();
            }
        }
        
        return results;
    }
}
