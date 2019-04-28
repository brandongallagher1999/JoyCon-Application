package com.cryptocon.cryptocon;

import java.io.PrintWriter;
import java.net.Socket;

public class OutputHandler
{
    PrintWriter writer;


    public void create()
    {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    Socket socket = new Socket("10.10.120.217",8120);
                    writer = new PrintWriter(socket.getOutputStream());
                    System.out.println("created created created created created created ");

                }
                catch(Exception e)
                {
                    System.out.println("ERROR ERROR ERROR");
                    e.printStackTrace();
                }
            }
        });

        t.start();
    }

    public void write(String key)
    {
        writer.println(key);
    }



}
