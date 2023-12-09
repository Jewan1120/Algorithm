import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> al = new ArrayList<String>(cacheSize);
        HashSet<String> hs = new HashSet<String>(cacheSize);
        if (cacheSize == 0) {
            answer = cities.length * 5;
        } else {
            for (String str : cities) {
                String city = str.toLowerCase();
                if (!hs.contains(city)) {
                    answer += 5;
                    if (hs.size() == cacheSize) {
                        String tmp = al.get(0);
                        hs.remove(tmp);
                        al.remove(0);
                    }
                    al.add(city);
                    hs.add(city);
                } else {
                    hs.add(city);
                    al.remove(al.indexOf(city));
                    al.add(city);
                    answer++;
                }
            }
        }
        return answer;
    }
}