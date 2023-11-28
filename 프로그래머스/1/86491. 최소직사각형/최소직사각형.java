class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int[] size : sizes) {
            int width = size[0] > size[1] ? size[0] : size[1];
            int height = size[0] > size[1] ? size[1] : size[0];
            if (width > maxWidth) {
                maxWidth = width;
            }
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxWidth * maxHeight;
    }
}