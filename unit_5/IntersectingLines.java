package unit_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntersectingLines {
    static class Interval {
        int start, end;
        Interval(int s, int e) { start = s; end = e; }
    }
    
    public static List<Integer> solution(List<int[]> intervals, List<int[]> queries) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Interval> sortedIvs = new TreeMap<>();
        
        for (int[] iv : intervals) {
            sortedIvs.put(iv[0], new Interval(iv[0], iv[1]));
        }
                
        for (int[] query : queries) {            
            int opType = query[0];
            int a = query[1];
            int b = query[2];

            if (opType == 0) {
                result.add(intersects(sortedIvs, a, b) ? 1 : 0);
            } else if (opType == 1) {         
                sortedIvs = remove(sortedIvs, a, b);
                result.add(sortedIvs.size());
            }
        }
        
        return result;
    }
    
    private static boolean intersects(TreeMap<Integer, Interval> sortedIvs, int a, int b) {
        Map.Entry<Integer, Interval> left = sortedIvs.floorEntry(a);
        if (left != null) {
            Interval iv = left.getValue();
            if (iv.end >= a) {
                return true;
            }
        }
        
        Map.Entry<Integer, Interval> right = sortedIvs.ceilingEntry(a);
        if (right != null) {
            Interval iv = right.getValue();
            if (iv.start <= b) {
                return true;
            }
        }
        
        return false;
    }
    
    private static TreeMap<Integer, Interval> remove(TreeMap<Integer, Interval> sortedIvs, int a, int b) {
        if (sortedIvs.containsKey(a) && sortedIvs.get(a).end == b) {
            sortedIvs.remove(a);
        }
        return sortedIvs;
    }
}
