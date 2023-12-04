class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int count = 0;
        int maxHealth = health;
        int nextAttack = 0;
        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {
            if (i == attacks[nextAttack][0]) {
                health -= attacks[nextAttack][1];
                if (health <= 0) {
                    answer = -1;
                    break;
                }
                count = 0;
                nextAttack++;
            } else if (health < maxHealth) {
                health += bandage[1];
                count++;
                if (count == bandage[0]) {
                    count = 0;
                    health += bandage[2];
                }
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }
            answer = health;
        }
        return answer;
    }
}