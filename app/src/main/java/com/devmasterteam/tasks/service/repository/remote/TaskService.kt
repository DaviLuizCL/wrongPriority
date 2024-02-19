package com.devmasterteam.tasks.service.repository.remote

import com.devmasterteam.tasks.service.model.TaskModel
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TaskService {
    @GET("Task")
    fun list(): Call<List<TaskModel>>

    @GET("Next7Days")
    fun listNext(): Call<List<TaskModel>>

    @GET("Overdue")
    fun listOverDo(): Call<List<TaskModel>>

    @GET("Task/{id}")
    fun load(@Path(value = "id", encoded = true) id: Int): Call<TaskModel>

    @POST("Task")
    @FormUrlEncoded
    fun create(
        @Field("Priority") priorityId: Int,

        @Field("Description") description: String,

        @Field("DueDate") dueDate: String,

        @Field("Complete") complete: Boolean


    ): Call<Boolean>


    @PUT("Task")
    @FormUrlEncoded
    fun update(
        @Field("Priority") id: Int,

        @Field("Priority") priorityId: Int,

        @Field("Description") description: String,

        @Field("DueDate") dueDate: String,

        @Field("Complete") complete: Boolean


    ): Call<Boolean>

    @PUT("Task/Complete")
    @FormUrlEncoded
    fun complete(@Field("id") id: Int): Call<Boolean>

    @PUT("Task/Undo")
    @FormUrlEncoded
    fun undo(@Field("id") id: Int): Call<Boolean>









    @DELETE("Task")
    @FormUrlEncoded
    fun delete(@Field("id") id: Int): Call<Boolean>


}