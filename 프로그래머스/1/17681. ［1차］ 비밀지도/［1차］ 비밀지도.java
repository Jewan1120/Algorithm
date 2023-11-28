class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        StringBuilder sb;
        for(int i = 0; i < n; i++){
            map1[i] = Integer.toString(arr1[i], 2);
            map2[i] = Integer.toString(arr2[i], 2);
            if(map1[i].length() < n){
                sb = new StringBuilder(map1[i]);
                sb.insert(0, "0".repeat(n - map1[i].length()));
                map1[i] = sb.toString();
            }
            if(map2[i].length() < n){
                sb = new StringBuilder(map2[i]);
                sb.insert(0, "0".repeat(n - map2[i].length()));
                map2[i] = sb.toString();
            }
        }
        for(int i = 0; i < answer.length; i++){
            sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(map1[i].charAt(j) == '1' || map2[i].charAt(j) == '1'){
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}