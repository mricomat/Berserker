package com.martnrico.berserker.data.network;

import com.martnrico.berserker.data.network.form.LoginForm;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.LoginModel;
import com.martnrico.berserker.data.network.model.Entry.PagedModel;
import com.martnrico.berserker.data.network.model.RegisterModel;
import com.martnrico.berserker.data.network.model.UserModel;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public interface ServiceHelper {

    @POST("/api/auth/signin")
    Single<LoginModel> loginAuthentication(@Body LoginForm loginForm);

    @POST("/api/auth/signup")
    Single<RegisterModel> registerNewUser(@Body UserModel userModel);

    @GET("/api/entries/pager")
    Single<PagedModel<EntryModel>> getPagedEntries(@Query("page") Integer page,
                                                   @Query("size") Integer size);

}
