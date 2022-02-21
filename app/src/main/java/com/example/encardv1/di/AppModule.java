package com.example.encardv1.di;

import com.example.encardv1.network.PixabayAPI;
import com.example.encardv1.pixabayviewmodel.PixaBayViewModel;
import com.example.encardv1.repository.PixaBayRepository;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    public static PixaBayRepository privedeRepository(PixabayAPI api){
        return new PixaBayRepository(api);
    }

    @Provides
    public static PixaBayViewModel provideViewModel(PixaBayRepository repository){
        return new PixaBayViewModel(repository);
    }



    @Provides
    public static PixabayAPI providePixabayAPI(OkHttpClient client){

        return new Retrofit.Builder().baseUrl("https://pixabay.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(PixabayAPI.class);
    }

    @Provides
    public static OkHttpClient provideOkHttpClient(Interceptor interceptor){
        return new OkHttpClient.Builder()
                .connectTimeout(30 , TimeUnit.SECONDS)
                .writeTimeout(30 , TimeUnit.SECONDS)
                .readTimeout(30 , TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    public static Interceptor provideLoggingInterceptor(){
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}
