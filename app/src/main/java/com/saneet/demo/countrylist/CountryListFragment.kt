package com.saneet.demo.countrylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saneet.demo.DemoApplication
import com.saneet.demo.R
import com.saneet.demo.ViewModelFactory
import javax.inject.Inject

class CountryListFragment : Fragment() {

    companion object {
        fun newInstance() = CountryListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<CountryListViewModel>

    private val viewModel: CountryListViewModel by lazy {
        viewModelFactory.get<CountryListViewModel>(
            requireActivity()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as DemoApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val list = requireView().findViewById<RecyclerView>(R.id.list)
        list.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        list.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )
        viewModel.countryList.observe(viewLifecycleOwner) { countries ->
            list.adapter = CountryListAdapter().apply { submitList(countries) }
        }
        viewModel.fetchCountries()
    }
}