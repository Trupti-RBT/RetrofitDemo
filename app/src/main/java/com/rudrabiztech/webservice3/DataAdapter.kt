package com.rudrabiztech.webservice3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.rudrabiztech.webservice3.DataAdapter.*
import com.rudrabiztech.webservice3.model.Main
import kotlinx.android.synthetic.main.item_data_row.view.*

class DataAdapter(private var datalist:List<Main>,private val context: Context): Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_data_row, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datalist=datalist.get(position)

        Log.e("name1","===>"+datalist.getName())
        holder.bindItems(datalist)
    }


    override fun getItemCount(): Int {

            return datalist.size
    }
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){


        fun bindItems(user: Main) {

            val textviewid = itemView.tv_id as TextView
            val textviewname = itemView.tv_name as TextView
            val textviewaddress = itemView.tv_address as TextView
            val textviewemail = itemView.tv_email as TextView
            val textViewCompany = itemView.tv_comapany_name as TextView
            val textviewwebsite = itemView.tv_website as TextView
            val textviewusername = itemView.tv_username as TextView
            val textviewmobile = itemView.tv_phone as TextView

            textviewid.text = user.getId().toString()
            textviewname.text =user.getName()
            textviewusername.text = user.getUsername()
            textviewaddress.text =user.getAddress()!!.city
            textviewemail.text = user.getEmail()
            textViewCompany.text = user.getCompany()!!.getName()
            textviewmobile.text = user.getPhone()
            textviewwebsite.text =user.getWebsite()
        }
    }
}
