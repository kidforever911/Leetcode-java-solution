class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        HashMap<String, List<Transaction>> record = new HashMap<>();
        for(String s : transactions) {
            Transaction theTransaction = new Transaction(s);
            if(record.containsKey(theTransaction.name)) {
                record.get(theTransaction.name).add(theTransaction);
            } else {
                List<Transaction> list = new ArrayList<>();
                list.add(theTransaction);
                record.put(theTransaction.name, list);
            }
        }
        for(String s : transactions) {
            Transaction theTransaction = new Transaction(s);
            if(!isValid(record.get(theTransaction.name), theTransaction)) {
                invalid.add(s);
            }
        }
        return invalid;
    }

    private boolean isValid(List<Transaction> list, Transaction theTransaction) {
        for(Transaction temp : list) {
            if(theTransaction.isInvalidTransaction(temp.city, temp.time)) {
                return false;
            }
        }
        return true;
    }

    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        public Transaction(String s) {
            String[] str = s.split(",");
            this.name = str[0];
            this.time = Integer.parseInt(str[1]);
            this.amount = Integer.parseInt(str[2]);
            this.city = str[3];
        }
        public boolean isInvalidTransaction(String city, int time) {
            return invalidAmount() || differentCity(city, time);
        }
        public boolean invalidAmount() {
            return this.amount > 1000;
        }
        public boolean differentCity(String city, int time) {
            return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
        }
    }
}