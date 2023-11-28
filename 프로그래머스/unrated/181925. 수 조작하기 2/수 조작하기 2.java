class Solution {
    public String solution(int[] numLog) {
        StringBuilder control = new StringBuilder();
        for (int i = 0; i < numLog.length - 1; i++) {
            switch (numLog[i + 1] - numLog[i]) {
                case 1: 
                    control.append("w");
                    break;
                case -1:
                    control.append("s");
                    break;
                case 10:
                    control.append("d");
                    break;
                case -10:
                    control.append("a");
                    break;
            }
        }
        return control.toString();
    }
}