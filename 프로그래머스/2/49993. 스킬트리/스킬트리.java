class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String regex = "[^" + skill + "]";
        for(String str : skill_trees) if(skill.indexOf(str.replaceAll(regex, "")) == 0) answer ++;
        return answer;
    }
}