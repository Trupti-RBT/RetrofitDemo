package com.rudrabiztech.webservice3

import android.location.Address
import com.rudrabiztech.webservice3.model.Company
import com.rudrabiztech.webservice3.model.Geo
import com.rudrabiztech.webservice3.model.Main
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getmain(): Call<List<Main>>

}