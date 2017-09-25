package com.aurugames.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView input, output;
    ImageButton rock, paper, scissors;
    int[] images = new int[]{
            R.mipmap.rock_350_200,
            R.mipmap.paper_350_200,
            R.mipmap.scissors_350_200
    };
    int userinput = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (ImageView) findViewById(R.id.iv_input);
        output = (ImageView) findViewById(R.id.iv_output);
        rock = (ImageButton) findViewById(R.id.btn_rock);
        paper = (ImageButton) findViewById(R.id.btn_paper);
        scissors = (ImageButton) findViewById(R.id.btn_scissors);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
 //           infoTextView.setText("Вы выбрали котёнка!");
   //         return true;
     //   }

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_settings:
                showSettings();
                return true;
            case R.id.action_about:
                showAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_rock:
                userinput = 1;
                //input.setBackgroundResource(R.mipmap.rock_350_200);
                input.setImageResource(R.mipmap.rock_350_200);
                setOutput();
                break;
            case R.id.btn_paper:
                userinput = 2;
//                input.setBackgroundResource(R.mipmap.paper_350_200);
                  input.setImageResource(R.mipmap.paper_350_200);
                setOutput();
                break;
            case R.id.btn_scissors:
                userinput = 3;
//                input.setBackgroundResource(R.mipmap.scissors_350_200);
                input.setImageResource(R.mipmap.scissors_350_200);
                setOutput();
                break;
        }
    }

    private void setOutput() {
        int imageId = (int) (Math.random() * images.length);
      //  output.setBackgroundResource(images[imageId]);
        output.setImageResource(images[imageId]);
        checkresult(imageId);
    }

    private void checkresult(int imageId) {
        if (userinput == 1 && imageId == 0) {     //User choose Rock,Computer choose Rock
            showresult(2);
        } else if (userinput == 1 && imageId == 1) { //User choose Rock,Computer choose Paper
            showresult(0);
        } else if (userinput == 1 && imageId == 2) { //User choose Rock,Computer choose Scissors
            showresult(1);
        } else if (userinput == 2 && imageId == 0) { //User choose Paper,Computer choose Rock
            showresult(1);
        } else if (userinput == 2 && imageId == 1) { //User choose Paper,Computer choose Paper
            showresult(2);
        } else if (userinput == 2 && imageId == 2) { //User choose Paper,Computer choose Scissors
            showresult(0);
        } else if (userinput == 3 && imageId == 0) {//User choose Scissors,Computer choose Rock
            showresult(0);
        } else if (userinput == 3 && imageId == 1) { //User choose Scissors,Computer choose Paper
            showresult(1);
        } else if (userinput == 3 && imageId == 2) { //User choose Scissors,Computer choose Scissors
            showresult(2);
        }
    }

    private void showresult(int result) {
        if (result == 0) {
            Toast.makeText(getApplicationContext(), R.string.showresult_lost, Toast.LENGTH_SHORT).show();
            input.setBackgroundResource(R.drawable.red_border);
            output.setBackgroundResource(R.drawable.green_border);
        } else if (result == 1)
        {
            Toast.makeText(getApplicationContext(), R.string.showresult_won, Toast.LENGTH_SHORT).show();
            input.setBackgroundResource(R.drawable.green_border);
            output.setBackgroundResource(R.drawable.red_border);
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.showresult_draw, Toast.LENGTH_SHORT).show();
            input.setBackgroundResource(R.drawable.gold_border);
            output.setBackgroundResource(R.drawable.gold_border);
        }
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_about, popup.getMenu());
        popup.show();
    }

    public void showAbout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.menu_about_title)
                .setMessage(R.string.link_icon)
                .setIcon(R.drawable.ic_overflow_holo_dark)
                .setCancelable(false)
                .setNegativeButton(R.string.menu_about_button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showSettings() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.menu_about_title)
                .setMessage(R.string.menu_about_message)
                .setIcon(R.drawable.ic_overflow_holo_dark)
                .setCancelable(false)
                .setNegativeButton(R.string.menu_about_button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
