import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String[] parts = numbers.split("");
        Arrays.sort(parts, (o1, o2) -> o2.compareTo(o1));
        StringBuilder sb = new StringBuilder();
        for (String str : parts) {
            sb.append(str);
        }
        int max = Integer.parseInt(sb.toString());
        boolean[] primeChk = new boolean[max + 1];
        HashSet<Integer> primeSet = new HashSet<>();
        primeChk[0] = primeChk[1] = true;
        for (int i = 2; i <= max; i++) {
            if (!primeChk[i]) {
                primeSet.add(i);
                for (int j = i; j <= max; j += i) {
                    primeChk[j] = true;
                }
            }
        }
        Queue<boolean[]> que = new LinkedList<>();
        Queue<StringBuilder> strQue = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        que.add(new boolean[parts.length]);
        strQue.add(new StringBuilder());
        while(!que.isEmpty()){
            boolean[] visited = que.poll();
            sb = new StringBuilder(strQue.poll());
            if(sb.length() > 0){
                hs.add(Integer.parseInt(sb.toString()));
            }
            for(int i = 0; i < visited.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    sb.append(parts[i]);
                    que.add(visited.clone());
                    strQue.add(new StringBuilder(sb));
                    visited[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        for(Integer i : hs) {
            if(primeSet.contains(i)) answer++;
        }
        return answer;
    }
}