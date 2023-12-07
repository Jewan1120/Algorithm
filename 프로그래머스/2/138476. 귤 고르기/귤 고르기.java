import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : tangerine){
            if(!hm. containsKey(i)) hm.put(i, 1);
            else hm.replace(i, hm.get(i) + 1);
        }
        ArrayList<Integer> al = new ArrayList<>(hm.keySet());
        al.sort((i1, i2) -> hm.get(i2) - hm.get(i1));
        for(Integer i : al){
            k -= hm.get(i);
            answer++;
            if(k <= 0) break;
        }
        return answer;
    }
}