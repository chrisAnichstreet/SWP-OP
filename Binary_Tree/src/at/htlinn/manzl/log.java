package at.htlinn.manzl;

public class log
{
    private int id;



    private log left;
    private log right;

    log(int id)
    {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public log getLeft() {
        return left;
    }

    public void setLeft(log left) {
        this.left = left;
    }

    public log getRight() {
        return right;
    }

    public void setRight(log right) {
        this.right = right;
    }





}
