package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static class Number{
        int number;
        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot)) {
                return true;
            } else{
                return false;
            }


        }
        public boolean isTriangular(){
            int x=1;
            int trinum = 1;
            while(trinum<number){
                x++;
                trinum=trinum+x;
            }
            if(trinum==number){
                return true;
            }
            else{
                return false;
            }
        }

    }
    public void testNumber(View view) {
        Log.i("info", "Button pressed");
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        String message;

        if (editTextNumber.getText().toString().isEmpty()) {

            message = "Please enter a number";

        } else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editTextNumber.getText().toString());
            message = editTextNumber.getText().toString();
            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message += " is square and triangle";
            } else if (myNumber.isSquare()) {
                message += " is square!";
            } else if (myNumber.isTriangular()) {
                message += "is triangular number!";
            } else {
                message += " is neither triangular nor square number!";
            }

        }
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}