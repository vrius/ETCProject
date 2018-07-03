package android.discoveryetc;

import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class ETCManager {
    public static final String TAG = "RWJ ETCManager";
    private IETCService mService;

    public ETCManager(Context context) {
        mService = IETCService.Stub.asInterface(ServiceManager.getService("etc_service"));
    }

    public void startLooper() throws RemoteException {
        mService.startLooper();
    }

    public void stopLooper() throws RemoteException {
        mService.stopLooper();
    }

    public void etcSendCmd(long id, int tag, String hexCmd) {
        try {
            mService.etcSendCmd(id, tag, hexCmd);
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d(TAG, "ETC SEND CMD EXCEPTION! MSG=" + e.getMessage());
        }
    }


}
