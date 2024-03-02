class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int n = 0;
        String[] parts = polynomial.split("\\s[+]\\s");
        for(String part : parts){
            if(part.contains("x")){
                if(part.length() == 1){
                    x++;
                } else {
                    x += Integer.parseInt(part.replace("x", ""));
                }
            } else {
                n += Integer.parseInt(part);
            }
        }
        String X = "";
        if(x > 1){
            X = x + "x";
        } else if(x == 1){
            X = "x";
        }
        String N = "";
        if(n > 0){
            if(x > 0){
                N = " + " + n;
            } else{
                N = String.valueOf(n);
            }
        }
        return X + N;
    }
}