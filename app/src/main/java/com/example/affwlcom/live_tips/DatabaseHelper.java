package com.example.affwlcom.live_tips;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Affwl.com on 2/20/2018.
 */

public class DatabaseHelper {

    String classs = "com.mysql.jdbc.Driver";

    String url = "http://192.168.1.105/registration.php";
    String username = "Livetips";
    String password = "Jiyakiyan@9";

    @SuppressLint("NewApi")
    public Connection CONN() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName(classs);

            conn = DriverManager.getConnection(url, username, password);

            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("Error",se.getMessage());
        }catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }
}


