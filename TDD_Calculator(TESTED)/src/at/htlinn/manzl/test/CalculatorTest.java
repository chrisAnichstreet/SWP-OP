package at.htlinn.manzl.test;
import at.htlinn.manzl.calculator.Calculator;
import at.htlinn.manzl.exceptions.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void validInput() throws InvalidFormatException
    {
        assertEquals(11, Calculator.add("4;7"));
    }
    @Test(expected = InvalidFormatException.class)
    public void invalidDelimeter() throws InvalidFormatException
    {
        assertEquals(11,Calculator.add("3;"));
    }
    @Test
    public void multibleInput() throws InvalidFormatException
    {
        assertEquals(32,Calculator.add("11;5;4;3;7;2"));
    }
    @Test
    public void ownDelimiter() throws InvalidFormatException
    {
        assertEquals(10,Calculator.add("5 3 2"," "));
    }
    @Test(expected = InvalidFormatException.class)
    public void emptyString() throws InvalidFormatException
    {
        assertEquals(0, Calculator.add(""));
    }
    @Test(expected = InvalidFormatException.class)
    public void spaceString() throws InvalidFormatException
    {
        assertEquals(0, Calculator.add(" "));
    }
}