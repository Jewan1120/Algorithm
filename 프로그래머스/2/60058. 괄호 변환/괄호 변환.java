import java.util.Stack;
class Solution {
    public String solution(String p) {
        StringBuilder ft = new StringBuilder();
        StringBuilder bk = new StringBuilder();
        Stack<String> stk = new Stack<>();
        stk.push(p);
        while(!stk.isEmpty()){
            String w = stk.pop();
            if(w.equals("")) continue;
            int i = 0, n = 1;
            char c = w.charAt(i);
            while(n != 0){
                if(c != w.charAt(++i)) n--;
                else n++;
            }
            String u = w.substring(0, i + 1);
            String v = w.substring(i + 1);
            if(u.replaceAll("\\(+\\)+", "").length() == 0){
                ft.append(u);
                stk.push(v);
            }else{
                ft.append("(");
                StringBuilder tmpSb = new StringBuilder(")");
                for(int j = 1; j < u.length() - 1; j++){
                    if(u.charAt(j) == '(') tmpSb.append(')');
                    else tmpSb.append('(');
                }
                bk.insert(0, tmpSb);
                stk.push(v);
            }
        }
        return ft.append(bk).toString();
    }
}