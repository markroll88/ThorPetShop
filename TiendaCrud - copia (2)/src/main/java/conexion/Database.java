package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
//clase para efectuar la conexion de la base de datos sql y este programa
public class Database {


    // Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/tienda_crud";
   // private final String DB = "tienda_crud";
    private final String USER = "root";
    private final String PWD = "";
    private final String driver ="com.mysql.jdbc.Driver";

//static final String DB_URL = "jdbc:mysql://localhost:3306/sys";

    // public Database() {
    //   this.url = "jdbc:mysql://localhost:3306/";
    //    this.DB = "tienda_crud";
    //   this.user = "root";
    //     this.pwd = "";


// utilizo jdbc conectando a esta direccion xamp levantara  de este host ntra bd
// Por defecto es este host-puerto, hay q especificar, De haber otra configuracion para pwd y user, colocarla


    public void establecerConexion() {
//throws SQLException puede permitir errores de olvido de llaves, no es conveniente porque no soluciona nadathrows SQLException


        try {
            Connection connection = DriverManager.getConnection(URL , USER, PWD);
            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
            String SQL = "CREATE TABLE IF NOT EXISTS clientes(" + "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + "nombre VARCHAR(20),"
                    + "apellido VARCHAR(20),"
                    + "mascota VARCHAR(20),"
                    + "edad INT(3),"
                    + "alimento VARCHAR(30),"
                    + "fecha_nacimiento DATE,"
                    + "email VARCHAR(30),"
                    + "telefono INT(10),"
                    + "usuario VARCHAR(20),"
                    + "clave VARCHAR(20))";

            //CREAR UN OBJETO PreparedDStatement a partir de la declaracion SQL Siempre PreparedStatement porque disminuye inyecciones maliciosas sql
            PreparedStatement stmt = connection.prepareStatement(SQL);
            //EJECUTAR LA DECLARACION SQL PARA CREAR LA TABLA

            stmt.executeUpdate();


            //stmt.close();
            //******** CREACION DE LA DECLARACION SQL PARA INSERTAR DATOS EN LA TABLA ******


            // connection.close();
            // System.out.println("CONEXION CERRADA");


        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXION");
            // throw new RuntimeException(e);
        }

    }
    public String getURL() {
        return URL;
    }

   // public String getDB() {
   //     return DB;
  //  }

    public String getUSER() {
        return USER;
    }

    public String getPWD() {
        return PWD;
    }


    public String getDriver() {return driver;
    }
   // }
}
