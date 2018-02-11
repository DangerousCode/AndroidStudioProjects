package com.ye.alvaro.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    String display, numberBuffer, currentOperator;
    boolean isFirstOperator, filledAcumResult; //filledAcumResult es una variable que indica si se ha realizado una operación completa (que se han introducido datos y clicado en igual). No se que nombre ponerle.
    double acumResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);
        initVariables();
    }

    public void numberInput(View view) {

        Button button = (Button) view;
        String number = button.getText().toString();
        numberBuffer += number;
        display += number;
        updateScreen();

    }

    public void operatorInput(View view) {

        //Si se ha escrito un número, se prodrá introducir un operador
        if (!numberBuffer.isEmpty()) {
            Button button = (Button) view;


            if (isFirstOperator) {
                isFirstOperator = false;

                //Se evalua que no se haya realizado una operación completa anteriormente, ya que se sobreescribiria el valor de la variable
                if(!filledAcumResult) {
                    acumResult = Double.valueOf(numberBuffer);
                }

            } else {
                operate();
            }

            currentOperator = button.getText().toString();

            display += currentOperator;
            numberBuffer = "";
            updateScreen();
        }

    }

    private void operate() {

        switch (currentOperator) {

            case "+":

                acumResult += Double.valueOf(numberBuffer);
                break;

            case "-":

                acumResult -= Double.valueOf(numberBuffer);
                break;

            case "*":

                acumResult *= Double.valueOf(numberBuffer);
                break;

            case "/":

                acumResult /= Double.valueOf(numberBuffer);
                break;


        }

    }

    public void clearInput(View view) {

        initVariables();

    }

    public void equalInput(View view) {

        if(!numberBuffer.isEmpty()) {

            if(currentOperator.isEmpty()){
                screen.setText(numberBuffer);

            } else {
                operate();
                display = String.valueOf(acumResult);
                isFirstOperator = true;
                filledAcumResult = true;
                updateScreen();
            }
        }
    }

    public void updateScreen() {
        screen.setText(display);
    }

    private void initVariables() {

        display = "";
        numberBuffer = "";
        currentOperator = "";
        acumResult = 0;
        isFirstOperator = true;
        filledAcumResult = false;
        screen.setText(display);

    }
}
