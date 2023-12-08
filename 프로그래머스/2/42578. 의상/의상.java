import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] arr : clothes) hm.put(arr[1], hm.getOrDefault(arr[1], 1) + 1);
        for(int i : hm.values()) answer *= i;
        return answer - 1;
    }
}