/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comptes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Ferhat Yacine
 */
@Stateful
public class Retrait implements RetraitLocal {
    public void takeOffMoney(int montant, int num_compte) {
            Connection con = null;
            String url = "jdbc:mysql://localhost:3306/banque";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            List<Compte> comptes = new ArrayList<Compte>();
            try {
               Class.forName(driver).newInstance();
               con = DriverManager.getConnection(url , userName, password);
               Statement statementSolde = con.createStatement();
               ResultSet rs = statementSolde.executeQuery("select solde from t_comptes where Num_cpte = "+num_compte);
               int soldeActuel =0 ;
               while(rs.next()) {
                   soldeActuel=rs.getInt(1);
               }
               PreparedStatement st = 
               con.prepareStatement("update t_compte set Solde =? where num_cpte="+num_compte);
               Compte compte;
               st.setInt(1,soldeActuel - montant);
               int result = st.executeUpdate();                
            } catch (SQLException ex) {
               ex.printStackTrace();
            } catch (InstantiationException ex) {
               ex.printStackTrace();
            } catch (IllegalAccessException ex) {
               ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            }  
       }
}
