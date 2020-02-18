package com.example.recyleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyleview.data.User
import com.example.recyleview.databinding.RowBinding
import kotlinx.android.synthetic.main.row.view.*

class MyUserRecyclerViewAdapter(
    private val mValues: List<User>,
    private val mListener: onListInteraction
    ):RecyclerView.Adapter<MyUserRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyUserRecyclerViewAdapter.ViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent,false)
        var binder: RowBinding
        binder = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.row,parent,false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: MyUserRecyclerViewAdapter.ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mView.user = item
        holder.mView.executePendingBindings()
    }

    public fun updateData(){
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: RowBinding): RecyclerView.ViewHolder(mView.root){
        val textView : TextView = mView.textViewUserName
    }

    interface onListInteraction{
        fun onListItemInteraction(item: User?)
        fun onListButtonInteraction(item: User?)
    }
}