import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> keyMap = new HashMap<>(players.length);
        HashMap<Integer, String> valMap = new HashMap<>(players.length);
        for(int i = 0; i < players.length; i++){
            keyMap.put(players[i], i);
            valMap.put(i, players[i]);
        }
        for(String p1 : callings){
            int bk = keyMap.get(p1);
            int ft = bk - 1;
            String p2 = valMap.get(ft);
            keyMap.replace(p1, ft);
            valMap.replace(ft, p1);
            keyMap.replace(p2, bk);
            valMap.replace(bk, p2);
        }
        for(int i = 0; i < answer.length; i++){
            answer[i] = valMap.get(i);
        }
        return answer;
    }
}