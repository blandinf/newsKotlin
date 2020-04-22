package com.blandinf.kotlinproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blandinf.kotlinproject.R
import com.blandinf.kotlinproject.models.Article

class ArticleAdapter(private val dataset: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val source = root.findViewById<TextView>(R.id.source_name)
            val title = root.findViewById<TextView>(R.id.title)
            val description = root.findViewById<TextView>(R.id.description)

            source.text = item.source.name
            title.text = item.title
            description.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dataset[position])

    override fun getItemCount(): Int = dataset.size
}