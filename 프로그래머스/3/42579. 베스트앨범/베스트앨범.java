import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, PriorityQueue<int[]>> rankHm = new HashMap<>();
        HashMap<String, Integer> totalHm = new HashMap<>();
        ArrayList<Object[]> totalAL = new ArrayList<>();
        HashMap<String, Integer> genreHs = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!rankHm.containsKey(genre)) {
                PriorityQueue<int[]> tmpQue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
                int size = genreHs.size();
                rankHm.put(genre, tmpQue);
                genreHs.put(genre, size);
                totalAL.add(new Object[] {genre, 0});
            }
            int idx = genreHs.get(genre);
            rankHm.get(genre).add(new int[] {i, play});
            totalHm.put(genre, totalHm.getOrDefault(genre, 0) + play);
            totalAL.get(idx)[1] = (int) totalAL.get(idx)[1] + play;
        }
        totalAL.sort((o1, o2) -> (int) o2[1] - (int) o1[1]);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < rankHm.size(); i++) {
            String genre = (String) totalAL.get(i)[0];
            PriorityQueue<int[]> tmpQue = rankHm.get(genre);
            int queSize = tmpQue.size();
            result.add(tmpQue.poll()[0]);
            if (queSize > 1) {
                result.add(tmpQue.poll()[0]);
            }
        }
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}