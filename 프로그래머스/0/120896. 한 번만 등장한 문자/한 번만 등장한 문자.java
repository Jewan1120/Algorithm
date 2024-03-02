class Solution {
    public String solution(String s) {
        char[] arr = {};
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(s.indexOf(c) == s.lastIndexOf(c)){
                char[] tmp = new char[arr.length + 1];
                System.arraycopy(arr, 0, tmp, 0, arr.length);
                tmp[arr.length] = c;
                arr = tmp;
            }
        }
        if(arr.length > 0){
            for(int i = 0; i < arr.length - 1; i ++){
                for(int j = 0; j < arr.length - 1; j ++){
                    if(arr[j] > arr[j + 1]){
                        char tmp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString();
    }
}