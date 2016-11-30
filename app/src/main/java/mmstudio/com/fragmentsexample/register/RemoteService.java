package mmstudio.com.fragmentsexample.register;

import java.util.List;

import mmstudio.com.fragmentsexample.Project;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by milanerski on 289898.11.16..
 */

public interface RemoteService {        //U ovoj kalsi ce biti svi nasi n-pointi, sa modelom kako izgleda zahtev!!!

    @GET("users/{user}/repos")
        //mesto user treba da se ubaci nesto..
    Call<List<Project>> getRepos(@Path("user") String username);          //<Void>  to je tip rezultata koji treba da nam vrati API
    //getRepos()    -   ime nase metode koju zelimo da uzmemo


}
