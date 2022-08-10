class UndergroundSystem {
    private final String DELIMETER = ",";
    private HashMap<Integer, Event> arrival;
    private HashMap<String, Average> ave;

    public UndergroundSystem() {
        arrival = new HashMap<>();
        ave = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        arrival.put(id, new Event(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Event theEvent = arrival.get(id);
        arrival.remove(id);
        int diff = t - theEvent.t;
        String key = theEvent.stationName + DELIMETER + stationName;
        Average theAverage = ave.containsKey(key) ? ave.get(key) : new Average();
        theAverage.updateAverage(diff);
        ave.put(key, theAverage);
    }

    public double getAverageTime(String startStation, String endStation) {
        return ave.get(startStation + DELIMETER + endStation).getAverage();
    }

    class Event {
        int id;
        String stationName;
        int t;
        public Event(int id, String stationName, int t) {
            this.id = id;
            this.stationName = stationName;
            this.t = t;
        }
    }

    class Average {
        double total = 0.0;
        int count = 0;
        public void updateAverage (int diff) {
            ++ count;
            total += diff;
        }
        public double getAverage(){
            return total / count;
        }
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */