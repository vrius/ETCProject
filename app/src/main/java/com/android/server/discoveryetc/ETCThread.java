package com.android.server.discoveryetc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ETCThread extends Thread {
    private boolean running;
    private InputStream mIs;
    private byte[] buffer = new byte[1024];

    public ETCThread(InputStream is) {
        this.running = true;
        this.mIs = is;
    }

    @Override
    public void run() {
        while (running) {
            if (mIs == null) return;

            try {
                int len = mIs.read(buffer);
                if (len > 0){

                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        }
    }
}
