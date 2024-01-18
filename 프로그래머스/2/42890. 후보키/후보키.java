import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
class Solution {
    public int solution(String[][] relation) {
        Queue<boolean[]> chkQue = new ArrayDeque<>();
        ArrayList<boolean[]> prmQue = new ArrayList<>();
        chkQue.add(new boolean[relation[0].length]);
        while (!chkQue.isEmpty()) {
            boolean[] tmpChk = chkQue.poll();
            next: for (int i = 0; i < relation[0].length; i++) {
                if (!tmpChk[i]) {
                    tmpChk[i] = true;
                    HashSet<String> hs = new HashSet<>();
                    for (int j = 0; j < relation.length; j++) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < relation[0].length; k++) {
                            if (tmpChk[k]) {
                                sb.append(relation[j][k]).append("/");
                            }
                        }
                        if (hs.contains(sb.toString())) {
                            chkQue.add(tmpChk.clone());
                            tmpChk[i] = false;
                            continue next;
                        }
                        hs.add(sb.toString());
                    }
                    if (!prmQue.isEmpty()) {
                        for (boolean[] bs : prmQue) {
                            int count = 0;
                            for (boolean b : bs) {
                                if (b) {
                                    count++;
                                }
                            }
                            for (int j = 0; j < bs.length; j++) {
                                if (tmpChk[j] && bs[j]) {
                                    count--;
                                }
                            }
                            if (count <= 0) {
                                tmpChk[i] = false;
                                continue next;
                            }
                        }
                    }
                    prmQue.add(tmpChk.clone());
                    tmpChk[i] = false;
                }
            }
        }
        return prmQue.size() == 0 ? 1 : prmQue.size();
    }
}