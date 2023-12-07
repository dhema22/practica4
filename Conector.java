package practica4;
import java.sql.*;

public class Conector {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/world";
		String usuario="pruebaconector";
		String password="pruebaconector";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection miConexion = DriverManager.getConnection(url,usuario,password);
			Statement peticion=miConexion.createStatement();
			String sql=("SELECT * FROM `paisescapitales` WHERE `Continent` = 'Europe' ");
			ResultSet resultado=peticion.executeQuery(sql);
			while(resultado.next()) {
				String nombre=resultado.getString("name");
				String capital=resultado.getString("cityName");
				String region=resultado.getString("region");
				int population=resultado.getInt("population");
				int gnp=resultado.getInt("GNP");
				System.out.println("Country: "+nombre+" Region: "+region+" Capital: "+capital+" Population: "+population+" GNP: "+gnp);
			}
			resultado.close();
			peticion.close();
			miConexion.close();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
