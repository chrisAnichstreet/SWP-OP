package at.htlinn.manzl.matrix;

import at.htlinn.manzl.exception.NotMultiplicatableException;

public class Matrix {

    public void Matrix(){}


    public double[][] Multipliacate(double[][] first_mat, double[][] second_mat) throws NotMultiplicatableException
    {
        if (Multiplicateable(first_mat,second_mat) == false)
        {
            throw new NotMultiplicatableException();
        }
        double [][] product_mat = new double [first_mat.length][second_mat[0].length];

        for (int i = 0; i < second_mat[0].length; i++)
        {
            for (int j = 0; j < first_mat.length; j++)
            {
                for (int k = 0; k < second_mat.length; k++)
                {
                    product_mat[j][i]+= first_mat[j][ k] * second_mat[k][i];
                }
            }
        }
        return product_mat;
    }

    public boolean Multiplicateable(double[][] first_mat, double[][] second_mat)
    {

        if(first_mat[0].length != second_mat.length)
        {
            return false;
        }
        return true;
    }

    public double[][] ScalarMultiplicate(double[][] first_mat, double scal)
    {
        for (int i = 0; i < first_mat[0].length; i++)
        {
            for (int j = 0; j < first_mat.length; j++)
            {
                first_mat[j][i] = first_mat[j][i] * scal;
            }
        }
        return first_mat;
    }

    public boolean addable(double[][] first_mat, double[][] second_mat)
    {
        if((first_mat.length)==(second_mat.length) && (first_mat[0].length)==(second_mat[0].length))
        {
            return true;
        }
        return false;
    }

    public double[][] add(double[][] first_mat, double[][] second_mat)
    {
        for(int i = 0; i < first_mat.length; i++)
        {
            for(int j = 0; j < first_mat[0].length; j++)
            {
                first_mat[i][j] = first_mat[i][j] + second_mat[i][j];
            }
        }
        return first_mat;
    }

    public boolean equals(double[][] real_mat, double[][] check_mat)
    {
        for(int i = 0; i < real_mat.length; i++)
        {
            for(int j = 0; j < real_mat[0].length; j++)
            {
                if(real_mat[i][j] != check_mat[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public double[][] activationfunction(double[][] real_mat)
    {
        for(int i = 0; i < real_mat.length; i++)
        {
            for(int j = 0; j < real_mat[0].length; j++)
            {
                       double container = (Math.pow(2.7182818284590452353602874713527,real_mat[i][j]))/(Math.pow(2.7182818284590452353602874713527,real_mat[i][j])+1);
                  if(1 - container < (Math.pow(10,-10)) )
                {
                    real_mat[i][j] = 1;
                }
                else if(0 - container > ((-1)*Math.pow(10,-10)) )
                {
                    real_mat[i][j] = 0;
                }
                else
                {
                  real_mat[i][j]=container;
                }

             System.out.println(real_mat[i][j]);
            }
        }
        return real_mat;
    }
}