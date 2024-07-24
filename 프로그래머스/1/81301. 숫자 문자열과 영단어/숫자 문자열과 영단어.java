class Solution {
    public int solution(String s) {
        String[][] alphabets = {{"zero", "0"}, {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"},
                {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"}, {"nine", "9"}};
        for (String[] code : alphabets) {
            s = s.replace(code[0], code[1]);
        }
        return Integer.parseInt(s);
    }
}