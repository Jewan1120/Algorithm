class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        for (int i = 0; i < flag.length; i++) {
      if (flag[i]) {
        int[] tmp = new int[answer.length + arr[i] * 2];
        System.arraycopy(answer, 0, tmp, 0, answer.length);
        for (int j = answer.length; j < tmp.length; j++) {
          tmp[j] = arr[i];
        }
        answer = tmp;
      } else {
        int[] tmp = new int[answer.length - arr[i]];
        System.arraycopy(answer, 0, tmp, 0, tmp.length);
        answer = tmp;
      }
    }
        return answer;
    }
}