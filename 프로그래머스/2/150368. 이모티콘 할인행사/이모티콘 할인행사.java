import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        Queue<int[]> discountQue = new ArrayDeque<>();
        HashSet<String> chk = new HashSet<>();
        ArrayList<int[]> resultList = new ArrayList<>();
        discountQue.add(new int[emoticons.length]);
                while (!discountQue.isEmpty()) {
            int[] discount = discountQue.poll();
            int[] result = new int[2];
            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                int ratio = (int) Math.ceil((double) users[i][0] / 10) - 1;
                for (int j = 0; j < emoticons.length; j++) {
                    if (discount[j] >= ratio) {
                        sum += emoticons[j] * (9 - discount[j]) / 10;
                    }
                }
                if (sum >= users[i][1]) {
                    result[0]++;
                } else {
                    result[1] += sum;
                }
            }
            resultList.add(result);
            for (int i = 0; i < discount.length; i++) {
                if (discount[i] < 3) {
                    discount[i]++;
                    StringBuilder sb = new StringBuilder();
                    for (int j : discount) {
                        sb.append(j);
                    }
                    if (!chk.contains(sb.toString())) {
                        chk.add(sb.toString());
                        discountQue.add(discount.clone());
                    }
                    discount[i]--;
                }
            }
        }
        resultList.sort((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        return resultList.get(0);
    }
}