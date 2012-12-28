package ru.birgacoda.BudKa;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity {

    Button Start, Stop;
    TextView counter;
    private Handler handler = new Handler();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        counter = (TextView)findViewById(R.id.counter);
        Start = (Button)findViewById(R.id.Start);
        Start.setEnabled(true);
        Stop = (Button)findViewById(R.id.Stop);
        Stop.setEnabled(false);

        Start.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                handler.post(timedTask);
                Start.setEnabled(false);
                Stop.setEnabled(true);
            }});

        Stop.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                handler.removeCallbacks(timedTask);
                Start.setEnabled(true);
                Stop.setEnabled(false);
            }});
    }

    private Runnable timedTask = new Runnable(){

        @Override
        public void run() {
            // TODO Auto-generated method stub

            SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
            df.setLenient(false);
            Calendar cal = Calendar.getInstance();
            String s = df.format(cal.getTime());
            counter.setText(s);
            handler.postDelayed(timedTask, 1000);
        }};
}