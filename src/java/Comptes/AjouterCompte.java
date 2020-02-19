/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comptes;

import Comptes.Compte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class AjouterCompte implements AjouterCompteLocal {
    
   public AjouterCompte() {
   }

   
   public void addCompte(Compte compte) {
      Connection con = null;
      String url = "jdbc:mysql://localhost:3306/banque";
      String driver = "com.mysql.jdbc.Driver";

      String userName = "root";
      String password = "";
   
      List<Compte> comptes = new ArrayList<Compte>();
      try {

         Class.forName(driver).newInstance();
         con = DriverManager.getConnection(url , userName, password);

         PreparedStatement st = 
         con.prepareStatement("insert into compte(num_cpte, type_pte,date_cr, solde, num_emp, code_cli) values(?,?,?,?,?,?)");
         st.setInt(1,compte.getNumCpte());
         st.setInt(2,compte.getNumEmp());
         st.setInt(3,compte.getNumCli());
         st.setInt(4,compte.getSolde());
         st.setString(5,compte.getDateCr());
         st.setString(6,compte.getTypePte());

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
    public List<Compte> getSingleCompte(int idCompte){
       Connection con = null;  
       String url = "jdbc:mysql://localhost:3306/banque";
       String driver = "com.mysql.jdbc.Driver";
       String userName = "root";
       String password = "";
       List<Compte> comptes = new ArrayList<Compte>();
       try{
          Class.forName(driver).newInstance();
          con = DriverManager.getConnection(url , userName, password);
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from t_comptes where Num_cpte = "+idCompte);
          Compte compte;
          while (rs.next()) {
             compte = new Compte();
             compte.setNumCpte(rs.getInt(1));
             compte.setNumEmp(rs.getInt(2));                 
             compte.setNumCli(rs.getInt(3));                 
             compte.setSolde(rs.getInt(4));                 
             compte.setDateCr(rs.getString(5));                 
             compte.setTypePte(rs.getString(6));                 
             comptes.add(compte);
          }
       }catch (SQLException ex) {
          ex.printStackTrace();
       } catch (InstantiationException ex) {
          ex.printStackTrace();
       } catch (IllegalAccessException ex) {
          ex.printStackTrace();
       } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
       }
        return comptes;
    }
    
    public List<Compte> getComptes() {
       Connection con = null;  
       String url = "jdbc:mysql://localhost:3306/banque";
       String driver = "com.mysql.jdbc.Driver";

       String userName = "root";
       String password = "";
       List<Compte> comptes = new ArrayList<Compte>();
       try {

          Class.forName(driver).newInstance();
          con = DriverManager.getConnection(url , userName, password);

          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from t_comptes");

          Compte compte;
          while (rs.next()) {
             compte = new Compte();
             compte.setNumCpte(rs.getInt(1));
             compte.setNumEmp(rs.getInt(2));                 
             compte.setNumCli(rs.getInt(3));                 
             compte.setSolde(rs.getInt(4));                 
             compte.setDateCr(rs.getString(5));                 
             compte.setTypePte(rs.getString(6));                 
                             

             comptes.add(compte);
          }
       } catch (SQLException ex) {
          ex.printStackTrace();
       } catch (InstantiationException ex) {
          ex.printStackTrace();
       } catch (IllegalAccessException ex) {
          ex.printStackTrace();
       } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
       }
       return comptes;
    }
 }


 
