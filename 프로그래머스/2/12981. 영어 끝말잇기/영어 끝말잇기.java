import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> wordSet = new HashSet<>(words.length);
        int turn = 1;
        int rotation =1;
        for(int i = 0; i< words.length; i++){
            if(wordSet.isEmpty()) wordSet.add(words[i]);
            else if(wordSet.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i -1].length() - 1)){
                answer[0] = turn;
                answer[1] = rotation;
                break;
            }else wordSet.add(words[i]);
            turn++;
            if(turn > n){
                rotation++;
                turn =1;
            }
        }
        return answer;
    }
}