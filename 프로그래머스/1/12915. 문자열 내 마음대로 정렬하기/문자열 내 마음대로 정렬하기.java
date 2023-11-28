class Solution {
    public String[] solution(String[] strings, int n) {
        for(int i = 0; i < strings.length - 1; i ++){
            for(int j = 0; j < strings.length - i - 1; j ++){
                boolean changeFlg = false;
                if(strings[j].charAt(n) > strings[j + 1].charAt(n)){
                    changeFlg = true;
                } else if(strings[j + 1].contains(strings[j])){
                    changeFlg = true;
                } else if (strings[j].charAt(n) == strings[j + 1].charAt(n)){
                    for(int k = 0; k < Math.min(strings[j].length(), strings[j + 1].length()); k ++){
                        if(strings[j].charAt(k) != strings[j + 1].charAt(k)){
                            if(strings[j].charAt(k) > strings[j + 1].charAt(k)){
                                changeFlg = true;   
                            }
                            break;
                        }
                    }
                }
                if(changeFlg){
                    String tmp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = tmp;
                }
            }
        }
        return strings;
    }
}