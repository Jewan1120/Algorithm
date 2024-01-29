import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        for (String str : info) {
            Queue<String[]> sbQue = new ArrayDeque<>();
            Queue<boolean[]> chkQue = new ArrayDeque<>();
            Queue<Integer> idxQue = new ArrayDeque<>();
            sbQue.add(new String[] {"-", "-", "-", "-"});
            chkQue.add(new boolean[4]);
            idxQue.add(0);
            String[] parts = str.split(" ");
            int value = Integer.parseInt(parts[4]);
            while (!sbQue.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                String[] sbArr = sbQue.poll();
                boolean[] chkArr = chkQue.poll();
                int idx = idxQue.poll();
                if (idx > 4) {
                    continue;
                }
                for (int i = 0; i < sbArr.length; i++) {
                    sb.append(sbArr[i]);
                    if (i < sbArr.length - 1) {
                        sb.append(" and ");
                    }
                }
                if (!hm.containsKey(sb.toString())) {
                    hm.put(sb.toString(), new ArrayList<>());
                }
                hm.get(sb.toString()).add(value);
                for (int i = idx; i < chkArr.length; i++) {
                    if (!chkArr[i]) {
                        chkArr[i] = true;
                        String[] tmpArr = sbArr.clone();
                        tmpArr[i] = parts[i];
                        sbQue.add(tmpArr);
                        chkQue.add(chkArr.clone());
                        idxQue.add(i);
                        chkArr[i] = false;
                    }
                }
            }
        }
        for (ArrayList<Integer> al : hm.values()) {
            al.sort((o1, o2) -> o1 - o2);
        }
        for (int i = 0; i < query.length; i++) {
            String str = query[i];
            String condition = str.substring(0, str.lastIndexOf(" "));
            int score = Integer.parseInt(str.substring(str.lastIndexOf(" ") + 1));
            if (hm.containsKey(condition)) {
                ArrayList<Integer> al = hm.get(condition);
                int s = 0;
                int e = al.size();
                while (s < e) {
                    int m = (s + e) / 2;
                    if (al.get(m) >= score) {
                        e = m;
                    } else {
                        s = m + 1;
                    }
                }
                answer[i] = al.size() - s;
            }
        }
        return answer;
    }
}