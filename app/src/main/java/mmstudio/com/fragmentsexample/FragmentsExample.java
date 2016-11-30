package mmstudio.com.fragmentsexample;

import android.app.Application;

import com.google.gson.Gson;

import mmstudio.com.fragmentsexample.register.RemoteService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by milanerski on 28.11.16..
 */

public class FragmentsExample extends Application{

    RemoteService remoteService;



    @Override
    public void onCreate() {
        super.onCreate();
//Retrofit
        //retrofit.BUilder je specijalan objekat koji ne poziva klasican konstruktor, nego posebnu build metodu.
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").
                addConverterFactory(GsonConverterFactory.create(new Gson())).build();  //osnovna putanja do naseg servera!


        retrofit.create(RemoteService.class);


        remoteService = retrofit.create(RemoteService.class);
    }


        public RemoteService getRemoteService() {
        return remoteService;
    }

}