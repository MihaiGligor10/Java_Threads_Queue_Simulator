package model;

import Strategy.Strategy;
import Strategy.SelectPolicy;
import Strategy.ConcreteStrategyQueue;
import Strategy.ConcreteStrategyTime;

import java.security.Policy;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {


private int maxNoServers;
private int maxTasksPerServer;
private Strategy strategy;
private ArrayList<Server> servers=new ArrayList<Server>();

public void changeStrategy(SelectPolicy selectPolicy)
{
    if(selectPolicy == SelectPolicy.SHORTEST_QUEUE)
        strategy = new ConcreteStrategyQueue();
    if(selectPolicy == SelectPolicy.SHORTEST_TIME)
        strategy = new ConcreteStrategyTime();
}

    public Scheduler(int maxNoServers, int maxTasksPerServer) {

        for(int i=0;i<maxNoServers;i++)
        {
            this.servers.add(new Server(i,maxTasksPerServer));
            Thread thread = new Thread(servers.get(i));
            thread.start();
        }

    }
    public boolean emp()
    {
        for(int i =0;i<servers.size();i++)
        {
            if(servers.get(i).getConvert().size()!=0) {
                return false;
            }
        }
        return true;
    }

    public void dispatchTask(Task t)
    {
        strategy.addTask(servers,t);
    }

    public List<Server> getServer()
    {
        return this.servers;
    }

}
