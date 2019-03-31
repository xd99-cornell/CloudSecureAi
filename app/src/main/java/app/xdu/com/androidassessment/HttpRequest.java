package app.xdu.com.androidassessment;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import app.xdu.com.androidassessment.UI.CommonPresenter;

public class HttpRequest extends AsyncTask<String, Void, String> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    RecyclerView.Adapter adapter;
    CommonPresenter presenter;

    public HttpRequest(RecyclerView.Adapter adapter, CommonPresenter presenter) {
        this.adapter = adapter;
        this.presenter = presenter;
    }

    @Override
    protected String doInBackground(String... params) {
        String stringUrl = params[0];
        String result;
        String inputLine;
        try {
            URL myUrl = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection)
                    myUrl.openConnection();
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {

                Log.e("xdu", "Unable to connect the server!");
                return "";
            }

            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            reader.close();
            streamReader.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            result = null;
        }

        presenter.updateView(result);

        return result;
    }



    protected void onPostExecute(String result) {
        adapter.notifyDataSetChanged();
        super.onPostExecute(result);
    }


}

