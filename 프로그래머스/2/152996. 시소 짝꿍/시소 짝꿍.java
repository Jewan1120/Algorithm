import java.util.HashMap;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Float, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> dup = new HashMap<>();
        for (int i = weights.length - 1; i >= 0; i--) {
            int w = weights[i];
            if (!dup.containsKey(w)) {
                dup.put(w, 1);
            } else {
                dup.replace(w, dup.get(w) + 1);
            }
            for (int j = 1; j <= 3; j++) {
                float tmp = (float) w * j / (j + 1);
                if (!hm.containsKey(tmp)) {
                    hm.put(tmp, 1);
                } else {
                    hm.replace(tmp, hm.get(tmp) + 1);
                }
            }
        }
        for (int w : weights) {
            if (hm.containsKey((float) w)) {
                answer += hm.get((float) w);
            }
        }
        for (long v : dup.values()) {
            if (v > 1) {
                answer += v * (v - 1) / 2;
            }
        }
        return answer;
    }
}