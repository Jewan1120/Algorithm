import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
class Solution {
    public int solution(int n, String[] data) {
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};
        HashSet<String> usedMembers = new HashSet<>();
        Queue<String[]> positionQue = new ArrayDeque<>();
        positionQue.add(new String[] {"", "", "", "", "", "", "", ""});
        for (String condition : data) {
            String[] conditions = condition.split("");
            String p1 = conditions[0];
            String p2 = conditions[2];
            String oper = conditions[3];
            int distance = Integer.parseInt(conditions[4]) + 1;
            int used = 0;
            boolean[] usedChk = new boolean[2];
            for (int i = 0; i < 2; i++) {
                if (!usedMembers.add(conditions[i * 2])) {
                    used++;
                    usedChk[i] = true;
                }
            }
            int size = positionQue.size();
            while (size > 0) {
                String[] position = positionQue.poll();
                size--;
                switch (used) {
                    case 0:
                        for (int i = 0; i < position.length; i++) {
                            if (position[i].equals("")) {
                                for (int j = 0; j < position.length; j++) {
                                    String[] tmpPosition = position.clone();
                                    tmpPosition[i] = p1;
                                    int gap = Math.abs(i - j);
                                    if (tmpPosition[j].equals("") && chkPosition(oper, distance, gap)) {
                                        tmpPosition[j] = p2;
                                        positionQue.add(tmpPosition);
                                    }
                                }
                            }
                        }
                        break;
                    case 1:
                        String usedMember = "";
                        String NotUsedMember = "";
                        if (usedChk[0]) {
                            usedMember = p1;
                            NotUsedMember = p2;
                        } else {
                            usedMember = p2;
                            NotUsedMember = p1;
                        }
                        for (int i = 0; i < position.length; i++) {
                            if (position[i].equals(usedMember)) {
                                for (int j = 0; j < position.length; j++) {
                                    String[] tmpPosition = position.clone();
                                    int gap = Math.abs(i - j);
                                    if (tmpPosition[j].equals("") && chkPosition(oper, distance, gap)) {
                                        tmpPosition[j] = NotUsedMember;
                                        positionQue.add(tmpPosition);
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < position.length; i++) {
                            if (position[i].equals(p1)) {
                                for (int j = 0; j < position.length; j++) {
                                    if (position[j].equals(p2)) {
                                        int gap = Math.abs(i - j);
                                        if (chkPosition(oper, distance, gap)) {
                                            positionQue.add(position.clone());
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        break;
                }
            }
        }
        return positionQue.size() * factorial[8 - usedMembers.size()];
    }
    
    public static boolean chkPosition(String oper, int distance, int gap) {
        switch (oper) {
            case "=":
                if (gap == distance) {
                    return true;
                }
                break;
            case "<":
                if (gap < distance) {
                    return true;
                }
                break;
            case ">":
                if (gap > distance) {
                    return true;
                }
                break;
        }
        return false;
    }
}