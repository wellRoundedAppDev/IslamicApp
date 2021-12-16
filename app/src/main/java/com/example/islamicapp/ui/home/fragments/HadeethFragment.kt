package com.example.islamicapp.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R
import com.example.islamicapp.ui.Constants
import com.example.islamicapp.ui.hadeethDetails.HadeethDetailsActivity
import com.example.islamicapp.ui.home.fragments.adapters.HadeethNamesAdapter

class HadeethFragment : Fragment() {

    val hadeethNamesList = mutableListOf<String>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadeethNamesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView =
            requireView().findViewById(R.id.hadeeth_fragment_recycler_view)// Or requireView().findViewById(R.id.quran_fragment_recycler_view),
        //requireView() returns the View returned by onCreateView()
        createHadeethNamesList()
        adapter = HadeethNamesAdapter(hadeethNamesList)
        adapter.onItemCLickListener = object : HadeethNamesAdapter.OnItemClickListener {

            override fun onItemClick(position: Int, item: String) {

                showHadeethDetails(item, position)
            }
        }

        recyclerView.adapter = adapter
    }

    private fun createHadeethNamesList() {

        for (i in 1..50) {

            hadeethNamesList.add("الحديث رقم " + "${i}")
        }
    }

    fun showHadeethDetails(name: String, pos: Int) {

        val intent = Intent(requireActivity(), HadeethDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_HADEETH_NAME, name)
        intent.putExtra(Constants.EXTRA_HADEETH_POSITION, pos)
        startActivity(intent)
    }
}