package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable
{
    @FXML TextArea txtArea;
    @FXML Button btn_start;

    Robot robot;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try{
            robot = new Robot();
            btn_start = new Button();
            txtArea = new TextArea();
            ServerSocket ss = new ServerSocket(8120);

            btn_start.setOnAction(e->
            {
                Thread t = new Thread(() -> {
                    try{

                        Socket input = ss.accept();

                        while (true)
                        {
                            Scanner scanner = new Scanner(input.getInputStream());
                            String line = scanner.nextLine();
                            System.out.println(line);

                            if (line.equals("w"))
                            {
                                txtArea.appendText(line);
                                robot.keyPress(KeyEvent.VK_W);
                            }
                            if (line.equals("a"))
                            {
                                txtArea.appendText(line);
                                robot.keyPress(KeyEvent.VK_A);
                            }
                            if (line.equals("s"))
                            {
                                txtArea.appendText(line);
                                robot.keyPress(KeyEvent.VK_S);
                            }
                            if (line.equals("d"))
                            {
                                txtArea.appendText(line);
                                robot.keyPress(KeyEvent.VK_D);
                            }

                        }
                    }
                    catch(Exception et)
                    {
                        txtArea.appendText(et.getMessage());
                    }
                });

                t.start();
            });


        }
        catch(Exception e)
        {
            txtArea.appendText(e.getMessage());
        }


    }
}
