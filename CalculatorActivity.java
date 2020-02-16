package com.jovanovic.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int OPERATIN_PLUS = 1;     // final znaci da se varijabla ne moze mijenjati
    private static final int OPERATIN_MINUS = 2;    // int je cijeli broj
    private static final int OPERATIN_DIV = 3;
    private static final int OPERATIN_MUL = 4;

    private Button button7, button8, button9, buttonCE, //varijable tipa Button (dugme)
            button4, button5, button6, buttonDiv,       //tu su svi dugmici na ekranu
            button1, button2, button3, buttonMul,
            button0, buttonEq, buttonMinus, buttonPlus,
            buttonPoint;

    private TextView textCalculator, textCalculatorStoreVar; //varijable za prikaz teksta na ekranu

    private double storeVar = 0;

    private int operationType = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textCalculator = (TextView) findViewById(R.id.text_calculator);
        textCalculatorStoreVar = (TextView) findViewById(R.id.text_store_var);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonPlus = (Button) findViewById(R.id.buttonPlu);
        buttonMinus = (Button) findViewById(R.id.buttonMin);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonEq = (Button) findViewById(R.id.buttonEq);

        buttonPoint = (Button) findViewById(R.id.buttonPoint);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonCE.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonEq.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0: {
                if (textCalculator.getText().equals("0")) {

                } else {
                    textCalculator.setText(textCalculator.getText() + "0");
                }
                break;
            }
            case R.id.button1: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("1");
                } else {
                    textCalculator.setText(textCalculator.getText() + "1");
                }
                break;
            }
            case R.id.button2: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("2");
                } else {
                    textCalculator.setText(textCalculator.getText() + "2");
                }
                break;
            }
            case R.id.button3: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("3");
                } else {
                    textCalculator.setText(textCalculator.getText() + "3");
                }
                break;
            }
            case R.id.button4: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("4");
                } else {
                    textCalculator.setText(textCalculator.getText() + "4");
                }
                break;
            }
            case R.id.button5: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("5");
                } else {
                    textCalculator.setText(textCalculator.getText() + "5");
                }
                break;
            }
            case R.id.button6: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("6");
                } else {
                    textCalculator.setText(textCalculator.getText() + "6");
                }
                break;
            }
            case R.id.button7: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("7");
                } else {
                    textCalculator.setText(textCalculator.getText() + "7");
                }
                break;
            }
            case R.id.button8: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("8");
                } else {
                    textCalculator.setText(textCalculator.getText() + "8");
                }
                break;
            }
            case R.id.button9: {
                if (textCalculator.getText().equals("0")) {
                    textCalculator.setText("9");
                } else {
                    textCalculator.setText(textCalculator.getText() + "9");
                }
                break;
            }
            case R.id.buttonPoint: {


                if(!textCalculator.getText().toString().contains(".")) {
                    textCalculator.setText(textCalculator.getText() + ".");
                }

                break;
            }
            case R.id.buttonCE: { //brisanje
                //brise sve sto je do sada uradjeno

                //postavlja varijablu u kojoj se cuva vrijednost na 0
                setStoreVar(0, 0);

                //postavlja operaciju na 0
                operationType = 0;

                //postavlja vrijednost u text polju na "0"
                textCalculator.setText("0");

                break;
            }
            case R.id.buttonDiv: { //dijeljenje
                if (textCalculator.getText().equals("0")) {
                    //ne radi nista, kada se 0 podijeli dobije se nula
                } else {
                    double temp = 0;
                    if(operationType!=0) {
                        temp = solveOperation(operationType, storeVar, Double.parseDouble(textCalculator.getText().toString()));
                    }
                    else {
                        temp = Double.parseDouble(textCalculator.getText().toString());
                    }
                    operationType = OPERATIN_DIV; //snima izabranu operaciju
                    setStoreVar(temp, operationType);
                    textCalculator.setText("0"); //postavlja vrijednost na 0

                }
                break;
            }
            case R.id.buttonMul: {
                if (textCalculator.getText().equals("0")) {
                    //ne radi nista, kada se 0 podijeli dobije se nula
                } else {
                    double temp = 0;
                    if(operationType!=0) {
                        temp = solveOperation(operationType, storeVar, Double.parseDouble(textCalculator.getText().toString()));
                    }
                    else {
                        temp = Double.parseDouble(textCalculator.getText().toString());
                    }
                    operationType = OPERATIN_MUL; //snima izabranu operaciju
                    setStoreVar(temp, operationType);
                    textCalculator.setText("0"); //postavlja vrijednost na 0

                }
                break;
            }
            case R.id.buttonMin: {

                    double temp = 0;
                    if(operationType!=0) {
                        temp = solveOperation(operationType, storeVar, Double.parseDouble(textCalculator.getText().toString()));
                    }
                    else {
                        temp = Double.parseDouble(textCalculator.getText().toString());
                    }
                    operationType = OPERATIN_MINUS; //snima izabranu operaciju
                    setStoreVar(temp, operationType);
                    textCalculator.setText("0"); //postavlja vrijednost na 0


                break;
            }
            case R.id.buttonPlu: {
                if (textCalculator.getText().equals("0")) {
                    //ne radi nista, kada se 0 sabere dobije se drugi broj
                } else {
                    double temp = 0;
                    if(operationType!=0) {
                        temp = solveOperation(operationType, storeVar, Double.parseDouble(textCalculator.getText().toString()));
                    }
                    else {
                        temp = Double.parseDouble(textCalculator.getText().toString());
                    }
                    operationType = OPERATIN_PLUS; //snima izabranu operaciju
                    setStoreVar(temp, operationType);
                    textCalculator.setText("0"); //postavlja vrijednost na 0

                }
                break;
            }
            case R.id.buttonEq: {
                double temp = 0;
                if(operationType!=0) {
                    temp = solveOperation(operationType, storeVar, Double.parseDouble(textCalculator.getText().toString()));
                }
                else {
                    temp = Double.parseDouble(textCalculator.getText().toString());
                }
                operationType = 0; //snima izabranu operaciju
                setStoreVar(0, operationType);
                textCalculator.setText(Double.toString(temp)); //postavlja vrijednost na 0
                break;
            }
        }
    }

    public static double solveOperation(int operationType, double firstValue, double secondValue){
        double result = 0; // double je varijabla koja sadrzi brojeve sa decimalama (npr 0.32 4.456756)
        switch (operationType){
            case OPERATIN_DIV:{
                result = firstValue/secondValue;
                break;
            }
            case OPERATIN_MUL:{
                result = firstValue*secondValue;
                break;
            }
            case OPERATIN_MINUS:{
                result = firstValue-secondValue;
                break;
            }
            case OPERATIN_PLUS:{
                result = firstValue+secondValue;
                break;
            }
        }
        return result;
    }

    public void setStoreVar(double value, int operationType){
        String operationString = "";
        switch (operationType){
            case OPERATIN_DIV:{
                operationString = "/";
                break;
            }
            case OPERATIN_MUL:{
                operationString = "*";
                break;
            }
            case OPERATIN_MINUS:{
                operationString = "-";
                break;
            }
            case OPERATIN_PLUS:{
                operationString = "+";
                break;
            }
        }
        this.textCalculatorStoreVar.setText(Double.toString(value)+operationString);
        this.storeVar = value;
    }

}

