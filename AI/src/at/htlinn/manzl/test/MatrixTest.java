package at.htlinn.manzl.test;

import at.htlinn.manzl.exception.NotMultiplicatableException;
import at.htlinn.manzl.matrix.Matrix;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void Multiplicate() throws NotMultiplicatableException
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] real_mat = {{6,6},{6,6}};
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,1},{1,1},{1,1}};
        assertEquals(true,mat.equals(real_mat,mat.Multipliacate(first_mat,second_mat)));
 
    }

    @Test
    public void isMultiplicatable()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,1},{1,1},{1,1}};

        assertEquals(true,mat.Multiplicateable(first_mat,second_mat));
    }

    @Test
    public void isNotMultiplicatable()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,1,1},{1,1,1}};

        assertEquals(false,mat.Multiplicateable(first_mat,second_mat));
    }

    @Test
    public void ScalarMultiplication()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] real_mat = {{3,6,9},{3,6,9}};
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double scal = 3;

        assertTrue(mat.equals(real_mat,mat.ScalarMultiplicate(first_mat,scal)));
    }

    @Test
    public void notScalarMultiplication()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] real_mat = {{4,8,9},{3,6,9}};
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double scal = 3;

        assertFalse(mat.equals(real_mat,mat.ScalarMultiplicate(first_mat,scal)));
    }

    @Test
    public void isaddable()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,4,1},{7,1,6}};
        assertEquals(true,mat.addable(first_mat,second_mat));
    }

    @Test
    public void isnotaddable()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,1},{1,1}};
        assertEquals(false,mat.addable(first_mat,second_mat));

    }

    @Test
    public void addition()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] real_mat = {{2,3,4},{2,3,4}};
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,1,1},{1,1,1}};
        assertTrue(mat.equals(real_mat,mat.add(first_mat,second_mat)));
    }

    @Test
    public void noaddition()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] real_mat = {{1,2,3},{1,2,3}};
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,1,1},{1,1,1}};
        assertFalse(mat.equals(real_mat,mat.add(first_mat,second_mat)));
    }

    @Test
    public void noequals()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]

        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,1,1},{1,1,1}};
        assertFalse(mat.equals(first_mat,second_mat));
    }
    @Test
    public void equals()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{1,2,3},{1,2,3}};
        double [][] second_mat = {{1,2,3},{1,2,3}};
        assertTrue(mat.equals(first_mat,second_mat));
    }
    @Test
    public void neuronLightsup()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{100,200,100},{100,600,100}};
        double [][] sigmoided = {{1,1,1},{1,1,1}};
        assertTrue(mat.equals(sigmoided,mat.activationfunction(first_mat)));
    }
    @Test
    public void neuronsLightsout()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{-100,-200,-100},{-100,-600,-100}};
        double [][] sigmoided = {{0,0,0},{0,0,0}};
        assertTrue(mat.equals(sigmoided,mat.activationfunction(first_mat)));
    }

    @Test
    public void neuronslightalittle()
    {
        Matrix mat = new Matrix();
        // double [Zeilen] [Spalten]
        double [][] first_mat = {{5,4,7},{-2,-3,3}};
        double [][] sigmoided = {{0.9933071490757152,0.9820137900379085,0.9990889488055994},{0.11920292202211755,0.04742587317756678,0.9525741268224333}};
        assertTrue(mat.equals(sigmoided,mat.activationfunction(first_mat)));
    }
}
