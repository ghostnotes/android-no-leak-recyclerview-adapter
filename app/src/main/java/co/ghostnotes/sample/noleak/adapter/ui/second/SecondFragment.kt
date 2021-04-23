package co.ghostnotes.sample.noleak.adapter.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import co.ghostnotes.sample.noleak.adapter.R
import co.ghostnotes.sample.noleak.adapter.databinding.FragmentSecondBinding

class SecondFragment : Fragment(){

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_second,
            container,
            false
        )
        return binding.root
    }

}