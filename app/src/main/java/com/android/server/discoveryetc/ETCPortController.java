package com.android.server.discoveryetc;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ETCPortController {
    public static final String TAG = "RWJ ETCPortController";
    private ETCSerialPort mETCSerialPort;
    private FileOutputStream mOutputStream;
    private FileInputStream mInputStream;
    private boolean mIsOpen;

    public ETCPortController(Context context) {
        Log.d(TAG,"New instance ETCPortController");
        mETCSerialPort = new ETCSerialPort();
    }

    //open port
    public boolean openPort(String port,int baudRate,int flags){
        Log.d(TAG,"Open port");
        if (mETCSerialPort != null && mIsOpen){
            Log.d(TAG,"Port "+port+" is already open!");
            return false;
        }

        if (mETCSerialPort == null){
            mETCSerialPort = new ETCSerialPort();
            mIsOpen = false;
        }

        File device = new File(port);
        if (device == null){
            return false;
        }

        mIsOpen = mETCSerialPort.openPort(device,baudRate,flags);
        if (mIsOpen){
            mOutputStream = mETCSerialPort.getOutputStream();
            mInputStream = mETCSerialPort.getInputStream();
        }

        startLooper();
        return mIsOpen;
    }

    //close port
    public void closePort(){
        Log.d(TAG,"Close port!");
        if (mETCSerialPort != null){
            mETCSerialPort.close();
            mETCSerialPort = null;
        }
        mIsOpen = false;
    }

    public boolean isOpen() {
        return mIsOpen;
    }

    public void setOpen(boolean open) {
        mIsOpen = open;
    }

    public void startLooper(){
        // TODO: 18-7-3
    }

    public void stopLooper(){
        // TODO: 18-7-3
    }
}
