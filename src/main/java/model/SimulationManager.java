package model;

import Strategy.SelectPolicy;
import view.VSimulare;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SimulationManager implements Runnable{


    public VSimulare sim = new VSimulare();

    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int maxArrivalTime;
    public int minArrivalTime;
    public int numberOfServers;
    public int numberOfClients;
    public int maxTperS=500;
    public Scheduler scheduler;
    public SelectPolicy selectionPolicy = SelectPolicy.SHORTEST_TIME;
    public File outFile=new File("log.txt");
    FileWriter fw = new FileWriter(outFile);
    PrintWriter pw = new PrintWriter(fw);

    public ArrayList<Task> cl;



    public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int maxArrivalTime, int minArrivalTime, int numberOfServers, int numberOfClients) throws IOException {
        this.timeLimit = timeLimit;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.maxArrivalTime = maxArrivalTime;
        this.minArrivalTime = minArrivalTime;
        this.numberOfServers = numberOfServers;
        this.numberOfClients = numberOfClients;
        this.scheduler =new Scheduler(numberOfServers,maxTperS);
        this.scheduler.changeStrategy(selectionPolicy);
        cl=generateNRandomTasks();
    }


    public int randomArrivingTime() {
        return (minArrivalTime + (int) (Math.random() * (maxArrivalTime  - minArrivalTime )));
    }
    public int randomProcessingTime() {
        return (minProcessingTime + (int) (Math.random() * (maxProcessingTime - minProcessingTime)));
    }

    private ArrayList<Task> generateNRandomTasks() {
        ArrayList<Task> t=new ArrayList<>();

        for (int i=0; i<numberOfClients; i++)
        {
            Task ta= new Task (i,randomArrivingTime(), randomProcessingTime() );
           System.out.println("add element");
            t.add(ta);
            System.out.println(t.get(i));
        }
        return t;
    }


    String simul = "";
    int currentTime = 1;

    @Override
    public void run() {
        while(currentTime < timeLimit && (cl.size()!=0 || scheduler.emp()==false ) ) {
            sim.setText(simul += "\n"+ "time: "+ currentTime +"\n");pw.println("\n"+"time: "+ currentTime );
            for(int i=0;i<cl.size();i++) {
                if(cl.get(i).gettArrival()==currentTime) {
                    scheduler.dispatchTask(cl.get(i));
                    cl.remove(i);
                    i--;
                } }
            String s = "Waiting clients : ";
            for(int i=0;i<cl.size();i++) {
                s += " ( "+cl.get(i).getId()+ " , " + cl.get(i).gettArrival() + " , " + cl.get(i).gettService() + " ) ";
            }
            sim.setText(simul += s+"\n");pw.println( s);
            String a ;
            for(int i=0;i< scheduler.getServer().size();i++) {
                a="Server " + i + ":" ;
                for(int j=0;j< scheduler.getServer().get(i).getConvert().size();j++) {
                    a += " ( " + scheduler.getServer().get(i).getConvert().get(j).getId() + " , " + scheduler.getServer().get(i).getConvert().get(j).gettArrival() +" , " + scheduler.getServer().get(i).getConvert().get(j).gettService() + " ) ";
                }
                sim.setText(simul += a+"\n");pw.println( a);
            }
            currentTime++;
            try{
                Thread.sleep(1000);
            }catch(Exception ex) {}
        }
        String a ;
        for(int i=0;i< scheduler.getServer().size();i++) {
            a="Server " + i + ":" ;
            for(int j=0;j< scheduler.getServer().get(i).getConvert().size();j++) {
                a += " ( " + scheduler.getServer().get(i).getConvert().get(j).getId() + " , " + scheduler.getServer().get(i).getConvert().get(j).gettArrival() +" , " + scheduler.getServer().get(i).getConvert().get(j).gettService() + " ) ";
            }
            sim.setText(simul+="\n");sim.setText(simul += a+"\n");pw.println("\n");pw.println( a);} sim.setText(simul += "\nEnd of the simulation");pw.println("\nEnd of the simulation");pw.close();
    }
}
