class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int c = i + 1;
                while(c < name.length() && name.charAt(c) == 'A') {
                    c++;
                }
                move = Math.min(move, i * 2 + (name.length() - c));
                move = Math.min(move, i + (name.length() - c) * 2);
            }
        }
        return answer + move;
    }
}