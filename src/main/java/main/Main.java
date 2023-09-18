package main;

import controllers.VController;
import view.View;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        View frame = new View();
        VController controll = new VController(frame);

        frame.setVisible(true);
        controll.toString();
    }
}
