package CalculadoraDeNotas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionFactory {
    private String usuario;
    private String senha;
    private String host;
    private String porta;
    private String bd;

    public ConnectionFactory() {

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
            this.usuario = prop.getProperty("usuario");
            this.senha = prop.getProperty("senha");
            this.host = prop.getProperty("host");
            this.porta = prop.getProperty("porta");
            this.bd = prop.getProperty("bd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha
            );
            return c;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}