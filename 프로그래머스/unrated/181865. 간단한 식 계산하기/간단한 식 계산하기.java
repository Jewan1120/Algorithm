class Solution {
    public int solution(String binomial) {
        String[] strArr = binomial.split(" ");
        int answer = 0;
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[2]);
        switch (strArr[1]) {
            case "+": {
                answer = x + y;
                break;
            }
            case "-": {
                answer = x - y;
                break;
            }
            case "*": {
                answer = x * y;
                break;
            }
        }
        return answer;
    }
}