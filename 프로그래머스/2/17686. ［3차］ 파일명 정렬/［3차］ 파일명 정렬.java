import java.util.ArrayList;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<String[]> al = new ArrayList<>(files.length);
        for(int i = 0; i < files.length; i++){
            String[] tmp = new String[3];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            for(char c : files[i].toCharArray()){
                if(number.length() != 0 && !Character.isDigit(c)) break;
                if(!Character.isDigit(c)) head.append(c);
                else number.append(c);           
            }
            tmp[0] = String.valueOf(i);
            tmp[1] = head.toString().toLowerCase();
            tmp[2] = number.toString();
            al.add(tmp);
        }
        al.sort((s1, s2) -> s1[1].equals(s2[1]) ? Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]) : s1[1].compareTo(s2[1]));
        for(int i = 0; i < answer.length; i++) answer[i] = files[Integer.parseInt(al.get(i)[0])];
        return answer;
    }
}