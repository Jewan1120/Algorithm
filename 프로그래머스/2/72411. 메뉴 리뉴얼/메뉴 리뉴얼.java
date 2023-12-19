import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        HashMap<Integer, HashMap<String, Integer>> hm = new HashMap<>();
        for(int i : course){
            hm.put(i, new HashMap<>());
            maxMap.put(i, 0);
        }
        for(String order : orders){
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            order = new String(chars);
            Queue<String> que = new LinkedList<>();
            for(int i = 0; i < order.length() - 1; i++) que.add(String.valueOf(order.charAt(i)));
            while(!que.isEmpty()){
                String menu = que.poll();
                if(hm.containsKey(menu.length())){
                    HashMap<String, Integer> tmpMap = hm.get(menu.length());
                    int count = tmpMap.getOrDefault(menu, 0) + 1;
                    int num = maxMap.get(menu.length());
                    tmpMap.put(menu, count);
                    if(count > num) maxMap.replace(menu.length(), count);
                }
                int index = order.indexOf(menu.charAt(menu.length() - 1)) +1;
                for(int i = index; i < order.length(); i++){
                    que.add(menu + order.charAt(i));
                }
            }
        }
        for(int i : course){
            int target = maxMap.get(i);
            for(String str : hm.get(i).keySet()){
                int num = hm.get(i).get(str);
                if(num >= 2 && num == target){
                    if(answer.length == 0) answer = new String[]{str};
                    else{
                        String[] tmp = new String[answer.length + 1];
                        System.arraycopy(answer, 0, tmp, 0, answer.length);
                        tmp[answer.length] = str;
                        answer = tmp;
                    }
                }
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}