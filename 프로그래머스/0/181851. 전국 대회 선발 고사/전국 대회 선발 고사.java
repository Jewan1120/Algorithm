class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] student = {};
        for(int i = 0; i < attendance.length; i++){
            if(attendance[i]){
                int[] tmp = new int[student.length + 1];
                System.arraycopy(student, 0, tmp, 0, student.length);
                tmp[student.length] = rank[i];
                student = tmp;
            }
        }
        for(int i = 0; i< student.length - 1; i++){
            for(int j = 0; j < student.length - i - 1; j++){
                if(student[j] > student[j + 1]){
                    int tmp = student[j];
                    student[j] = student[j + 1];
                    student[j + 1] = tmp;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < rank.length; j++){
                if(student[i] == rank[j]){
                    answer += Math.pow(100, 2 - i) * j;
                }
            }
        }
        return answer;
    }
}