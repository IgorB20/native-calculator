package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private Button buttonZero;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonPlus;
    private Button buttonSub;
    private Button buttonEquals;
    private Button buttonMulti;
    private Button buttonDivide;
    private Button buttonClear;
    private Button buttonClearAll;
    private Button buttonRightParentheses;
    private Button buttonLeftParentheses;
    private Button buttonComa;
    private TextView operations;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonZero = findViewById(R.id.zero);
        buttonOne = findViewById(R.id.one);
        buttonTwo = findViewById(R.id.two);
        buttonThree = findViewById(R.id.three);
        buttonFour = findViewById(R.id.four);
        buttonFive = findViewById(R.id.five);
        buttonSix = findViewById(R.id.six);
        buttonSeven = findViewById(R.id.seven);
        buttonEight = findViewById(R.id.eight);
        buttonNine = findViewById(R.id.nine);

        this.handleButtonClick(buttonZero, "0");
        this.handleButtonClick(buttonOne, "1");
        this.handleButtonClick(buttonTwo, "2");
        this.handleButtonClick(buttonThree, "3");
        this.handleButtonClick(buttonFour, "4");
        this.handleButtonClick(buttonFive, "5");
        this.handleButtonClick(buttonSix, "6");
        this.handleButtonClick(buttonSeven, "7");
        this.handleButtonClick(buttonEight, "8");
        this.handleButtonClick(buttonNine, "9");

        operations = findViewById(R.id.operacoes);
        results = findViewById(R.id.resultados);

        buttonPlus = findViewById(R.id.plus);
        buttonSub = findViewById(R.id.sub);
        buttonMulti = findViewById(R.id.multi);
        buttonDivide = findViewById(R.id.divide);

        buttonEquals = findViewById(R.id.equals);
        buttonClear = findViewById(R.id.erase);
        buttonClearAll = findViewById(R.id.clear_all);
        buttonRightParentheses = findViewById(R.id.right_parentheses);
        buttonLeftParentheses = findViewById(R.id.left_parentheses);
        buttonComa = findViewById(R.id.coma);

        this.handleButtonClick(buttonPlus, "+");
        this.handleButtonClick(buttonSub, "-");
        this.handleButtonClick(buttonMulti, "*");
        this.handleButtonClick(buttonDivide, "/");
        this.handleButtonClick(buttonComa, ".");
        this.handleButtonClick(buttonLeftParentheses, "(");
        this.handleButtonClick(buttonRightParentheses, ")");

        buttonEquals.setOnClickListener(view -> {
            Expression e = new ExpressionBuilder((String) operations.getText()).build();
            double result = e.evaluate();
            results.setText(Double.toString(result));
        });

        buttonClear.setOnClickListener(view -> {
            results.setText(" ");
            if(operations.getText().length() == 1 ){
                operations.setText("");
            }else{
                operations.setText(operations.getText().subSequence(0, operations.getText().length()-1));
            }

        });

        buttonClearAll.setOnClickListener(view -> {
            results.setText(" ");
            operations.setText("");
        });
    }

    private void handleButtonClick(Button button, String text){
        button.setOnClickListener(view -> {
            operations.setText(operations.getText() + text);
        });
    }
}