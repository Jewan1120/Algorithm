import java.util.HashMap;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> keyboard = new HashMap<>();
        for(String keys : keymap){
            char[] key = keys.toCharArray();
            for(int i = 0; i < keys.length(); i++){
                if(!keyboard.containsKey(key[i])){
                    keyboard.put(key[i], i + 1);
                }else if(i + 1 < keyboard.get(key[i])){
                    keyboard.replace(key[i], i + 1);
                }
            }
        }
        for(int i = 0; i < targets.length; i++){
            for(char c : targets[i].toCharArray()){
                if(!keyboard.containsKey(c)){
                    answer[i] = -1;
                    break;
                }
                answer[i] += keyboard.get(c);
            }
        }
        return answer;
    }
}