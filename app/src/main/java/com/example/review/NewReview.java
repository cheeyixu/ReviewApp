package com.example.review;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class NewReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_review);



        /******Seek bar Category updater code ******/
        Spinner categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateCategories();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /****** SeekBar TextView value updater code ******/

        //Get's the seek bars
        SeekBar seekBarOne = (SeekBar) findViewById(R.id.categoryOneSeekBar);
        SeekBar seekBarTwo = (SeekBar) findViewById(R.id.categoryTwoSeekBar);
        SeekBar seekBarThree = (SeekBar) findViewById(R.id.categoryThreeSeekBar);


        //Inner class to implement the listener to update the seek bar when it is moved
        class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateScoreText();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                updateScoreText();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateScoreText();
            }
        }
        //Creates the listener for the seekbar
        SeekBarListener listener = new SeekBarListener();

        //Attaches the listener to the Seek bar
        seekBarOne.setOnSeekBarChangeListener(listener);
        seekBarTwo.setOnSeekBarChangeListener(listener);
        seekBarThree.setOnSeekBarChangeListener(listener);
    }

    //Returns the user created title for the review
    public String getReviewTitle(){
        EditText title = (EditText) findViewById(R.id.editTitleText);
        String titleString = title.getText().toString();
        return titleString;
    }

    //Returns the user choosen category
    public String getCategory(){
        Spinner category = (Spinner) findViewById(R.id.categorySpinner);
        String titleString = category.getSelectedItem().toString();
        return titleString;
    }

    //Updates the textViews with the value of the seek bars; triggered by the seek bar listener
    public void updateScoreText(){
        //Gets the text views and seekbars
        TextView scoreOne = (TextView) findViewById(R.id.SeekBarOneAmountTextView);
        TextView scoreTwo = (TextView) findViewById(R.id.SeekBarTwoAmountTextView);
        TextView scoreThree = (TextView) findViewById(R.id.SeekBarThreeAmountTextView);

        SeekBar seekBarOne = (SeekBar) findViewById(R.id.categoryOneSeekBar);
        SeekBar seekBarTwo = (SeekBar) findViewById(R.id.categoryTwoSeekBar);
        SeekBar seekBarThree = (SeekBar) findViewById(R.id.categoryThreeSeekBar);

        //Updates text view strings
        if (scoreOne != null) {
            if (seekBarOne != null) {
                scoreOne.setText(String.valueOf(seekBarOne.getProgress()/10.0));
            }
        }
        if (scoreTwo != null) {
            if (seekBarTwo != null) {
                scoreTwo.setText(String.valueOf(seekBarTwo.getProgress()/10.0));
            }
        }
        if (scoreThree != null) {
            if (seekBarThree != null) {
                scoreThree.setText(String.valueOf(seekBarThree.getProgress()/10.0));
            }
        }

    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.new_review_toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.publish_button:
                //Add review into database
                return true;
            case R.id.cancel_button:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //TODO currently doesn't update from the database
    //Updates seekbar rating categories based on the database
    public void updateCategories(){
        //Gets the TextViews
        TextView categoryOne = (TextView) findViewById(R.id.categoryOneTextView);
        TextView categoryTwo = (TextView) findViewById(R.id.categoryTwoTextView);
        TextView categoryThree = (TextView) findViewById(R.id.categoryThreeTextView);

        //TODO must be replaced with category specific attributes; probably from a database
        categoryOne.setText("Bird");
        categoryTwo.setText("Fish");
        categoryThree.setText("Snake");
    }

    public String getReviewText(){
        EditText reviewContent = (EditText) findViewById(R.id.reviewEditText);
        String reviewContentString = reviewContent.getText().toString();
        return reviewContentString;
    }

    public int getReviewScoreOne(){
        SeekBar seekBar = (SeekBar) findViewById(R.id.categoryOneSeekBar);
        int seekBarScore = seekBar.getProgress();
        return seekBarScore;
    }

    public int getReviewScoreTwo(){
        SeekBar seekBar = (SeekBar) findViewById(R.id.categoryTwoSeekBar);
        int seekBarScore = seekBar.getProgress();
        return seekBarScore;
    }

    public int getReviewScoreThree(){
        SeekBar seekBar = (SeekBar) findViewById(R.id.categoryThreeSeekBar);
        int seekBarScore = seekBar.getProgress();
        return seekBarScore;
    }

}
