package com.example.affwlcom.live_tips.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.affwlcom.live_tips.Adapter.RecyclerViewAdapter;
import com.example.affwlcom.live_tips.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LongTermFragment extends Fragment {

    private RecyclerView rv;
    private static String[] StockName= {"HDFC","ICICI","MRF","TATA","TCS"};

    public static LongTermFragment newInstance(){

        LongTermFragment longtermFragment = new LongTermFragment();

        return longtermFragment ;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_long_term,null);

        //REFERENCE
        rv = rootView.findViewById(R.id.rv_longterm);

        //LAYOUT MANAGER

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));


        //ADAPTER
        rv.setAdapter(new RecyclerViewAdapter(getActivity(),StockName));


        return rootView;
    }

    @Override
    public String toString() {
        return "Long Term";
    }
    // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_intraday, container, false);
}
