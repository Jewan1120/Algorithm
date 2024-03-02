class Solution {
    public int solution(int[] numbers, int k) {
        int point = 0;
        while(k > 1){
            point += 2;
            if(point >= numbers.length){
                point %= numbers.length;
            }
            k--;
        }
        return numbers[point];
    }
}