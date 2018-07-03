// IETCService.aidl
package android.discoveryetc;

// Declare any non-default types here with import statements

interface IETCService {
    //启动数据读取轮循器
    void startLooper();

    //关闭数据读取轮循器
    void stopLooper();

    //发送指令
    void etcSendCmd(long id,int tag,String hexCmd);

    //打开串口
    boolean etcOpenPort(String port,int baudRate,int flags);

    //关闭串口
    void etcClosePort();
}
