package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {

	public boolean parolaValida(String parola) {
		
		final String sql = "SELECT nome FROM parola p";
		
		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				String parolaDizionario = rs.getString("nome");
				
				if(parolaDizionario.equals(parola)) {
					
					conn.close();
					return true;
					
				}
				
			}
			
			conn.close();
			return false;
			
		} catch(SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
		
	}
	
}
