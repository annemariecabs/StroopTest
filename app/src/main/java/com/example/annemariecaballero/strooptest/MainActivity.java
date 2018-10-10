package com.example.annemariecaballero.strooptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons;
    private TextView textView;
    private int[] colors;
    private String[] colorNames;

    int currentTxtColor;
    int currentColorName;
    private int wins;
    private int plays;

    private TextView winsView;
    private TextView playsView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialSetUp();
    }

    /*
    Initializes fields
     */
    public void initialSetUp() {
        buttons = new Button[]{(Button) findViewById(R.id.redBtn), (Button) findViewById(R.id.blueBtn),
                (Button) findViewById(R.id.greenBtn), (Button) findViewById(R.id.yellowBtn),
                (Button) findViewById(R.id.pinkBtn), (Button) findViewById(R.id.purpleBtn),
                (Button) findViewById(R.id.brownBtn), (Button) findViewById(R.id.orangeBtn)
        };

        colors = new int[8];
        for(int i = 0; i < colors.length; i++) {
            ColorDrawable drawable = (ColorDrawable) buttons[i].getBackground();
            colors[i] = drawable.getColor();
        }

        colorNames = new String[]{"Red", "Blue", "Green", "Yellow", "Pink", "Purple", "Brown", "Orange"};

        textView = findViewById(R.id.textView);

        wins = 0;
        plays = 0;

        winsView = findViewById(R.id.wins);
        playsView = findViewById(R.id.trys);

        winsView.setText("Wins: " + wins);
        playsView.setText("Trys: " + plays);

        setTextView();
    }

    public void onButtonClick(View view) {
        Button chosenBtn = (Button) view;
        CharSequence chosenColor = chosenBtn.getText();

        plays++;

        if(chosenColor.toString().equals(colorNames[currentColorName]))
            wins++;

        winsView.setText("Wins: " + wins);
        playsView.setText("Trys: " + plays);

        setTextView();

    }

    public void setTextView() {
        int randTxtColor = (int) (Math.random() * 8); //this will be used for the color of the text
        int randTxt = (int) (Math.random() * 8); //this will be used for the text value

        currentTxtColor = randTxtColor;
        currentColorName = randTxt;

        textView.setText(colorNames[randTxt]);
        textView.setTextColor(colors[randTxtColor]);
    }

}
