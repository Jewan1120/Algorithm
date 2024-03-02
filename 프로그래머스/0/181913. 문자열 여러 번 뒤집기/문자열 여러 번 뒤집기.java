class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries)
        {
            String tmp = my_string.substring(query[0], query[1] + 1);
            StringBuilder sb = new StringBuilder(tmp);
            my_string = my_string.substring(0, query[0]) + sb.reverse().toString()+ my_string.substring(query[1] + 1);
        }
        return my_string;
    }
}