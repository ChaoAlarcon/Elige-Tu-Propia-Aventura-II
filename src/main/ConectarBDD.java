package main;

import java.sql.*;

public class ConectarBDD {

    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "etpa2_g25v2";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

// Método para insertar datos
	public boolean insertarDatos(String tabla, String columnas, String valores) {
		String query = "INSERT INTO " + tabla + " (" + columnas + ") VALUES (" + valores + ")";
		try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

// Método para actualizar datos
	public boolean actualizarDatos(String tabla, String cambios, String condicion) {
		String query = "UPDATE " + tabla + " SET " + cambios + " WHERE " + condicion;
		try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
// Método para consultar datos
	public boolean consultarDatos(String tabla, String columnas, String condicion) {
		String query = "SELECT " + columnas + " FROM " + tabla + " WHERE " + condicion;
		try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				System.out.println(resultado.getString(1));
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
