package controllers;

import model.SimulationManager;
import view.VSimulare;
import view.View;

import java.io.IOException;

public class VController {
    private View view;
    private SimulationManager simulationManager;

    public VController(View view) {
        this.view = view;

        this.view.getButton().addActionListener(e -> {


            try {
                simulationManager =new SimulationManager(Integer.parseInt(view.getInt()) ,Integer.parseInt(view.getMaxSer()),Integer.parseInt(view.getMinSer()),Integer.parseInt(view.getMaxArr()),Integer.parseInt(view.getMinArr()),Integer.parseInt(view.getQueues()),Integer.parseInt(view.getClients()));
                Thread thread = new Thread(simulationManager);
                thread.start();
                simulationManager.sim.setVisible(true);

            }
            catch (NumberFormatException | IOException numberFormatException) {

            }
        });
    }
}
