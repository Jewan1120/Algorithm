class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String regex = "[^" + skill + "]";
        for (String skill_tree : skill_trees)
            if (skill.indexOf(skill_tree.replaceAll(regex, "")) == 0)
                answer++;
        return answer;
    }
}