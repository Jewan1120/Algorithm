class Solution {
    public int[][] solution(int[][] arr) {
        int width = arr[0].length;
        int height = arr.length;
        if (width > height) {
            int[][] tmp = new int[width][width];
            System.arraycopy(arr, 0, tmp, 0, height);
            arr = tmp;
        } else if (width < height) {
            for (int i = 0; i < arr.length; i++) {
                int[] tmp = new int[height];
                System.arraycopy(arr[i], 0, tmp, 0, width);
                arr[i] = tmp;
            }
        }
        return arr;
    }
}