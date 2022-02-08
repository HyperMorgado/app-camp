package com.example.camp.presentation.ui.fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.camp.R
import com.example.camp.databinding.BookDetailsBottomSheetBinding
import com.example.camp.domain.model.Book
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BookDetailsBottomSheetBinding? = null
    private val binding: BookDetailsBottomSheetBinding get() = _binding!!

    private var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = BookDetailsBottomSheetBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setListener()
        setupBottomSheetHeight()
    }

    private fun setupBottomSheetHeight() {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setListener() {
        binding.buttonClose.setOnClickListener {
            dismiss()
        }
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    private fun setupView() {
       binding.apply {
            textViewBookName.text = book?.name
            textViewAuthors.text = book?.author
            textViewLabelPages.text = book?.pages
            textViewLabelEditor.text = book?.editor
            textViewLabelDatePublication.text = book?.date
            textViewLabelLanguage.text = book?.language
            textViewLabelOriginalTitle.text = book?.originName
            textViewLabelIsbn10.text = book?.isbn10
            textViewLabelIsbn13.text = book?.isbn13
            imageBigBook.load(book?.imageUrl) {
                error(R.drawable.image_book)
            }

            val spannableString = SpannableString("   ${book?.review}")
            val imageSpan = ImageSpan(requireContext(), R.drawable.ic_quotes)
            spannableString.setSpan(imageSpan, 0, 1, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
            textReview.text = spannableString
       }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance(book: Book? = null): BookDetailsBottomSheet {
            return BookDetailsBottomSheet().apply {
                this.book = book
            }
        }
    }
}