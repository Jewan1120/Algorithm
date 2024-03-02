class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        boolean flg = false;

    int j = 0;

    for (int i = 0; i < myStr.length(); i++) {
      if (myStr.charAt(i) == 'a' || myStr.charAt(i) == 'b' || myStr.charAt(i) == 'c') {
        if (flg) {
          j++;
        }
        flg = false;
        continue;
      } else if (!flg) {
        String[] tmp = new String[answer.length + 1];
        System.arraycopy(answer, 0, tmp, 0, answer.length);
        tmp[answer.length] = "";
        answer = tmp;
        flg = true;
      }
      if (flg) {
        answer[j] += myStr.charAt(i);
      }
    }
    if (answer.length == 0) {
      answer = new String[] {"EMPTY"};
    }
        return answer;
    }
}