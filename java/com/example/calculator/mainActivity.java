package com.example.calculator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class mainActivity extends AppCompatActivity {

    private EditText editText;
    private String input = "";
    private double valueOne = Double.NaN;
    private double valueTwo;
    private char currentAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.input_field);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonPlusMinus = findViewById(R.id.buttonPlusMinus);
        Button buttonSqrt = findViewById(R.id.buttonSqrt);
        Button buttonSquare = findViewById(R.id.buttonSquare);
        Button buttonInverse = findViewById(R.id.buttonReciprocal);
        Button buttonPercentage = findViewById(R.id.buttonPercent);
        button0.setOnClickListener(v -> appendToInput("0"));
        button1.setOnClickListener(v -> appendToInput("1"));
        button2.setOnClickListener(v -> appendToInput("2"));
        button3.setOnClickListener(v -> appendToInput("3"));
        button4.setOnClickListener(v -> appendToInput("4"));
        button5.setOnClickListener(v -> appendToInput("5"));
        button6.setOnClickListener(v -> appendToInput("6"));
        button7.setOnClickListener(v -> appendToInput("7"));
        button8.setOnClickListener(v -> appendToInput("8"));
        button9.setOnClickListener(v -> appendToInput("9"));
        buttonDot.setOnClickListener(v -> appendToInput("."));
        Button buttonCE = findViewById(R.id.buttonCE);
        Button buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonAdd.setOnClickListener(v -> performOperation('+'));
        buttonSubtract.setOnClickListener(v -> performOperation('-'));
        buttonMultiply.setOnClickListener(v -> performOperation('*'));
        buttonDivide.setOnClickListener(v -> performOperation('/'));

        buttonEquals.setOnClickListener(v -> {
            computeCalculation();
            editText.setText(String.valueOf(valueOne));
            valueOne = Double.NaN;
            currentAction = '0';
            input = "";
        });
        buttonCE.setOnClickListener(v -> {
            editText.setText("");
            input = "";
        });

        buttonBackspace.setOnClickListener(v -> {
            if (input.length() > 0) {
                input = input.substring(0, input.length() - 1);
                editText.setText(input);
            }
        });

        buttonC.setOnClickListener(v -> {
            valueOne = Double.NaN;
            valueTwo = Double.NaN;
            editText.setText("");
            input = "";
        });



        buttonPlusMinus.setOnClickListener(v -> {
            if (!input.isEmpty()) {
                double value = Double.parseDouble(input);
                value = value * -1;
                input = String.valueOf(value);
                editText.setText(input);
            }
        });

        buttonSqrt.setOnClickListener(v -> {
            if (!input.isEmpty()) {
                double value = Double.parseDouble(input);
                value = Math.sqrt(value);
                input = String.valueOf(value);
                editText.setText(input);
            }
        });
        buttonSquare.setOnClickListener(v -> {
            if (!input.isEmpty()) {
                double value = Double.parseDouble(input);
                value = value * value;
                input = String.valueOf(value);
                editText.setText(input);
            }
        });
        buttonInverse.setOnClickListener(v -> {
            if (!input.isEmpty()) {
                double value = Double.parseDouble(input);
                if (value != 0) {
                    value = 1 / value;
                    input = String.valueOf(value);
                    editText.setText(input);
                } else {
                    editText.setText("Error");
                }
            }
        });

        buttonPercentage.setOnClickListener(v -> {
            if (!input.isEmpty()) {
                double value = Double.parseDouble(input);
                value = value / 100;
                input = String.valueOf(value);
                editText.setText(input);
            }
        });
    }


    private void appendToInput(String str) {
        input += str;
        editText.setText(input);
    }

    private void performOperation(char action) {
        if (!Double.isNaN(valueOne)) {
            computeCalculation();
        } else {
            try {
                valueOne = Double.parseDouble(input);
            } catch (Exception e) {}
        }
        currentAction = action;
        input = "";
    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(input);
            if (!Double.isNaN(valueTwo)) {
                switch (currentAction) {
                    case '+':
                        valueOne = valueOne + valueTwo;
                        break;
                    case '-':
                        valueOne = valueOne - valueTwo;
                        break;
                    case '*':
                        valueOne = valueOne * valueTwo;
                        break;
                    case '/':
                        valueOne = valueOne / valueTwo;
                        break;
                }
            }
        }
    }
}
