import java.util.HashSet;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> skipChars = new HashSet<Character>();
        for(char c : skip.toCharArray()){
            skipChars.add(c);
        }
        for(char c : s.toCharArray()){
            char conv = c;
            for(int i = 0; i < index;){
                conv++;
                if(conv > 'z') conv -= 26;
                if(!skipChars.contains(conv)){
                    i++;
                } 
            }
            sb.append(conv);
        }
        return sb.toString();
    }
}