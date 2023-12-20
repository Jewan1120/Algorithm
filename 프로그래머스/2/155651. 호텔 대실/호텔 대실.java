import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, 
                    (o1, o2) -> !o1[0].split(":")[0].equals(o2[0].split(":")[0])
                        ? Integer.parseInt(o1[0].split(":")[0]) - Integer.parseInt(o2[0].split(":")[0])
                        : Integer.parseInt(o1[0].split(":")[1]) - Integer.parseInt(o2[0].split(":")[1]));
        ArrayList<Integer> roomArr = new ArrayList<>();
        next: for(String[] book : book_time){
            int strTime = Integer.parseInt(book[0].split(":")[0]) * 60 + Integer.parseInt(book[0].split(":")[1]);
            int endTime = Integer.parseInt(book[1].split(":")[0]) * 60 + Integer.parseInt(book[1].split(":")[1]) + 10;
            if(roomArr.isEmpty()) roomArr.add(endTime);
            else{
                for(int i = 0; i < roomArr.size(); i++){
                    if(strTime >= roomArr.get(i)){
                        roomArr.set(i, endTime);
                        continue next;
                    }
                }
                roomArr.add(endTime);
            }
        }
        return roomArr.size();
    }
}