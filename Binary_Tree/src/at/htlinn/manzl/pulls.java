package at.htlinn.manzl;

public class pulls
{
    private log crone;


    public pulls()
    {

    }

    public void add(int id)
    {
        log  l = new log(id);
        if(crone == null) {
            crone = l;
            return;
        }
        /*if (( crone.getLeft() == null) || (crone.getRight() == null)) {
            if(l.getId() > crone.getId()){
                crone.setLeft(l);
            }
            else
            {
                crone.setRight(l);
            }
            return;
        }
        */

        log temp = crone;
        insert(l,temp);

    }
    private void insert(log l, log temp) {

        if (l.getId() > temp.getId()) {
            if (temp.getRight() != null) {
                temp = temp.getRight();
                insert(l,temp);

            } else {
                temp.setRight(l);
                return;
            }
        }

        if (l.getId() < temp.getId()) {
            if (temp.getLeft() != null) {
                temp = temp.getLeft();
                insert(l,temp);

            } else {
                temp.setLeft(l);
                return;
            }
        }



    /*
    public int recLeft(log way){
        return way.getId();
    }
    public int recRight(log way){
        return way.getId();
    }
    */

    }
    public int Get(int value){

        log temp = crone;
        return Search(value ,temp).getId();
    }

    private log Search(int value, log temp){

        if (value > temp.getId()) {
            if (temp.getRight() != null) {
                temp = temp.getRight();
                return Search(value,temp);

            }
        }

        if (value < temp.getId()) {

            if (temp.getLeft() != null) {
                temp = temp.getLeft();
                return Search(value,temp);

            }
        }
        if(value == temp.getId()){
            return temp;
        }
        return null;
    }

    public void Delete(int value){
        log temp = crone;
        Termination(value,temp);

    }

    private void Termination(int value, log temp){

        log term = Search(value, temp); //zu löschendes Element
        log pointterm = term;

        log maxterm = Max(value, term); // Maximum des Linken Zweiges
        log pointmaxterm = maxterm;

        log almostmax = AlMax(value,term); // Das Vorletzte Elemet vor dem Größten im linken Zweig (Um nach max. Folgende Nodes nicht zu verlieren)

        log aftermax = maxterm.getLeft(); // Das erste Element der Linken Reihe von max (Der Pointer auf das Element ist Max)

        //Beginn der Vertauschungen:
        term = maxterm;
        almostmax.setRight(aftermax);
    }

    private log Max(int value, log temp){

        if (value > temp.getId()) {
            if (temp.getRight() != null) {
                temp = temp.getRight();
                return Max(value,temp);

            }

        }
        return temp;
    }

    private log AlMax(int value, log temp){

        log almostmax = temp;
        if (value > temp.getId()) {
            if (temp.getRight() != null) {
                almostmax = temp;
                temp = temp.getRight();
                return AlMax(value,temp);

            }

        }
        return almostmax;
    }


}
