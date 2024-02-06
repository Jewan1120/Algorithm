import java.util.HashMap;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> number = new HashMap<>();
        int[][] logArr = new int[friends.length][friends.length];
        int[] giftIdx = new int[friends.length];
        int[] nextGift = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            number.put(friends[i], i);
        }
        for (String info : gifts) {
            String[] infoArr = info.split(" ");
            int from = number.get(infoArr[0]);
            int to = number.get(infoArr[1]);
            logArr[from][to]++;
            giftIdx[from]++;
            giftIdx[to]--;
        }
        for (int i = 0; i < giftIdx.length - 1; i++) {
            int p1 = number.get(friends[i]);
            for (int j = i + 1; j < giftIdx.length; j++) {
                int p2 = number.get(friends[j]);
                if (logArr[p1][p2] != 0 || logArr[p2][p1] != 0) {
                    chk1(nextGift, giftIdx, logArr, p1, p2);
                } else {
                    chk2(nextGift, giftIdx, p1, p2);
                }
            }
        }
        for (int i : nextGift) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
    public void chk1(int[] nextGift, int[] giftIdx, int[][] logArr, int p1, int p2) {
        if (logArr[p1][p2] > logArr[p2][p1]) {
            nextGift[p1]++;
        } else if (logArr[p1][p2] < logArr[p2][p1]) {
            nextGift[p2]++;
        } else {
            chk2(nextGift, giftIdx, p1, p2);
        }
    }
    public void chk2(int[] nextGift, int[] giftIdx, int p1, int p2) {
        if (giftIdx[p1] > giftIdx[p2]) {
            nextGift[p1]++;
        } else if (giftIdx[p1] < giftIdx[p2]) {
            nextGift[p2]++;
        }
    }
}