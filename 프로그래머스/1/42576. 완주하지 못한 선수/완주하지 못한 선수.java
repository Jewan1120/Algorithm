import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> person = new HashMap<>(participant.length);
        for(String str : participant){
            if(!person.containsKey(str)){
                person.put(str, 1);
            }else{
                person.replace(str, person.get(str) + 1);
            }
        }
        for(String str : completion){
            person.replace(str, person.get(str) - 1);
            if(person.get(str) == 0){
                person.remove(str);
            }
        }
        for(String str : person.keySet()){
            answer = str;
        }
        return answer;
    }
}