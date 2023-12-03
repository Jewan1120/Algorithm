class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lx = Integer.MAX_VALUE, ly = Integer.MAX_VALUE, rx = Integer.MIN_VALUE, ry = Integer.MIN_VALUE;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < wallpaper.length; j++) {
                int filef = wallpaper[j].indexOf("#");
                int filel = wallpaper[j].lastIndexOf("#");
                if (filef >= 0) {
                    if (lx > j) {
                        lx = j;
                    }
                    if (ly > filef) {
                        ly = filef;
                    }
                    if (rx < j) {
                        rx = j;
                    }
                    if (ry < filel) {
                        ry = filel;
                    }
                }
            }
        }
        answer = new int[] {lx, ly, rx + 1, ry + 1};
        return answer;
    }
}