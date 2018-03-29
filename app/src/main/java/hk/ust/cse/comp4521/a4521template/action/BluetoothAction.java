package hk.ust.cse.comp4521.a4521template.action;

import android.bluetooth.BluetoothAdapter;

/**
 * Created by TM on 27-Mar-18.
 */

public class BluetoothAction extends Action {
    @Override
    public void turnOn() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
        }
    }

    @Override
    public void turnOff() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.disable();
        }
    }
}
