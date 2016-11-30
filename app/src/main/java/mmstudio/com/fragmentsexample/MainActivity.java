package mmstudio.com.fragmentsexample;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.mSpinner);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        List<String> nase_zemlje = new ArrayList<>();
        nase_zemlje.add("Srbija");
        nase_zemlje.add("Makedonija");
        nase_zemlje.add("Bugarska");
        nase_zemlje.add("Srbija");


        MySpinnerAdapter adapter = new MySpinnerAdapter();

        spinner.setAdapter(adapter);
        adapter.addItems(nase_zemlje);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        final MyRecyclerAdapter adapter1 = new MyRecyclerAdapter();
        mRecyclerView.setAdapter(adapter1);



        FragmentsExample fragmentsExample = (FragmentsExample) getApplication();

        Call<List<Project>> call = fragmentsExample.getRemoteService().getRepos("f0restgumo92");

        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                adapter1.addItems(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }
        });

    }
}
