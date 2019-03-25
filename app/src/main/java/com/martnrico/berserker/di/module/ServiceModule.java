package com.martnrico.berserker.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.martnrico.berserker.BuildConfig;
import com.martnrico.berserker.data.AppDataManager;
import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.data.network.ServiceHelper;
import com.martnrico.berserker.data.network.TokenInterceptor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Martín Rico Martínez on 21/01/2019.
 */
@Module
public class ServiceModule {

    @Provides
    @Named("base_url")
    static String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttp(TokenInterceptor tokenInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(tokenInterceptor)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(OkHttpClient client, @Named("base_url") String baseUrl) {
        return new Retrofit.Builder()
                .callFactory(client)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Provides
    @Singleton
    static ServiceHelper provideServiceHelper(Retrofit retrofit) {
        return retrofit.create(ServiceHelper.class);
    }

    @Provides
    @Named("network_scheduler")
    static Scheduler provideNetworkScheduler() {
        return Schedulers.io();
    }
}
