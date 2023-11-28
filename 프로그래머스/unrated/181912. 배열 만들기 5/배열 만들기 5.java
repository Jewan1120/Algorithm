class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        for (String str : intStrs) {
            int i = Integer.parseInt(str.substring(s, s + l));
            if (i > k) {
                if (answer.length == 0) {
                    answer = new int[] {i};
                } else {
                    int[] tmp = new int[answer.length + 1];
                    System.arraycopy(answer, 0, tmp, 0, answer.length);
                  tmp[answer.length] = i;
                    answer = tmp;
                }
            }
        }
        return answer;
    }
}