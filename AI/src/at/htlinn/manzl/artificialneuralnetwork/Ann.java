package at.htlinn.manzl.artificialneuralnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import at.htlinn.manzl.matrix.*;

public class Ann {

    Matrix matann = new Matrix();

    int inputneuronnumber;

    int [] hiddnlayerneurons;


    //Wight Matrix Container
    List<List> wmcontainer = new ArrayList<List>();
    //Bios Vector
    ArrayList<Double> bv = new ArrayList<>();
    //Bios Vector Container
    List<List<Double>> bvcontainer = new ArrayList<List<Double>>();

    int outputneuronnumber;

    //Grenzen für den ZufallszahlenGenerator
    int randrangemin = -1;
    int randrangemax = 1;

    public void Ann()
    {
        
    }

    public void generateann(int inputneuronnumber, int[] hiddnlayerneurons, int outputneuronnumber) {
        this.inputneuronnumber = inputneuronnumber;
        this.hiddnlayerneurons= (hiddnlayerneurons);

        //Generiert so oft Bioses and Wights wie es Hiddenlayers gibt => es gitb keine Wight oder Bios vom letzten Hiddenlayer zum output
        for(int i = 0; i<=hiddnlayerneurons.length; i++)
        {
            wmcontainer.add(generateWightMatrix(hiddnlayerneurons,inputneuronnumber);
            bvcontainer.add(generateBiosVector(hiddnlayerneurons));
        }

    }


    //Generiert eine Wight Matrix also genug für einen Hiddenlayer
    public List<List> generateWightMatrix(int[] hiddnlayerneurons,  int inputneuronnumber)
    {
        List<List> hiddenlayerwm = new ArrayList<List>();

        //So oft wie es Hidden layers gibt muss eine neue Wight Matrix erstellt werden
        for(int i = 0; i<= hiddnlayerneurons[i] ; i++)
        {
            List<Double> oneneuronwm = new ArrayList<Double>();
            //Es müssen so viele wights werte  generiert werden wie es Neuronen im nächsten hiddenlayer gibt
            for(int j = 0; j < hiddnlayerneurons[i+1]; j++)
            {
                oneneuronwm.add(ThreadLocalRandom.current().nextDouble(randrangemin, randrangemax));

            }
            hiddenlayerwm.add(oneneuronwm);
        }
        return hiddenlayerwm;
    }

    //Generiert einen Bios vector, also für jedes neuron einen, Reicht also für einen Hiddenlayer
    public List<Double> generateBiosVector(int[] hiddnlayerneurons)
    {
        List<Double> generatedbv = new ArrayList<Double>();

        //Es werden so viele Bioses generiert wie es neuronen in einem Hiddenlayer gibt
        for(int i = 0; i< hiddnlayerneurons[i]; i++)
        {
            bv.add(ThreadLocalRandom.current().nextDouble(randrangemin, randrangemax));
        }
        return generatedbv;
    }

    public void ANNwork(List<Double> input)
    {
        // Bewegt sich durch die einzelnen Layer, der Layercounter gibt die aktuelle layer nummer dem Calcnextlayer mit.
        for(int hiddenlayer = 0; hiddenlayer < hiddnlayerneurons.length; hiddenlayer++)
        {
            calcnextlayer(input,hiddenlayer);
        }

    }
    //Hier werden die Neuronen berechnet
    public void calcnextlayer(List<Double> input, int hiddenlayer)
    {
        Double first_mat [] = (Double[])wmcontainer.get(hiddenlayer).toArray();
        Double second_mat [] = input.toArray(new Double[0]);
        Double third_mat [] = bvcontainer.get(hiddenlayer).toArray(new Double[0]);

        matann.activationfunction((matann.Multipliacate(first_mat,second_mat)),third_mat);
    }

    //Soll die Input List in einen Array convertieren
    public double[][] convert(List<Double> input)
    {
        double [][] converted = new double [0][input.size()];
        for(int i = 0; i < input.size();i++)
        {
            converted[0][i] = input.get(i);
        }

        return converted;
    }

    //Soll die Wightmatrix List in einen Array Convertieren
    public double[][] convert(int hiddenlayer, List<Double> wightmatoneneuron)
    {
        //double [][] converted = new double [wmcontainer.get(hiddenlayer).size()][];
        double [][] converted = new double [wightmatoneneuron.size()][];

        for(int i = 0; i< wightmatoneneuron.size();i++)
        {
            //Quasi den Array der die Wight Matrix eines neurons Beschreibt soll vollständig in dieser Stelle des 2 Arrays (höhere Dimension des Arrays hinzugefügt werden.
            //Mein Problem: Ich kann nicht bestimmen wie lang der Array mit wights des Jeweiligen Neurons ist. Deshalb wäre es praktisch dies einfach in den double Array zu kiopiern => Recherche Internet
            converted[i][].clone(wightmatoneneuron.get(i));
        }

        return converted;
    }

}