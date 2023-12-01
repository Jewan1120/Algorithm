class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 1}, {3, 2} };
        int[] left = keypad[9];
        int[] right = keypad[11];
        StringBuilder sb = new StringBuilder();
        for(int n : numbers){
            int[] key;
            boolean flg = false; // false = letf, true = right
            if(n == 0){
                key = keypad[10];
            }else{
                key = keypad[n - 1];
            }
            switch(key[1]){
                case 1:
                    int ld = Math.abs((left[0] - key[0])) + Math.abs((left[1] - key[1]));
                    int rd = Math.abs((right[0] - key[0])) + Math.abs((right[1] - key[1]));
                    if((ld == rd && hand.equals("right")) || ld > rd){
                            flg = true;
                    }
                    break;
                case 2:
                    flg = true;
                    break;
                }
                if(!flg){
                    left = key;
                    sb.append("L");
                }else{
                    right = key;
                    sb.append("R");
                }
        }
        return sb.toString();
    }
}