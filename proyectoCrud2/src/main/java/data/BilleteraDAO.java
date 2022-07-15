package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import entity.Monedas;
import java.sql.*;
import java.util.*;

public class BilleteraDAO {

    private static final String SQL_CREATE = "INSERT INTO billetera(moneda, fundador, limiteDeEmision, precio, cantidad) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM billetera";
    private static final String SQL_UPDATE_PRECIO = "UPDATE billetera SET precio = ? WHERE idbilletera = ?";
    private static final String SQL_UPDATE_CANTIDAD = "UPDATE billetera SET cantidad = ? WHERE idbilletera = ?";
    private static final String SQL_UPDATE= "UPDATE billetera SET moneda = ?, fundador = ?, limiteDeEmision = ?, precio = ?, cantidad = ? WHERE idbilletera = ?";
    private static final String SQL_DELETE = "DELETE FROM billetera WHERE idbilletera = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM billetera WHERE idbilletera= ?";

    public List<Monedas> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Monedas moned= null;
        List<Monedas> moned_list = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idbilletera = rs.getInt(1);
                String moneda = rs.getString(2);
                String fundador = rs.getString(3);
                int limiteDeEmision = rs.getInt(4);
                double precio = rs.getDouble(5);
                int cantidad = rs.getInt(6);

                moned = new Monedas(idbilletera, moneda, fundador, limiteDeEmision, precio, cantidad);

                moned_list.add(moned);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return moned_list;
    }
    public Monedas findBookById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Monedas moned = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idbilletera = rs.getInt(1);
                String moneda = rs.getString(2);
                String fundador = rs.getString(3);
                int limiteDeEmision = rs.getInt(4);
                double precio = rs.getDouble(5);
                int cantidad = rs.getInt(6);

                moned = new Monedas(idbilletera, moneda, fundador, limiteDeEmision, precio, cantidad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return moned;
    }
    public int create(Monedas moned) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, moned.getMoneda());
            stmt.setString(2, moned.getFundador());
            stmt.setInt(3, moned.getLimiteDeEmision());
            stmt.setDouble(4, moned.getPrecio());
            stmt.setInt(5, moned.getCantidad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updatePrecio(Monedas moned) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, moned.getPrecio());
            stmt.setInt(2, moned.getIdbilletera());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updateCantidad(Monedas moned) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_CANTIDAD);
            stmt.setInt(1, moned.getCantidad());
            stmt.setInt(2, moned.getIdbilletera());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    public int update(Monedas moned) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, moned.getMoneda());
            stmt.setString(2, moned.getFundador());
            stmt.setInt(3, moned.getLimiteDeEmision());
            stmt.setDouble(4, moned.getPrecio());
            stmt.setInt(5, moned.getCantidad());
            stmt.setInt(6, moned.getIdbilletera());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
