import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> shopping = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            shopping.put(want[i], number[i]);
        }
        for(int i = 0; i <= discount.length - 10; i++){
            HashMap<String, Integer> checkMap = (HashMap<String, Integer>) shopping.clone();
            for(int j = i; j < i + 10; j++){
                if(!checkMap.containsKey(discount[j])){
                    break;
                }
                checkMap.replace(discount[j], checkMap.get(discount[j]) - 1);
                if(checkMap.get(discount[j]) == 0) checkMap.remove(discount[j]);
            }
            if(checkMap.size() == 0) answer++;
        }
        return answer;
    }
}