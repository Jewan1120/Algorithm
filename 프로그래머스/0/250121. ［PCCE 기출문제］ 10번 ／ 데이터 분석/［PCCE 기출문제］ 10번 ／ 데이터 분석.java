import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> extMap = new HashMap<String, Integer>(4);
        extMap.put("code", 0);
        extMap.put("date", 1);
        extMap.put("maximum", 2);
        extMap.put("remain", 3);
        ArrayList<int[]> dataList = new ArrayList<int[]>();
        for (int[] datum : data) {
            if (datum[extMap.get(ext)] < val_ext) {
                dataList.add(datum);
            }
        }
        dataList.sort(new Comparator<int[]>() {
            @Override 
            public int compare(int[] o1, int[] o2) {
                int index = extMap.get(sort_by);
                return Integer.compare(o1[index], o2[index]);
            }
        });
        return dataList.toArray(new int[0][]);
    }
}