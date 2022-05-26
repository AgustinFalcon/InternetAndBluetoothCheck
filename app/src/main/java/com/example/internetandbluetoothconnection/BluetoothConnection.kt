package com.example.internetandbluetoothconnection

import android.bluetooth.BluetoothAdapter
import android.text.BoringLayout
import androidx.lifecycle.LiveData

class BluetoothConnection: LiveData<Boolean>() {

    private fun isBluetoothEnabled() {
        val myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (myBluetoothAdapter.isEnabled) {
            postValue(myBluetoothAdapter.isEnabled)
        } else {
            postValue(myBluetoothAdapter.isEnabled)
        }
    }
}