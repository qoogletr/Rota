package com.rota.barcodequarreader.data.remote.api

import com.rota.barcodequarreader.data.remote.model.BarcodeRequest
import com.rota.barcodequarreader.data.remote.model.BarcodeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {
    @POST
    suspend fun sendBarcode(
        @Url url: String,
        @Body request: BarcodeRequest
    ): Response<BarcodeResponse>
}