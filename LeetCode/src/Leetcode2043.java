class Bank {
    private long[] result;
    public Bank(long[] balance) {
        result = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 - 1 >= 0 && account1 - 1 < result.length && account2 - 1 >= 0 && account2 - 1 < result.length){
            if(money > result[account1 - 1]){
                return false;
            }else{
                result[account1 - 1] -= money;
                result[account2 - 1] += money;
                return true;
            }
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(account - 1 >= 0 && account - 1 < result.length){
            result[account - 1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(account - 1 >= 0 && account - 1 < result.length){
            if(money > result[account - 1]){
                return false;
            }else{
                result[account - 1] -= money;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */