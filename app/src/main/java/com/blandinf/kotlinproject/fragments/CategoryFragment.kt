package com.blandinf.kotlinproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blandinf.kotlinproject.R
import com.blandinf.kotlinproject.adapters.CategoryAdapter
import com.blandinf.kotlinproject.models.Category
import com.blandinf.kotlinproject.switchToFragment

class CategoryFragment : Fragment() {
    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewCategory)
        bindRecyclerView()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.category_fragment, container, false)
    }

    private fun bindRecyclerView() {
        val categories = listOf(
            Category("Politique", "Description1", "politics", "https://www.betapolitique.fr/wp-content/uploads/2019/05/definition-politique.jpg"),
            Category("Economie", "Description2", "economy", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRXZASaR5caIA8AKLAT5BaOS0KTDOs_DbbT-wFHD-ALpkN1errY&usqp=CAU"),
            Category("Education", "Description3", "education", "https://www.zdnet.fr/i/edit/ne/2018/12/Education.jpg"),
            Category("Pandémie", "Description4", "pandemic", "https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/8/d/9/8d93e801a9_50155231_pandemie-mondiale-millions-personnes-2.jpg"),
            Category("Sciences", "Description5", "sciences", "https://cdn.futura-sciences.com/buildsv6/images/wide1920/a/0/2/a0269d7a2e_50155960_science-20e-siecle-artinspiring-fotolia.jpg"),
            Category("Ecologie", "Description6", "ecology", "https://cdn.futura-sciences.com/buildsv6/images/wide1920/f/b/f/fbf1ffdbee_50145424_ecologie-science.jpg")
        )
        val adapterRecycler = CategoryAdapter(categories) {
            activity?.switchToFragment(ArticlesFragment.newInstance(it))
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapterRecycler
    }
}