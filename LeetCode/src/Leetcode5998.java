class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if(finalSum == 0 || finalSum % 2 == 1) return result;
        for(long i = 2; i <= finalSum; i += 2){
            finalSum -= i;
            result.add(i);
        }
        if(finalSum > 0){
            result.set(result.size() - 1, result.get(result.size() - 1) + finalSum);
        }
        return result;
    }
}