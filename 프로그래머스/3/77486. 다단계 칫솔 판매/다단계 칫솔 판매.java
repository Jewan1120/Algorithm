import java.util.HashMap;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        HashMap<String, Integer> enrollMap = new HashMap<>();
        HashMap<String, String> referralMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            enrollMap.put(enroll[i], i);
            referralMap.put(enroll[i], referral[i]);
        }
        for (int i = 0; i < seller.length; i++){
            String name = seller[i];
            int idx = enrollMap.get(name);
            int total = amount[i] * 100;
            int tip = total / 10;
            answer[idx] += total - tip;
            while (!referralMap.get(name).equals("-")) {
                if (tip == 0) break;
                idx = enrollMap.get(referralMap.get(name));
                total = tip;
                tip /= 10;
                answer[idx] += total - tip;
                name = referralMap.get(name);
            }
        }
        return answer;
    }
}