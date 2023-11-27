class Solution {
    public int[] solution(int[] numlist, int n) {
        for(int i = 0; i < numlist.length -1; i ++){
            for(int j = 0; j < numlist.length - 1 - i; j++){
                int a = Math.abs(numlist[j] - n);
                int b = Math.abs(numlist[j + 1] - n);
                if(a > b || (a == b && numlist[j] < numlist[j + 1])){
                    int tmp = numlist[j + 1];
                    numlist[j + 1] = numlist[j];
                    numlist[j] = tmp;
                }
            }
        }
        return numlist;
    }
}