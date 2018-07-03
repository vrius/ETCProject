/*
 * Copyright 2009 Cedric Priscal
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package com.android.server.discoveryetc;

import android.util.Log;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ETCSerialPort {
	private static final String TAG = "RWJ SerialPort";

	/*
	 * Do not remove or rename the field mFd: it is used by native method close();
	 */
	private FileDescriptor mFd;
	private FileInputStream mFileInputStream;
	private FileOutputStream mFileOutputStream;

    public ETCSerialPort() {
    }

    public ETCSerialPort(File device, int baudrate, int flags) throws SecurityException {
		//Runtime.getRuntime().exec(new String[]{"/system/bin/ctl_hw","-c","cpu"});

		/* Check access permission */
	    /*if (!device.canRead() || !device.canWrite()) {
			try {
				// Missing read/write permission, trying to chmod the file 
				Process su;
				su = Runtime.getRuntime().exec("/system/bin/su");
				String cmd = "chmod 666 " + device.getAbsolutePath() + "\n" + "exit\n";
				su.getOutputStream().write(cmd.getBytes());
				if ((su.waitFor() != 0) || !device.canRead()
						|| !device.canWrite()) {
					throw new SecurityException();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SecurityException();
			}
		}*/

		mFd = open(device.getAbsolutePath(), baudrate, flags);
		Log.d(TAG, "open port mFd=" + mFd);
		if (mFd == null) {
            Log.d(TAG, "native open returns null");
			return;
		}
		mFileInputStream = new FileInputStream(mFd);
		mFileOutputStream = new FileOutputStream(mFd);
	}

	public boolean openPort(File device, int baudrate, int flags){
        mFd = open(device.getAbsolutePath(), baudrate, flags);
        Log.d(TAG, "open port mFd=" + mFd);
        if (mFd == null) {
            Log.d(TAG, "native open returns null");
            return false;
        }
        mFileInputStream = new FileInputStream(mFd);
        mFileOutputStream = new FileOutputStream(mFd);
        return true;
    }


	public FileInputStream getInputStream() {
        if (mFileInputStream == null) {
            Log.d(TAG, "mFileInputStream is null");
        }
		return mFileInputStream;
	}

	public FileOutputStream getOutputStream() {
        if (mFileOutputStream == null) {
            Log.d(TAG, "mFileOutputStream is null");
        }
		return mFileOutputStream;
	}

	// JNI
	private native static FileDescriptor open(String path, int baudrate, int flags);
	public native void close();
	static {
		System.loadLibrary("obdserial_port");
	}
}
