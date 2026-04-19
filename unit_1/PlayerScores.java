/*
You are given two lists, player_ids and player_scores, where each ID in player_ids corresponds to a score in player_scores, i.e. the score of player_ids[i] is player_scores[i]. Additionally, you have a list named queries, containing player IDs.

Your task is to implement a function, solution, that returns a list of scores for the players specified in the queries list, using player_ids and player_scores for reference. If a player ID from the queries list does not exist, skip that query.

Constraints:

1≤len(player_ids)≤1000000
1≤len(player_ids)≤1000000, where len(player_ids) denotes the number of players.
player_ids contain unique integer identifiers for each player.
−10
6
≤
player_scores
[
i
]
≤
10
6
−10
6
≤player_scores[i]≤10
6
, where player_scores[i] represents the score of the i-th player.
1≤len(queries)≤1000000
1≤len(queries)≤1000000, where len(queries) indicates the size of the queries list.
Each element in the queries list is an integer.
Example:

If player_ids = [1, 2, 3, 4, 5], player_scores = [100, 200, 150, 50, 300], and queries = [2, 5, 1], the output should be [200, 300, 100].
 */

package unit_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerScores {
     public List<Integer> solution(List<Integer> player_ids, List<Integer> player_scores, List<Integer> queries) {
        // TODO: implement your solution here
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> players = new HashMap<>();
        
        for (int i = 0; i < player_ids.size(); i++) {
            players.put(player_ids.get(i), player_scores.get(i));
        }
        
        for (int queryId: queries) {
            if (players.containsKey(queryId)) {
                result.add(players.get(queryId));
            }
        }
        
        return result;
    }
}
