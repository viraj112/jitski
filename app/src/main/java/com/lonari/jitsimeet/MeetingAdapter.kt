package com.lonari.jitsimeet

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alert_dialog.view.*
import kotlinx.android.synthetic.main.recyler_row.view.*


class MeetingAdapter(val context: Context,val list: List<Model>): RecyclerView.Adapter<MeetingAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mView = LayoutInflater.from(context).inflate(R.layout.recyler_row,parent,false)
        return MyViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val pos = list[position]
        holder.itemView.tv_meetName.text = pos.name
        holder.itemView.tv_meetDetails.text = pos.details
        holder.itemView.tv_meetStatus.text = pos.status

        holder.itemView.cv_meet.setOnClickListener {
            val view = View.inflate(context, R.layout.alert_dialog, null)
            val builder = AlertDialog.Builder(context)
            builder.setView(view)
            val dialog = builder.create()
            dialog.setCanceledOnTouchOutside(false)
            view.tv_title.text = "2022 AGM Meeting"
            view.btn_join.setOnClickListener {
                context.startActivity(Intent(context,MainActivity::class.java))
                dialog.dismiss()
            }

            view.btn_cancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()

        }

    }

    override fun getItemCount(): Int {
   return list.size
    }


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

}