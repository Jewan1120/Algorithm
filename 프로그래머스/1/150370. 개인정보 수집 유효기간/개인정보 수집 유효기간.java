import java.util.HashMap;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[] dateTmp = today.split("\\.");
        int[] dateChk = new int[3];
        for(int i = 0; i < 3; i++){
            dateChk[i] = Integer.parseInt(dateTmp[i]);
        }
        HashMap<String, Integer> termMap = new HashMap<>(terms.length);
        for(String str : terms){
            String[] part = str.split(" ");
            termMap.put(part[0], Integer.parseInt(part[1]));
        }
        for(int i = 0; i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            String[] part = privacy[0].split("\\.");
            int[] date = new int[3];
            for(int j = 0; j < 3; j++){
                date[j] = Integer.parseInt(part[j]);
            }
            date[1] += termMap.get(privacy[1]);
            while(date[1] > 12){
                date[0]++;
                date[1] -= 12;
            }
            date[2]--;
            if(date[2] == 0 ){
                date[1]--;
                date[2] = 28;
                if(date[1] == 0){
                    date[0]--;
                    date[1] = 12;
                }
            }
            for(int j = 0; j < 3; j++){
                if(date[j] < dateChk[j]){
                    int[] tmp = new int[answer.length + 1];
                    System.arraycopy(answer, 0, tmp, 0, answer.length);
                    tmp[answer.length] = i + 1;
                    answer = tmp;
                    break;
                }else if(date[j] > dateChk[j]){
                    break;
                }
            }
        }
        return answer;
    }
}