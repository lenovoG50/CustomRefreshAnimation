package com.lihui.customrefreshanimation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements PullToRefreshBase.OnRefreshListener2 {

    private PullToRefreshListView refreshListView;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            refreshListView.onRefreshComplete();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshListView = (PullToRefreshListView) findViewById(R.id.refresh);
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);

    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        try {
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            if (connection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                String s = stringBuffer.toString();
            }

            handler.sendEmptyMessageDelayed(0, 3000);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

    }
}
