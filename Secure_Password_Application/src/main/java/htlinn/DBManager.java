package htlinn;


import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.sql.DataSource;
import java.sql.*;

public class DBManager {

    private static DBManager dbm;
    private String DBDRIVER;
    private String DBPATH;
    private String DBUSER;
    private String DBPASSWORD;
    private Connection c = null;
    private DataSource dataSource = null;

    DBManager (){


    }

    public static DBManager getDBM (){
        if(dbm == null)
        {
            dbm = new DBManager();
            return dbm;
        }
        return dbm;
    }

    public void Initialize(String DBDRIVER,String DBPATH,String DBUSER, String DBPASSWORD)
    {
        this.DBDRIVER = DBDRIVER;
        this.DBPATH = DBPATH;
        this.DBUSER = DBUSER;
        this.DBPASSWORD = DBPASSWORD;

        try {
            Class.forName(DBDRIVER);
            c = DriverManager.getConnection(DBPATH,DBUSER, DBPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
    public Connection getConnection ()throws SQLException
    {
        Connection con = dataSource.getConnection();
        //Connection con = c;
        System.out.println("Connection wird ausgegeben.");
        return con;
    }

    public void Initialize(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public boolean checkUser(String username, String password)
    {
        String hashed_password ="";
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = getConnection();
            st = con.prepareStatement("SELECT * FROM users WHERE username = ? ;");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            if(rs.next() == true )
            {
                hashed_password = rs.getString("password");
                if(BCrypt.checkpw(password,hashed_password))
                {
                    return true;
                }

            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally{
            closeConnection(con,st);
        }
        return false;
    }
    public void closeConnection(Connection con, PreparedStatement st)
    {

        try {

            if(con != null){
                st.close();
            }
            if(con != null)
            {
                con.close();
            }

            System.out.println("Connection wird wieder in den Pool gegeben.");
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Datenbank-Connenction kann nicht geschlossen werden wenn sie nicht geöffnet ist!");
        }
    }
    public void Register(String username, String password){
        System.out.println("\u001B[32m"+"Trying Registration"+"\u001B[0m");
        PreparedStatement st = null;
        Connection con = null;
        String hashed_password = "PW!";

        try
        {
            hashed_password= BCrypt.hashpw(password,BCrypt.gensalt());
            System.out.println("Hash: "+hashed_password);
            con = getConnection();
            st = con.prepareStatement("INSERT INTO users (username,password) VALUES (?,?); ");
            st.setString(1,username);
            st.setString(2,hashed_password);
            st.executeQuery();
        } catch ( Exception e) {
            e.printStackTrace();
            System.out.println("\u001B[32m"+"Registration Failed"+"\u001B[0m");
        }
    }
}
