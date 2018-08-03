package com.example.affwlcom.live_tips.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.affwlcom.live_tips.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewTerminalFragment extends Fragment {

//    public WebView mWebView;

    public static ViewTerminalFragment newInstance(){

        ViewTerminalFragment viewterminalFragment = new ViewTerminalFragment();

        return viewterminalFragment ;

    }

    public ViewTerminalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_view_terminal, container, false);

        WebView mWebView = (WebView) v.findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://www.viewterminal.in/");


        // Inflate the layout for this fragment
        return v;
    }

}
