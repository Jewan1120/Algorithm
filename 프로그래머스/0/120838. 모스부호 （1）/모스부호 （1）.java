class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String code : letter.split(" ")){
            for(int i = 0; i < morse.length; i++){
                if(code.equals(morse[i])){
                    sb.append((char)('a' + i));
                }
            }
        }
        return sb.toString();
    }
}