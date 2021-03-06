package com.blandinf.kotlinproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blandinf.kotlinproject.R
import com.blandinf.kotlinproject.models.Category
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule

@GlideModule
class CategoryAdapter(
    private val dataset: List<Category>,
    private val callback: (category: String) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Category) {
            val image = root.findViewById<ImageView>(R.id.category_image)
            val name = root.findViewById<TextView>(R.id.category_name)
            val description = root.findViewById<TextView>(R.id.category_description)
            Glide.with(root.context)
                .load(item.url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)
            name.text = item.name
            description.text = item.description

            root.setOnClickListener {
                callback(item.query)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_category_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dataset[position])

    override fun getItemCount(): Int = dataset.size
}