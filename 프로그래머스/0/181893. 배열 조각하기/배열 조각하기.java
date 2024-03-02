class Solution {
    public int[] solution(int[] arr, int[] query) {
        for (int i = 0; i < query.length; i++) {
          int[] tmp = {};
          if (i % 2 == 0) {
            tmp = new int[query[i] + 1];
            System.arraycopy(arr, 0, tmp, 0, tmp.length);
          } else {
            tmp = new int[arr.length - query[i]];
            System.arraycopy(arr, query[i], tmp, 0, tmp.length);
          }
          arr = tmp;
        }
        return arr;
    }
}