package com.example.camp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.camp.databinding.FragmentBookListBinding
import com.example.camp.domain.exception.EmptyBookLIstException
import com.example.camp.domain.model.Book
import com.example.camp.presentation.adapter.BookClickListener
import com.example.camp.presentation.adapter.BookListAdapter
import com.example.camp.presentation.viewmodel.BookListViewModel
import com.example.camp.util.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment : Fragment(), BookClickListener {

    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    private val bookViewModel: BookListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookListData()
        configureListener()
        addObserver()
    }

    private fun configureListener() {
        binding.editSearch.textChangedList = { input ->
            bookViewModel.search(input)
        }
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter
        bookViewModel.search()
    }

    private fun addObserver() {
        bookViewModel.bookListViewState.observe(viewLifecycleOwner) { state ->
            when(state) {
                is ViewState.Success -> {
                    showEmptyListError(false)
                    bookListAdapter.submitList(
                        state.data
                    )
                }
                is ViewState.Error -> {
                    when(state.throwable) {
                        is EmptyBookLIstException -> {
                            bookListAdapter.submitList(listOf())
                            showEmptyListError(true)
                        }
                        else -> Unit
                    }
                }
                else -> Unit
            }
        }
    }

    private fun showEmptyListError(hasError: Boolean) {
        binding.textViewEmptyList.visibility = if(hasError) View.VISIBLE else View.GONE
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}