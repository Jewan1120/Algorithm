import java.util.HashSet;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] p = new int[2];
        HashSet<String> hs = new HashSet<>();
        for(String dir : dirs.split("")){
            StringBuilder s = new StringBuilder(dir).append(p[0]).append(p[1]);
            StringBuilder e = new StringBuilder();
            switch(dir){
                case "U" :
                    if(p[0] >= 5) continue;
                    p[0]++;
                    e.append("D");
                    break;
                case "D" :
                    if(p[0] <= -5) continue;
                    p[0]--;
                    e.append("U");
                    break;
                case "R" :
                    if(p[1] >= 5) continue;
                    p[1]++;
                    e.append("L");
                    break;
                case "L" :
                    if(p[1] <= -5) continue;
                    p[1]--;
                    e.append("R");
                    break;
            }
            e.append(p[0]).append(p[1]);
            if(!hs.contains(s.toString())){
                answer++;
                hs.add(s.toString());
                hs.add(e.toString());
            }
        }
        return answer;
    }
}