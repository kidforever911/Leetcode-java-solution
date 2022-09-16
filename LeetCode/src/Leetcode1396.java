class UndergroundSystem {
    HashMap<Integer, Event> recordEvent;
    HashMap<String, Average> recordTwoStations;
    private String DELIMETER = ",";
    public UndergroundSystem() {
        recordEvent = new HashMap<>();
        recordTwoStations = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Event checkInEvent = new Event(id, stationName, t);
        recordEvent.put(id, checkInEvent);
    }

    public void checkOut(int id, String stationName, int t) {
        Event checkInEvent = recordEvent.get(id);
        int diff = t - checkInEvent.t;
        String key = checkInEvent.stationName + DELIMETER + stationName;
        Average theAverage = recordTwoStations.getOrDefault(key, new Average());
        theAverage.updateAverage(diff);
        recordTwoStations.put(key, theAverage);
    }

    public double getAverageTime(String startStation, String endStation) {
        return recordTwoStations.get(startStation + DELIMETER + endStation).getAverage();
    }

    class Event{
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
        public void updateAverage(int diff) {
            this.total += diff;
            this.count ++;
        }
        public double getAverage() {
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