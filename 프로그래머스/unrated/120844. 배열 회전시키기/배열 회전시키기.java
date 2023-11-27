class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        int s = 0;
        int e = 0;
        int point = 0;
        int value = 0;
        switch(direction){
            case "left":
                s  = 1;
                point = numbers.length - 1;
                value = numbers[0];
                break;
            case "right":
                e  = 1;
                value = numbers[numbers.length - 1];
                break;
        }
        int[] tmp = new int[numbers.length];
        System.arraycopy(numbers, s, tmp, e, numbers.length - 1);
        tmp[point] = value;
        numbers = tmp;
        return numbers;
    }
}