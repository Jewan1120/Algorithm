class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        for (int i = 0; i < arr.length; i++) {
      if (answer.length == 0) {
        answer = new int[] {arr[i]};
      } else {
        if (answer[answer.length - 1] == arr[i]) {
          int[] tmp = new int[answer.length - 1];
          System.arraycopy(answer, 0, tmp, 0, tmp.length);
          answer = tmp;
        } else {
          int[] tmp = new int[answer.length + 1];
          System.arraycopy(answer, 0, tmp, 0, answer.length);
          tmp[answer.length] = arr[i];
          answer = tmp;
        }
      }
    }
    if (answer.length == 0) {
      answer = new int[] {-1};
    }
        return answer;
    }
}