package model;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{

    public BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private int id;
    private boolean running=true;
    private int completedTasks=0;
    private int tServerOpen=0;


    public Server(int id,int maxT)
    {
        this.id = id;
        this.tasks = new ArrayBlockingQueue<Task>(maxT);
        this.waitingPeriod=new AtomicInteger();
    }

    public void addTask(Task task)
    {
        tasks.add(task);
        waitingPeriod.addAndGet(task.gettService());
    }

    public double AVGTime()
    {
        return tServerOpen/completedTasks;
    }

    @Override
    public void run() {
        while(true)
        {
            while(tasks.peek()!=null)
            {
                int time=tasks.peek().gettService();
                try {
                    Thread.sleep(time*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitingPeriod.addAndGet(-time);
                    tasks.poll();
            }
            setRunning(false);
        }

    }



public ArrayList<Task> getConvert()
{
    ArrayList<Task> e = new ArrayList<>();
    e.addAll(tasks);
    return e;
}

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
