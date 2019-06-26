package com.rudrabiztech.webservice3

import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rudrabiztech.webservice3.model.Main
import kotlinx.android.synthetic.main.activity_webservice.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Webservice : AppCompatActivity() {
    val user=ArrayList<Main>()
    lateinit var rv: RecyclerView
    lateinit var adapter: DataAdapter

//    val adapter = DataAdapter(user,this@Webservice)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webservice)

       rv =findViewById<View>(R.id.rv_first) as RecyclerView

        rv.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)


        getData()


    }

    private fun getData() {

        val call: Call<List<Main>> = ApiClient.getClient.getmain().also {

            it.enqueue(object : Callback<List<Main>> {

                override fun onResponse(call: Call<List<Main>>?, response: Response<List<Main>>?) {

                    if(response!=null) {

                        user.addAll(response.body()!!)
                        rv.adapter = DataAdapter(user,this@Webservice)
                        rv.adapter?.notifyDataSetChanged()

                        for (index in response.body()!!.indices) {
                            Log.e("Id",""+ response.body()!!.get(index).getId())
                            Log.e("Name",""+ response.body()!!.get(index).getName())
                            Log.e("UserName",""+ response.body()!!.get(index).getUsername())
                            Log.e("Email",""+ response.body()!!.get(index).getEmail())
                            Log.e("Street",""+ response.body()!!.get(index).getAddress()?.street)
                            Log.e("City",""+ response.body()!!.get(index).getAddress()?.city)
                            Log.e("Suite",""+ response.body()!!.get(index).getAddress()?.suite)
                            Log.e("ZipCode",""+ response.body()!!.get(index).getAddress()?.zipcode)
                            Log.e("Lat",""+ response.body()!!.get(index).getAddress()?.geo?.lat)
                            Log.e("Lng",""+ response.body()!!.get(index).getAddress()?.geo?.lng)
                            Log.e("CompanyName",""+ response.body()!!.get(index).getCompany()?.getName())
                            Log.e("CompanyCatchPhrases",""+ response.body()!!.get(index).getCompany()?.getCatchPhrase())
                            Log.e("CompanyBS",""+ response.body()!!.get(index).getCompany()?.getBs())
                            Log.e("Phone",""+ response.body()!!.get(index).getPhone())
                            Log.e("Website",""+ response.body()!!.get(index).getWebsite())

                        }


                    }


                }

                override fun onFailure(call: Call<List<Main>>?, t: Throwable?) {

                }

            })
        }
    }
}
