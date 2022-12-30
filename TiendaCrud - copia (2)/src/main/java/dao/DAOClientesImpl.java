package dao;


import java.sql.*;

import java.util.ArrayList;
import conexion.*;

import javax.swing.*;

public class DAOClientesImpl implements Operations {

    Database db = new Database();

    Clientes clie = new Clientes();

    Database table = new Database();
//INSERT
    @Override
    public boolean insert(Object obj) {
        //casting
        clie = (Clientes) obj;
        Connection connection;

        PreparedStatement pstmt;
        String SQLinsert = "INSERT INTO clientes values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName(db.getDriver());




            connection = DriverManager.getConnection(
                    db.getURL(), db.getUSER(), db.getPWD());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");

            pstmt= connection.prepareStatement(SQLinsert);

            pstmt.setInt(1, clie.getId());
            pstmt.setString(2, clie.getNombre());
            pstmt.setString(3, clie.getApellido());
            pstmt.setString(4, clie.getMascota());
            pstmt.setInt(5, clie.getEdad());
            pstmt.setString(7, clie.getAlimento());
            pstmt.setDate(6, clie.getFecha_nacimiento());
            pstmt.setString(8, clie.getEmail());
            pstmt.setInt(9, clie.getTelefono());
            pstmt.setString(10, clie.getUsuario());
            pstmt.setString(11, clie.getClave());

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente " + e.getMessage());
            return false;
            //catch (SQLException / ClassssNotFoundException e)
        }

    }
//DELETE

    @Override
    public boolean delete(Object obj) {
        //casting
        //return false;
        clie = (Clientes) obj;
        Connection connection;
        PreparedStatement pstmt;
        String SQL = "delete from clientes WHERE id = ?";

        try {
            //  Connection connection;
            Class.forName(db.getDriver());
            connection = DriverManager.getConnection(
                    db.getURL(), db.getUSER(), db.getPWD());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
            pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, clie.getId());

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente " + e.getMessage());
            return false;
            //catch (SQLException / ClassssNotFoundException e)
        }

    }

    //UPDATE
    @Override
    public boolean upDate(Object obj) {
        //casting
        //return false;
        clie = (Clientes) obj;
        Connection connection;
        PreparedStatement pstmt;
        String SQLupdate = "UPDATE  clientes SET nombre=?, "
                + "apellido=?, mascota=?, edad=?,alimento=?," +
                " fecha_nacimiento=?, email=?,telefono= ?, " +
                "usuario= ?, clave=? WHERE id= ?";

        try {
            //  Connection connection;
            Class.forName(db.getDriver());
            connection = DriverManager.getConnection(
                    db.getURL(), db.getUSER(), db.getPWD());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");


            pstmt = connection.prepareStatement(SQLupdate);

            pstmt.setString(1, clie.getNombre());
            pstmt.setString(2, clie.getApellido());
            pstmt.setString(3, clie.getMascota());
            pstmt.setInt(4, clie.getEdad());
            pstmt.setString(6, clie.getAlimento());
            pstmt.setDate(5, clie.getFecha_nacimiento());
            pstmt.setString(7, clie.getEmail());
            pstmt.setInt(8, clie.getTelefono());
            pstmt.setString(9, clie.getUsuario());
            pstmt.setString(10, clie.getClave());
            pstmt.setInt(11, clie.getId());

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente " + e.getMessage());
            return false;
            //catch (SQLException / ClassssNotFoundException e)
        }

    }

    //CONSULTAR
    @Override
    public ArrayList<Object[]> consultar() {
        ArrayList<Object[]> data = new ArrayList<>();
        Connection connection;
        PreparedStatement psmt;
        ResultSet rs;
        String SQLconsultar = "SELECT * FROM clientes ORDER BY ID";

        try {
            //conexion a la base de datos
            //Connection connection;

            Class.forName(db.getDriver());
            connection = DriverManager.getConnection(
                    db.getURL(), db.getUSER(), db.getPWD());

            System.out.println("LA CONEXION SE HA ESTABLECIDO EXITOSAMENTE");
            psmt = connection.prepareStatement(SQLconsultar);
            rs = psmt.executeQuery();
            //recprremos el ResultSet y se crea nvosregistros para la variable data q es un arraylist
            while (rs.next()) {
                Object[] fila = new Object[11];
                for (int i = 0; i <= 11; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                data.add(fila);
            }
            connection.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió el error siguiente " + e.getMessage());

            //catch (SQLException / ClassssNotFoundException e)
        } finally {
            return data;
        }


    }
}