package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.model.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NowPlaying#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NowPlaying extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    Retrofit movieApis;

    public NowPlaying() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NowPlaying.
     */
    // TODO: Rename and change types and number of parameters
    public static NowPlaying newInstance(String param1, String param2) {
        NowPlaying fragment = new NowPlaying();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getFilm();
        View view= inflater.inflate(R.layout.fragment_now_playing, container, false);
        recyclerView= view.findViewById(R.id.nowRV);


        return view;
    }

    private void getFilm() {

        restAdapter.getMovies().getMovie(getResources().getString(R.string.api_key)).enqueue(new Callback<Retrofit>() {
            @Override
            public void onResponse(Call<Retrofit> call, Response<Retrofit> response) {
                movieApis=  response.body();
                setRecyclerView();

            }

            @Override
            public void onFailure(Call<Retrofit> call, Throwable t) {

            }
        });
    }
    private void setRecyclerView () {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        MovieAdapter movieAdapter = new MovieAdapter( getContext(), movieApis.getResults());
        recyclerView.setAdapter(movieAdapter);
    }
}