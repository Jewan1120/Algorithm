import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        Queue<String> strQue = new ArrayDeque<>();
        Queue<Integer> cntQue = new ArrayDeque<>();
        Queue<boolean[]> chkQue = new ArrayDeque<>();
        strQue.add(begin);
        cntQue.add(0);
        chkQue.add(new boolean[words.length]);
        while (!strQue.isEmpty()) {
            String prev = strQue.poll();
            int cnt = cntQue.poll();
            boolean[] chk = chkQue.poll();
            if (prev.equals(target)) {
                answer = Math.min(answer, cnt);
                continue;
            }
            for (int i = 0; i < chk.length; i++) {
                String next = words[i];
                if (!chk[i] && chk(prev, next)) {
                    chk[i] = true;
                    strQue.add(next);
                    cntQue.add(cnt + 1);
                    chkQue.add(chk.clone());
                    chk[i] = false;
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }
    public boolean chk(String prev, String next) {
        char[] prevArr = prev.toCharArray();
        char[] nextArr = next.toCharArray();
        int cnt = 0;
        for (int i = 0; i < prevArr.length; i++) {
            if (prevArr[i] != nextArr[i]) {
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }
}