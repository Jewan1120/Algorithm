import java.util.HashMap;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int n = 0;
        int u = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0; i < str1.length() - 1; i++){
            String part = str1.substring(i, i + 2);
            if(!part.matches("[a-z]+")) continue;
            hm.put(part, hm.getOrDefault(part, 0) + 1);
            u++;
        }
        for(int i = 0; i < str2.length() - 1; i++){
            String part = str2.substring(i, i + 2);
            if(!part.matches("[a-z]+")) continue;
            if(hm.containsKey(part)){
                n++;
                hm.replace(part, hm.get(part) - 1);
                if(hm.get(part) == 0) hm.remove(part);
            }else u++;
        }
        return n != 0 || u != 0 ? (int)(((double) n / u) * 65536) : 65536;
    }
}