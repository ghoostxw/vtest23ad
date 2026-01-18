package com.example.v2rayadguard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.v2rayadguard.R
import com.example.v2rayadguard.vm.MainViewModel
import kotlinx.android.synthetic.main.fragment_quick_toggle.*

class QuickToggleFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quick_toggle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        toggleButton.setOnClickListener {
            if (viewModel.isVpnActive()) {
                viewModel.stopVpn()
                toggleButton.text = getString(R.string.start_vpn)
            } else {
                viewModel.startVpn()
                toggleButton.text = getString(R.string.stop_vpn)
            }
        }

        adBlockToggle.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setAdBlockEnabled(isChecked)
        }

        // Observe ViewModel for updates
        viewModel.vpnStatus.observe(viewLifecycleOwner) { isActive ->
            toggleButton.text = if (isActive) getString(R.string.stop_vpn) else getString(R.string.start_vpn)
        }

        viewModel.adBlockStatus.observe(viewLifecycleOwner) { isEnabled ->
            adBlockToggle.isChecked = isEnabled
        }
    }
}