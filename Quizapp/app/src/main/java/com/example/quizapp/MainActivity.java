package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    Button option1Btn, option2Btn, option3Btn, option4Btn;
    ArrayList<Quiz> quizArrayList;
    Random random;
    int currentscore = 0, questionAttempted = 1, currentpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizArrayList);
        currentpos = random.nextInt(quizArrayList.size());
        setDataToViews(currentpos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionAttempted++;
                currentpos = random.nextInt(quizArrayList.size());
                setDataToViews(currentpos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionAttempted++;
                currentpos = random.nextInt(quizArrayList.size());
                setDataToViews(currentpos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionAttempted++;
                currentpos = random.nextInt(quizArrayList.size());
                setDataToViews(currentpos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionAttempted++;
                currentpos = random.nextInt(quizArrayList.size());
                setDataToViews(currentpos);
            }
        });
    }
    private void showBottomsheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomsheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomsheet, (LinearLayout) findViewById(R.id.idllscore));
        TextView scoreTV = bottomsheetView.findViewById(R.id.idTVScore);
        Button BRestartQuizBtn = bottomsheetView.findViewById(R.id.idBRestart);
        scoreTV.setText("Your score is \n" + currentscore + "/10");
        BRestartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentpos = random.nextInt(quizArrayList.size());
                setDataToViews(currentpos);

                questionAttempted = 1;
                currentpos = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomsheetView);
        bottomSheetDialog.show();
    }
    private void setDataToViews(int currentpos) {
        questionNumberTV.setText("Question Attempted :"+questionAttempted + "/10");
        if (questionAttempted ==10) {
            showBottomsheet();
        } else {
            questionTV.setText(quizArrayList.get(currentpos).getQuestion());
            option1Btn.setText(quizArrayList.get(currentpos).getOption1());
            option2Btn.setText(quizArrayList.get(currentpos).getOption2());
            option3Btn.setText(quizArrayList.get(currentpos).getOption3());
            option4Btn.setText(quizArrayList.get(currentpos).getOption4());
        }
    }
    private void getQuizQuestion(ArrayList<Quiz> quizArrayList) {
        quizArrayList.add(new Quiz("How GfG is used ?", "To solve DSA problem", "To learn new languages", "To learn Android", "All of the above", ""));
        quizArrayList.add(new Quiz("What is GCM in Android ?", "Google cloud messaging", "Google Message Pack", "Google Cloud Manager", "All of the above", ""));
        quizArrayList.add(new Quiz("What is ADB in Android ?", "Android Debug Bridge", "Android Data Bridge", "Android database bridge", "All of the above", ""));
        quizArrayList.add(new Quiz("Where are colors present in Android ?", "Color.xml", "Android data Bridge", "String.xml", "All of the above", ""));
    }
}




















