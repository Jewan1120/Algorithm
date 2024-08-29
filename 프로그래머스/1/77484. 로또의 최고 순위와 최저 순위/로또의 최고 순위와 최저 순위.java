import java.util.HashSet;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < 6; i++)
            hs.add(win_nums[i]);
        int cnt = 0, zero = 0;
        for (int i = 0; i < 6; i++)
            if (hs.contains(lottos[i]))
                cnt++;
            else if (lottos[i] == 0)
                zero++;
        if (cnt == 6)
            return new int[] { 1, 1 };
        else if (zero == 6)
            return new int[] { 1, 6 };
        else if(cnt == 0 && zero == 0)
            return new int[] { 6, 6 };
        else
            return new int[] { 7 - (cnt + zero), 7 - cnt };
    }
}