package co.ghostnotes.sample.noleak.adapter.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.ghostnotes.sample.noleak.adapter.R
import co.ghostnotes.sample.noleak.adapter.model.User
import co.ghostnotes.sample.noleak.adapter.databinding.FragmentMainBinding
import co.ghostnotes.sample.noleak.adapter.databinding.ListItemUserBinding
import co.ghostnotes.sample.noleak.adapter.extension.setAdapterNoLeak
import co.ghostnotes.sample.noleak.adapter.ui.main.MainFragment.NoLeakAdapter.NoLeakViewHolder
import timber.log.Timber

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null
    private lateinit var noLeakAdapter: NoLeakAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(requireView())
        initializeLayout(binding!!)
    }

    private fun initializeLayout(binding: FragmentMainBinding) {
        noLeakAdapter = NoLeakAdapter(createUsers())
        binding.recyclerView.apply {
            setAdapterNoLeak(noLeakAdapter)
        }

        binding.button.setOnClickListener {
            Timber.d("### button: go to SecondFragment.")
            view?.findNavController()?.navigate(R.id.action_mainFragment_to_secondFragment)
        }
    }

    override fun onDestroyView() {
        Timber.d("### onDestroyView()")
        // TODO
        binding = null

        super.onDestroyView()
    }

    private fun createUsers(): Array<User> {
        return listOf(
            User(1, country = "Japan", age = 18, name =  "Aaa Bbb"),
            User(2, country = "Australia", age = 18, name = "Ccc Ddd"),
            User(3, country = "Brazil", age = 18, name = "Aaa Fff"),
            User(4, country = "UK", age = 18, name = "Aaa Eee"),
            User(5, country = "US", age = 18, name = "Aaa Ggg"),
            User(6, country = "Poland", age = 18, name = "Aaa Hhh"),
            User(7, country = "Germany", age = 18, name = "Aaa Iii"),
            User(8, country = "Italy", age = 98, name = "Aaa Jjj"),
            User(9, country = "France", age = 8, name = "Aaa Kkk"),
            User(10, country = "Spain", age = 12, name = "Aaa Lll"),
            User(11, country = "Japan", age = 24, name = "Aaa Mmm"),
            User(12, country = "Japan", age = 33, name = "Aaa Nnn"),
        ).toTypedArray()
    }

    private class NoLeakAdapter(private val users: Array<User>) : RecyclerView.Adapter<NoLeakViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): NoLeakViewHolder {
            val binding: ListItemUserBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_user,
                parent,
                false
            )
            return NoLeakViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NoLeakViewHolder, position: Int) {
            holder.bind(users[position])
        }

        override fun getItemCount(): Int {
            return users.size
        }

        private class NoLeakViewHolder(private val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(user: User) {
                binding.user = user
            }
        }
    }
}