@file:Suppress("DEPRECATION")

package com.example.internetandbluetoothconnection


import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.internetandbluetoothconnection.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        val networkConnection = NetworkConnection(requireContext())
        networkConnection.observe(viewLifecycleOwner, {
            if (it) {
                binding.imageInternet.setImageResource(R.drawable.ic_internet_on)
            } else {
                binding.imageInternet.setImageResource(R.drawable.ic_internet_off)
            }
        })

        if (!isBluetoothEnabled()) {
            binding.imageBluetooth.setImageResource(R.drawable.ic_bluetooth_off)
        } else {
            binding.imageBluetooth.setImageResource(R.drawable.ic_bluetooth_on)
        }


        return binding.root
    }

    private fun isBluetoothEnabled(): Boolean {
        val myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        return myBluetoothAdapter.isEnabled
    }





    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
