package com.example.elise.rozenbergpicalculator;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by Elise on 11/19/2015.
 */
public class PiCalculationAsyncTask extends AsyncTask<Long, String, String> {
    //it is an absract class - implement methods


    private TextView textView;

    public PiCalculationAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Long... params) {
        Double pi = calculate(50000000L);
        return String.valueOf(pi);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        textView.setText(result);
    }

    //better way of doing this and will show next time
    public double calculate(long iter) {
        double pi = 0;
        double num = 4;
        double denom = 1;
        boolean pos = true;

        for (long i = 0; i < iter; i++) {
            if (pos) {
                pi += num / denom;
            } else {
                pi -= num / denom;
            }
            denom += 2;
            pos = !pos;

            publishProgress(String.valueOf(pi));
        }
        return pi;
    }
}
