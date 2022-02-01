package com.rahulprojects.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    TextView operationTextView,resultTextView;
    Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,multiply,divide,modulus,decimal,clear,equalTo;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operationTextView=findViewById(R.id.operationTextView);
        resultTextView=findViewById(R.id.resultTextView);

        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);

        plus=findViewById(R.id.plusButton);
        minus=findViewById(R.id.minusButton);
        multiply=findViewById(R.id.multiplyButton);
        divide=findViewById(R.id.divideButton);
        modulus=findViewById(R.id.modulusButton);
        decimal=findViewById(R.id.decimalButton);
        clear=findViewById(R.id.clearButton);
        equalTo=findViewById(R.id.equalToButton);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=operationTextView.getText().toString();
                operationTextView.setText(data +"0");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operationTextView.getText().toString();
                operationTextView.setText(data + "+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operationTextView.getText().toString();
                operationTextView.setText(data + "-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operationTextView.getText().toString();
                operationTextView.setText(data + "×");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operationTextView.getText().toString();
                operationTextView.setText(data + "÷");
            }
        });

        modulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operationTextView.getText().toString();
                operationTextView.setText(data + "%");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operationTextView.getText().toString();
                operationTextView.setText(data + ".");
            }
        });


        equalTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operationTextView.getText().toString();

                data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();

                resultTextView.setText(finalResult);
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationTextView.setText(" ");
                resultTextView.setText(" ");
                data="";
            }
        });

    }
}