/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodados;

import java.sql.*;

/**
 *
 * @author wolfi
 */
public class BancoDados {

    private Connection conexao = null;

    /*
    private String nomeDriver = "org.mariadb.jdbc.Driver";
    private String localBancoDados = "jdbc:mariadb://localhost:3306/bancodados";
    private String usuario = "root";
    private String senha = "admin";
     */
    
    private String nomeDriver = "org.postgresql.Driver";
    private String localBancoDados = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "postgres";
    private String senha = "admin";

    public BancoDados() {
        conecta();
    }

    public void conecta() {
        try {

            Class.forName(nomeDriver).newInstance();
            conexao = DriverManager.getConnection(localBancoDados, usuario, senha);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet executaQuery(String sql) {
        if (conexao == null) {
            conecta();
        }

        ResultSet rs = null;

        try {
            Statement st = conexao.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

}
