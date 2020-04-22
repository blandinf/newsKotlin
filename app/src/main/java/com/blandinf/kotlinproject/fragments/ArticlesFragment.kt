package com.blandinf.kotlinproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blandinf.kotlinproject.R
import com.blandinf.kotlinproject.adapters.ArticleAdapter
import com.blandinf.kotlinproject.models.Article
import com.blandinf.kotlinproject.repositories.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArticlesFragment: Fragment() {
    lateinit var recyclerView: RecyclerView
    private val repository = ArticleRepository()

    companion object{
        lateinit var categoryChoice: String

        fun newInstance(category: String): ArticlesFragment{
            categoryChoice = category
            return ArticlesFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        lifecycleScope.launch {
            getData()
        }
    }

    //S'execute dans un thread secondaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.getArticles(categoryChoice)
            bindData(result)
        }
    }
    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {
            val adapterRecycler = ArticleAdapter(result)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapterRecycler
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.article_fragment, container, false)
    }
}