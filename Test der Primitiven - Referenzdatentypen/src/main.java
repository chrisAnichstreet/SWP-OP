public class main
{
    public static void main (String[]args)
    {
        int a = 12;
        int s = "h"
        DtContainer container = new DtContainer(12,"h");
        modifyObject(a,s);
        System.out.println(a + s);
    }

    public void modifyObject(int a, String s)
    {
        a =4;
        s = "hallo";
    }
}
