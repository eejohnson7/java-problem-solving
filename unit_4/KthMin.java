/*
You are given a list of integers and a series of queries. There are two types of queries:

Delete the k-th minimum element (k <= 5) from the list.
Find the 3rd minimum of the list after performing all deletion operations.
You are tasked with creating a Java function List<Integer> solution(List<Integer> data, List<Map.Entry<String, Integer>> queries) that accepts a list of integers and a list of queries as arguments. Each query is either in the form of Map.entry("delete", k) or Map.entry("find", 0). For each 'find' query, your function should return the current 3rd minimum in the list, if it exists. If the list does not contain a 3rd minimum, return -1.

Constraints:

1 <= data.size() <= 1000000
1 <= queries.size() <= 1000000
data[i] <= 100 for all 0 <= i < data.size()
queries[i].getKey() is either 'delete' or 'find' for all 0 <= i < queries.size()
If queries[i].getKey() == "delete", then 1 <= queries[i].getValue() <= 5
The list data does not contain duplicates.
Example:

For List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) and List<Map.Entry<String, Integer>> queries = Arrays.asList(Map.entry("delete", 1), Map.entry("find", 0), Map.entry("delete", 2), Map.entry("find", 0)), the output should be [4, 5].
Reasoning: After the first deletion operation, the element 1 is removed from the list. The result of the first 'find' query is then 4 (the 3rd minimum). After the second deletion operation, the element 3 is deleted from the list. The result of the second 'find' query is then 5 (the 3rd minimum).
*/

package unit_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class KthMin {
    public List<Integer> solution(List<Integer> data, List<Map.Entry<String, Integer>> queries) throws Exception {
        // data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        data = new ArrayList<>(data);
        data.sort(Comparator.naturalOrder());
        
        // queries = {("delete", 1), ("find", 0), ("delete", 2), ("find", 0)}
        // (delete, 1) -> remove 1st min from data = {2, 3, 4, 5, 6, 7, 8, 9, 10}
        // find -> return 3rd min = 4
        // (delete, 2) -> remove 2nd min from data = {2, 4, 5, 6, 7, 8, 9, 10}
        // find -> return 3rd min = 5
        
        // result = {4, 5}
        List<Integer> findResults = new ArrayList<>();
        
        for(Map.Entry<String, Integer> query : queries) {            
            if (query.getKey().equals("delete")) { // (delete, k) -> remove kth min from data
                data.remove(query.getValue() - 1);
            } else if (query.getKey().equals("find")) { // find -> return 3rd min from data or -1
                if (data.size() < 3) {
                    findResults.add(-1);
                } else {
                    findResults.add(data.get(2));
                }
            } else {
                throw new Exception();
            }
        }
        
        return findResults;
    }
}
