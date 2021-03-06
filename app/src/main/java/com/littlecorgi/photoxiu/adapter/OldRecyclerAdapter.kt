package com.littlecorgi.photoxiu.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.littlecorgi.photoxiu.R
import com.littlecorgi.photoxiu.bean.RecyclerItemBean

class OldRecyclerAdapter(mItemList: List<RecyclerItemBean>, context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mDeception: TextView? = null
        var mName: TextView? = null
        var mCount: TextView? = null
        var mImage: ImageView? = null
        var mCardView: CardView? = null

        init {
            mDeception = itemView.findViewById(R.id.tv_description)
            mName = itemView.findViewById(R.id.tv_user)
            mCount = itemView.findViewById(R.id.tv_love_count)
            mImage = itemView.findViewById(R.id.iv_pic)
            mCardView = itemView.findViewById(R.id.item_card)
        }
    }

    private var mItemList: List<RecyclerItemBean>? = null
    private var context: Context? = null

    init {
        this.mItemList = mItemList
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.app_item_recycler, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val item: RecyclerItemBean = mItemList!![p1]
        val viewHolder = p0 as ViewHolder
        viewHolder.mName!!.text = item.getName()
        viewHolder.mCount!!.text = item.getCount()
        viewHolder.mDeception!!.text = item.getDeception()
        if (p1 % 2 == 0) {
            viewHolder.mCardView!!.setBackgroundColor(Color.argb(30, 240, 229, 222))
        } else {
            viewHolder.mCardView!!.setBackgroundColor(Color.argb(30, 171, 208, 206))
        }
        val i = (Math.random() * 2).toInt()
        if (i % 2 == 0) {
            Glide.with(context!!).load("https://img-bbs.csdn.net/upload/201404/30/1398845303_229280.png")
                    .fitCenter()
                    .into(viewHolder.mImage!!)
        } else {
            Glide.with(context!!).load(R.drawable.app_pic2).fitCenter().into(viewHolder.mImage!!)
        }
    }

    override fun getItemCount(): Int {
        return mItemList!!.size
    }
}