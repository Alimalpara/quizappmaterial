package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avcpln.quizapp.R;

import java.util.ArrayList;

import Adapters.HomeAdapter;
import models.home_list;

public class Home_fragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView=view.findViewById(R.id.rv_home);
        int noofcols=2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),noofcols));


        ArrayList<home_list> home_lists=new ArrayList<>();

        home_list homeList=new home_list();
        homeList.setName("Dpp 1");

        home_list list2=new home_list();
        list2.setName("Dpp 2");

        home_list list3=new home_list();
        list3.setName("Dpp 3");

        home_list list4=new home_list();
        list4.setName("Dpp 4");

        home_list list5=new home_list();
        list5.setName("Dpp 5");


        home_list list6=new home_list();
        list6.setName("Dpp 6");


        home_list list7=new home_list();
        list7.setName("Dpp 7");

        home_list list8=new home_list();
        list8.setName("Dpp 8");


        home_list list9=new home_list();
        list9.setName("Dpp 9");
        home_list list10=new home_list();
        list10.setName("Dpp 10");



        home_lists.add(homeList);
        home_lists.add(list2);
        home_lists.add(list3);
        home_lists.add(list4);
        home_lists.add(list5);
        home_lists.add(list6);
        home_lists.add(list7);
        home_lists.add(list8);
        home_lists.add(list9);
        home_lists.add(list10);

        HomeAdapter homeAdapter=new HomeAdapter(getActivity(),home_lists);
        recyclerView.setAdapter(homeAdapter);


        return view;
    }
}
