class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        int result = 0;
        for(int i : energy) {
            sum += i;
        }
        result += sum - initialEnergy >= 0 ? (sum - initialEnergy + 1) : 0;
        for(int i : experience) {
            if(initialExperience <= i) {
                result += i - initialExperience + 1;
                initialExperience = i + 1;
            }
            initialExperience += i;
        }
        return result;
    }
}