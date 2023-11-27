class Solution {
        public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        int minX = board[0] / -2;
        int maxX = board[0] / 2;
        int minY = board[1] / -2;
        int maxY = board[1] / 2;
        for (String key : keyinput) {
            switch (key) {
                case "up":
                    if (answer[1] < maxY) {
                        answer[1]++;
                    }
                    break;
                case "down":
                    if (minY < answer[1]) {
                        answer[1]--;
                    }
                    break;
                case "left":
                    if (minX < answer[0]) {
                        answer[0]--;
                    }
                    break;
                case "right":
                    if (answer[0] < maxX) {
                        answer[0]++;
                    }
                    break;
            }
        }
        return answer;
    }
}