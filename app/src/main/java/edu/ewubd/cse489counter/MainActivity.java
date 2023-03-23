package edu.ewubd.cse489counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int time = 600;

    private TextView text;
    private int n;
    private Handler h;

    private String y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);

        n=2019160014;


        h = new Handler();


        Button btnStart = findViewById(R.id.start);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                start_task();




            }
        });

        Button btnReset = findViewById(R.id.reset);
        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                onDestroy();
                n = 2019160014;
                String y = String.valueOf(n);
                text.setText(y);

            }
        });

        Button btnPause = findViewById(R.id.pause);
        btnPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                onPause();





            }
        });
        Button btnExit = findViewById(R.id.exit);
        btnExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                finish();





            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stop_task();
    }
    @Override
    public void onPause() {


        super.onPause();
        stop_task();




    }


    Runnable current_state = new Runnable() {
        @Override
        public void run() {
            try {


                y = String.valueOf(n);
                text.setText(y);
                n--;

            } finally {

                h.postDelayed(current_state, time);
            }

        }

    };

    void start_task() {

        current_state.run();

    }

    void stop_task() {


        h.removeCallbacks(current_state);
    }
}