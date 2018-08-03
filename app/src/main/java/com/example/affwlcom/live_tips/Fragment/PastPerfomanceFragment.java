package com.example.affwlcom.live_tips.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.affwlcom.live_tips.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastPerfomanceFragment extends Fragment {

    public static PastPerfomanceFragment newInstance(){

        PastPerfomanceFragment pastperfomanceFragment = new PastPerfomanceFragment();

        return pastperfomanceFragment ;

    }


//    public PastPerfomanceFragment() {
//        // Required empty public constructor
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past_perfomance, container, false);
    }

}
