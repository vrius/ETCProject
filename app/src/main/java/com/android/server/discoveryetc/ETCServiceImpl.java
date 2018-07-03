package com.android.server.discoveryetc;

import android.content.Context;
import android.discoveryetc.IETCService;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

public class ETCServiceImpl extends IETCService.Stub {
    public static final String TAG = "RWJ ETCServiceImpl";
    private int mPortStatus = -1;
    private ETCPortController mController;
    private Context mContext;

    public ETCServiceImpl(Context context) {
        Log.d(TAG,"New instance ETCServiceImpl");
        this.mContext = context;
        this.mController = new ETCPortController(context);
    }

    @Override
    public void startLooper() {
        if (mController.isOpen()){
            mController.startLooper();
        }
    }

    @Override
    public void stopLooper() {

    }

    @Override
    public void etcSendCmd(long id, int tag, String hexCmd) {

    }

    @Override
    public boolean etcOpenPort(String port, int baudRate, int flags) {
        if (TextUtils.isEmpty(port)){
            Log.d(TAG,"Port is empty");
            return false;
        }
        return mController.openPort(port,baudRate,flags);
    }

    @Override
    public void etcClosePort() {
        mController.closePort();
    }

    public int getPortStatus(){
        return mPortStatus;
    }

}
