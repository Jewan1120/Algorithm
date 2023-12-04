import java.util.HashMap;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for(int i = 0; i< park.length; i++){
            if(park[i].contains("S")){
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }
        HashMap<String, int[]> moveMap = new HashMap<>(4);
        moveMap.put("N", new int[]{ -1, 0 });
        moveMap.put("S", new int[]{ 1, 0 });
        moveMap.put("E", new int[]{ 0, 1 });
        moveMap.put("W", new int[]{ 0, -1 });
        next: for(String str : routes){
            int[] tmp = answer.clone();
            String[] dir = str.split(" ");
            int[] move = moveMap.get(dir[0]);
            for(int i = 0; i < Integer.parseInt(dir[1]); i++){
                tmp[0] += move[0];
                tmp[1] += move[1];
                if((0 > tmp[0] || tmp[0] >= park.length) || (0 > tmp[1] || tmp[1] >= park[0].length())){
                    continue next;
                }else if(park[tmp[0]].charAt(tmp[1]) == 'X'){
                    continue next;
                }
            }
            answer = tmp;
        }
        return answer;
    }
}