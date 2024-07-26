import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> album = new ArrayList<>();
        HashMap<String, Integer> genresRank = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> playsRank = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genresRank.putIfAbsent(genres[i], 0);
            genresRank.replace(genres[i], genresRank.get(genres[i]) + plays[i]);
            playsRank.putIfAbsent(genres[i], new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]));
            playsRank.get(genres[i]).add(new int[] {i, plays[i]});
        }
        ArrayList<String> keys = new ArrayList<>(genresRank.keySet());
        keys.sort((o1, o2) -> genresRank.get(o2) - genresRank.get(o1));
        for (String genre : keys) {
            int len = Math.min(2, playsRank.get(genre).size());
            for (int i = 0; i < len; i++) {
                album.add(playsRank.get(genre).poll()[0]);
            }
        }
        int[] answer = new int[album.size()];
        for (int i = 0; i < album.size(); i++)
            answer[i] = album.get(i);
        return answer;
    }
}