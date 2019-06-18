package at.htlinn.manzl.test;

import at.htlinn.manzl.artificialneuralnetwork.Ann;
import at.htlinn.manzl.exception.NotMultiplicatableException;
import at.htlinn.manzl.matrix.Matrix;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class AnnTest {

    @Test
    public void generateaANN()
    {
        Ann ann = new Ann();
        int inputneuronnumber = 4;
        int hiddnlayerneurons [] = {2,6,7};
        int outputneuronnumber = 1;
        ann.generateann(inputneuronnumber,hiddnlayerneurons,outputneuronnumber);
    }

    @Test
    public void falseinputforgenerateANN()
    {
        Ann ann = new Ann();
        int inputneuronnumber = 4;
        int hiddnlayerneurons [] = {2,6,7};
        int outputneuronnumber = 1;
        ann.generateann(inputneuronnumber,hiddnlayerneurons,outputneuronnumber);
    }

    /*
    @Test
    public void falseinputforgenerateANN()
    {
        Ann ann = new Ann();
        int inputneuronnumber = 4;
        int hiddnlayerneurons [] = {2,6,7};
        int outputneuronnumber = 1;
        ann.generateann(inputneuronnumber,hiddnlayerneurons,outputneuronnumber);
    }

    @Test
    public void creationofaWightmatrix()
    {
        Ann ann = new Ann();
        Matrix mat = new Matrix();
        int inputneuronnumber = 4;
        int hiddnlayerneurons [] = {2};
        int outputneuronnumber = 1;
        ann.generateWightMatrix(inputneuronnumber,outputneuronnumber);

    }
    */
}
