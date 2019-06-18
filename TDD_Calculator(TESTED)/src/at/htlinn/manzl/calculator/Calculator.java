package at.htlinn.manzl.calculator;

import at.htlinn.manzl.exceptions.*;

public class Calculator {


    public static int add(String input, String delimiter) throws InvalidFormatException
    {
        String[] stringNumbers = input.split(delimiter);
        int sum = 0;
        if (stringNumbers.length < 2)
        {
            throw new InvalidFormatException();
        }
        if ((input == "") || (input == " "))
        {
            throw new InvalidFormatException();
        }
        for(int i=0 ;stringNumbers.length > i; i++)
        {
            sum = sum + Integer.parseInt(stringNumbers[i]);
        }
        return sum;
        /*try {
            return Integer.parseInt(stringNumbers[0]) + (Integer.parseInt(stringNumbers[1]));
        } catch(NumberFormatException e){
            throw new InvalidFormatException();
        }*/
    }
    public static int add(String input) throws InvalidFormatException
    {

        return add(input,";");


    }
}
