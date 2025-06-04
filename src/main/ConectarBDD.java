package main;

import java.sql.*;

public class ConectarBDD{
	// Librería de MySQL
	public String driver = "com.mysql.cj.jdbc.Driver";

	// Nombre de la base de datos
	public String database = "etpa2_g25v4";

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
			System.out.println("Ha ocurrido un error al intentar conectar a la base de datos");
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
			System.out.println("Ha ocurrido un error al intentar insertar datos en la base de datos");
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
			System.out.println("Ha ocurrido un error al intentar actualizar datos en la base de datos");
			return false;
		}
	}

// Método para consultar datos
	public boolean consultarDatos(String tabla, String columnas, String condicion) {
		String query = "SELECT " + columnas + " FROM " + tabla + " WHERE " + condicion;
		try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
			ResultSet resultado = stmt.executeQuery();
			ResultSetMetaData metaData = resultado.getMetaData();
			int numColumnas = metaData.getColumnCount();
			while (resultado.next()) {
				for (int i = 1; i <= numColumnas; i++) {
					System.out.print(resultado.getString(i) + "\n");
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

// Método para consultar datos int
public int consultarDatosint(String columnas, String tabla, String condicion) {
    int resultado = 0;
    String query = "SELECT " + columnas + " FROM " + tabla + " WHERE " + condicion;
	try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
		ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            resultado = rs.getInt(columnas);
        }
    } catch (SQLException e) {
		System.out.println("Ha ocurrido un error al intentar usar la base de datos");
		resultado = -1; // Retorna -1 en caso de error
    }
    return resultado;
}

//Método para consultar datos String
public String consultarDatosString(String columnas, String tabla, String condicion) {
 String resultado = null;
 String query = "SELECT " + columnas + " FROM " + tabla + " WHERE " + condicion;
 try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
     ResultSet rs = stmt.executeQuery();
     if (rs.next()) {
         resultado = rs.getString(columnas);
     }
 } catch (SQLException e) {
     System.out.println("Ha ocurrido un error al intentar usar la base de datos");
     resultado = null; // Retorna null en caso de error
 }
 return resultado;
}

// Método para iniciar sesión
	public boolean iniciarSesionBDD(String condicion) {
		String query = "SELECT * FROM jugador WHERE " + condicion;
	    try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
	        ResultSet resultado = stmt.executeQuery();
	        if (resultado.next()) {
	            return true;
	        } else {
	        	return false;
	        }
	    } catch (SQLException e) {
	    	return false;
	    }
	}


// Método para consultar la tabla de puntuaciones
	public boolean consultarPuntuaciones() {
		String consultarPuntuaciones = "SELECT nombreJugador, puntos FROM jugador ORDER BY puntos DESC";
		try (Connection conn = conectarMySQL();
				PreparedStatement stmt = conn.prepareStatement(consultarPuntuaciones);
				ResultSet resultData = stmt.executeQuery()) {
			while (resultData.next()) {
				System.out.println(resultData.getString(1)+ " - " + resultData.getInt(2) + " puntos\n");
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar consultar las puntuaciones");
			return false;
		}
	}
//Método para obtener el número de filas de una tabla
	public int obtenerNumeroDeFilas(String tabla) {
		int numeroDeFilas = 0;
		String query = "SELECT COUNT(*) AS total FROM " + tabla;
		try (Connection conn = conectarMySQL(); PreparedStatement stmt = conn.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				numeroDeFilas = rs.getInt("total");
			}
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar obtener el número de filas de la tabla");
			numeroDeFilas = -1; // Retorna -1 en caso de error
		}
		return numeroDeFilas;
	}
}



