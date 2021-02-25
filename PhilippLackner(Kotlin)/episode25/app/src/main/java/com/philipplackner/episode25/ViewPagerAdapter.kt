package com.philipplackner.episode25

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(
    val imgs:List<Int>
): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){
    inner class ViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imgs.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImg=imgs[position]
        holder.itemView.ivImage.setImageResource(curImg)
    }
}