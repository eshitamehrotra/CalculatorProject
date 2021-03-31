package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button bAdd;
    Button bMinus;
    Button bDivide;
    Button bMulti;
    Button bC;
    Button bEq;
    Button b0;
    TextView t;
    int counter=0;
    double tot;
    String s;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        bAdd = findViewById(R.id.buttonA);
        bMinus = findViewById(R.id.buttonMI);
        bDivide = findViewById(R.id.buttonD);
        bMulti = findViewById(R.id.buttonM);
        bC = findViewById(R.id.buttonC);
        bEq = findViewById(R.id.buttonE);
        b0 = findViewById(R.id.button0);
        t = findViewById(R.id.textView9);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bAdd.setOnClickListener(this);
        bMinus.setOnClickListener(this);
        bDivide.setOnClickListener(this);
        bMulti.setOnClickListener(this);
        bC.setOnClickListener(this);
        bEq.setOnClickListener(this);
        b0.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {


           if(b1.isPressed()){
               t.setText(t.getText() + "1");
           }

            if(b2.isPressed()){
                t.setText(t.getText() + "2");
            }

            if(b3.isPressed()){
                t.setText(t.getText() + "3");
            }

            if(b4.isPressed()){
                t.setText(t.getText() + "4");
            }

            if(b5.isPressed()){
                t.setText(t.getText() + "5");
            }

            if(b6.isPressed()){
                t.setText(t.getText() + "6");
            }

            if(b7.isPressed()){
                t.setText(t.getText() + "7");
            }

            if(b8.isPressed()){
                t.setText(t.getText() + "8");
            }

            if(b9.isPressed()){
                t.setText(t.getText() + "9");
            }

            if(bAdd.isPressed()){
                t.setText(t.getText() + "+");
            }

            if(bMinus.isPressed()){
                t.setText(t.getText() + "-");
            }

            if(bDivide.isPressed()){
                t.setText(t.getText() + "/");
            }

            if(bMulti.isPressed()){
                t.setText(t.getText() + "*");
            }

            if(b0.isPressed()){
                t.setText(t.getText() + "0");
            }
            if(bC.isPressed()){
                t.setText("");
            }
            s = t.getText().toString();


            if(bEq.isPressed()){

                if(s.length()==0){
                    t.setText("");
                }

               try {

                   counter = 0;
                   Double x;
                   Double y;
                   Double z;
                   Double p;
                   int co =0;


                   StringTokenizer tk = new StringTokenizer(s, "/ * + -", true);
                   String [] signs = new String [tk.countTokens()];
                    while(tk.hasMoreTokens()){
                        String current = tk.nextToken();
                        signs[co]=current;
                        co++;
                    }


                   ArrayList<String> a = new ArrayList<String>();



                   for (int i = 0; i < signs.length; i++) {
                       a.add(signs[i]);
                   }

                   if(a.size()==1){
                       tot=Double.parseDouble(a.get(0));
                   }


                   if(a.get(counter).contentEquals("/")){
                       t.setText("Error");
                       counter=100;
                   }
                   if(a.get(counter).contentEquals("+")){
                       t.setText("Error");
                       counter=100;
                   }
                   if(a.get(counter).contentEquals("-")){
                       t.setText("Error");
                       counter=100;
                   }
                   if(a.get(counter).contentEquals("*")){
                       t.setText("Error");
                       counter=100;
                   }


                   while (counter < a.size() - 1 ) {
                       counter++;
                       if (a.get(counter).contentEquals("/")) {

                           x = null;
                           if (counter - 1 >= 0) {
                               x = (double) Double.parseDouble(a.get(counter - 1));
                           }
                           y = null;
                           if (counter + 1 <= a.size()) {
                               y = (double) Double.parseDouble(a.get(counter + 1));
                           }


                           if (x != null && y != null) {
                               tot = x / y;
                               a.set(counter - 1, Double.toString((float) tot));
                               a.remove(counter);
                               a.remove(counter);
                               counter = 0;
                           }


                       } else if (a.get(counter).contentEquals("*")) {
                           x = (double) Double.parseDouble(a.get(counter - 1));
                           y = (double) Double.parseDouble(a.get(counter + 1));

                           tot = x * y;

                           a.set(counter - 1, Double.toString((double) tot));
                           a.remove(counter);
                           a.remove(counter);
                           counter = 0;

                       }


                   }

                   counter = 0;

                   while (counter < a.size() - 1 ) {

                       counter++;

                       if (a.get(counter).contentEquals("+")) {
                           z = (double) Double.parseDouble(a.get(counter - 1));
                           p = (double) Double.parseDouble(a.get(counter + 1));

                           tot = z + p;

                           a.set(counter - 1, Double.toString((double) tot));
                           a.remove(counter);
                           a.remove(counter);
                           counter = 0;

                       } else if (a.get(counter).contentEquals("-")) {
                           z = (double) Double.parseDouble(a.get(counter - 1));
                           p = (double) Double.parseDouble(a.get(counter + 1));


                           tot = z - p;

                           a.set(counter - 1, Double.toString((double) tot));
                           a.remove(counter);
                           a.remove(counter);
                           counter = 0;
                       }


                   }
                   if(tot%1 !=0) {
                       t.setText(Double.toString(tot));
                   }
                   else{
                       t.setText(Integer.toString((int)tot));
                   }

               }
               catch(Exception e) {
                       t.setText("Error");
               }




            }






    }


}