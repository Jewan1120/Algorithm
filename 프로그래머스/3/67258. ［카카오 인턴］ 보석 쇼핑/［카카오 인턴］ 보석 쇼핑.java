import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, Integer.MAX_VALUE};
        HashSet<String> gemSet = new HashSet<>();
        for(String gem : gems) gemSet.add(gem);
        HashMap<String, Integer> getGemMap = new HashMap<>();
        int s = 0, e = 0;
        getGemMap.put(gems[s], 1);
        while(e < gems.length){
            if(getGemMap.size() < gemSet.size()){
                e++;
                if(e == gems.length) break;
                if(!getGemMap.containsKey(gems[e])) getGemMap.put(gems[e], 0);
                getGemMap.replace(gems[e], getGemMap.get(gems[e]) + 1);
            } else {
                getGemMap.replace(gems[s], getGemMap.get(gems[s]) - 1);
                if(getGemMap.get(gems[s]) == 0) getGemMap.remove(gems[s]);
                if(answer[1] - answer[0] > e - s){
                    answer[0] = s + 1;
                    answer[1] = e + 1;
                }
                s++;
            }
        }
        return answer;
    }
}