package Strategy;

import model.Server;
import model.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {

    @Override
    public void addTask(List<Server> servers, Task t) {
        int minim=servers.get(0).getWaitingPeriod().get();
        for(int i=1;i<servers.size();i++)
        {
            if(minim>servers.get(i).getWaitingPeriod().get())
            {
                minim=servers.get(i).getWaitingPeriod().get();
            }
        }

        for(Server s : servers)
        {
            if(minim == s.getWaitingPeriod().get())
            {
                s.addTask(t);
                break;
            }
        }

    }
}