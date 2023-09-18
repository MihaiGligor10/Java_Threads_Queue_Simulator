package model;

public class Task {

private int id;
private int tArrival;
private int tService;

    public Task(int id, int tArrival, int tService) {
        this.id = id;
        this.tArrival = tArrival;
        this.tService = tService;
    }

    public int getId() {
        return id;
    }

    public int gettArrival() {
        return tArrival;
    }

    public int gettService() {
        return tService;
    }

    @Override
    public String toString() {
        return "(" +
                " " + id +
                ",  " + tArrival +
                ",  " + tService +
                ") ";
    }
}
