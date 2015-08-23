package com.example.adan.basicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    //The ArrayList Will Store User Input

    ArrayList<String> arrayList = new ArrayList<String>();
    String string = "";
    String string1 = "";


    public void onClick1(View v){

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        Button button = (Button) v;

        //This will get all values entered into key and mapping them to a string.
        string = (String) button.getText().toString();


        //This will allow for multiple digit values to be added.
       //The values are concatanted until symbol is pressed
        if(!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/")) {
            string1 = string1 + string;

            //If i enter 5 then enter 4, 5 will be replaced with 54.
            if (arrayList.size()>0) {

                arrayList.remove((arrayList.size()-1));
            }
            //Now add current string to array.
             arrayList.add(string1);
        } else {
            //Since we removed last entered value, if something is entered, duplicate it.
            arrayList.add(string);
            arrayList.add(string);
            string1 = "";

        }

        //Remove commas.
        editText2.setText(editText2.getText().toString()+string);

    }

    public void equalsCalculation(View v){

        EditText editText1 = (EditText) findViewById(R.id.editText1);

        //Mapping array list size with variable c.
        int calc = 0;
        int c = arrayList.size();

        //As you iterate through the loop the values in the arraylist
        //are slowly reduced until the list is empty.
        while(c != 1){
            if(c > 3){
                if(arrayList.get(3).contains("*") || arrayList.get(3).contains("/")){
                    if(arrayList.get(3).contains("*")){calc = Integer.parseInt(arrayList.get(2))*Integer.parseInt(arrayList.get(4));}
                    if(arrayList.get(3).contains("/")){calc = Integer.parseInt(arrayList.get(2))/Integer.parseInt(arrayList.get(4));}

                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.remove(2);

                    arrayList.add(2, Integer.toString(calc));
                    c = arrayList.size();

                }

                else{

                    if(arrayList.get(1).contains("+")){calc = Integer.parseInt(arrayList.get(0))+Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("-")){calc = Integer.parseInt(arrayList.get(0))-Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("*")){calc = Integer.parseInt(arrayList.get(0))*Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("/")){calc = Integer.parseInt(arrayList.get(0))/Integer.parseInt(arrayList.get(2));}

                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.remove(0);

                    arrayList.add(0, Integer.toString(calc));
                    c = arrayList.size();


                }
            }


                else{

                    if(arrayList.get(1).contains("+")){calc = Integer.parseInt(arrayList.get(0))+Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("-")){calc = Integer.parseInt(arrayList.get(0))-Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("*")){calc = Integer.parseInt(arrayList.get(0))*Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("/")){calc = Integer.parseInt(arrayList.get(0))/Integer.parseInt(arrayList.get(2));}

                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.remove(0);

                    arrayList.add(0, Integer.toString(calc));
                    c = arrayList.size();
            }
        }

        editText1.setText(Integer.toString(calc));

    }

    public void clear(View v){
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        string1 = "";
        string = "";

        editText1.setText("0");
        editText2.setText("");
        arrayList.clear();

    }

}
