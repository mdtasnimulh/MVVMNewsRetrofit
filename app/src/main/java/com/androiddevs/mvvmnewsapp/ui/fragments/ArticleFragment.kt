package com.androiddevs.mvvmnewsapp.ui.fragments

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.NewsApplication
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.androiddevs.mvvmnewsapp.ui.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment: Fragment(R.layout.fragment_article) {

    private lateinit var viewModel: NewsViewModel
    //private val args: ArticleFragmentArgs by navArgs()
    //private val passArgs: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsRepository = NewsRepository(ArticleDatabase(requireContext()))
        val viewModelProviderFactory = NewsViewModelProviderFactory(requireActivity().application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        /*val article = args.url
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article?:"")
        }*/
        val article = arguments?.getParcelable<Article>("article")
        Log.d("article", "${article?.url}")
        //val url = article.url.toString()
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article?.url!!)
        }
        //tvArticles.text = article.description

        //val passData = passArgs.article
        fab.setOnClickListener {
            viewModel.saveArticle(article!!)
            //Snackbar.make(view, "Saved", Snackbar.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Added to Favourite", Toast.LENGTH_SHORT).show()

        }
    }
}