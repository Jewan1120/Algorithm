class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        int answer = Integer.parseInt(arr[0]);
        for(int i = 1; i < arr.length; i += 2){
            switch(arr[i]){
                case "+":
                    answer += Integer.parseInt(arr[i+1]);
                    break;
                case "-":
                    answer -= Integer.parseInt(arr[i+1]);
                    break;
            }
        }
        return answer;
    }
}