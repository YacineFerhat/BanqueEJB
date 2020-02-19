/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comptes;
import java.io.Serializable;
/**
 *
 * @author Ferhat Yacine
 */
public class Compte implements Serializable  {
     private int num_cpte, num_emp, code_cli,solde;
     private String date_cr, type_pte;
   

    public Compte() {        
    }

    public int getNumCpte() {
       return num_cpte;
    }

    public void setNumCpte(int num_cpte) {
       this.num_cpte = num_cpte;
    }
     public int getNumEmp() {
       return num_emp;
    }

    public void setNumEmp(int num_emp) {
       this.num_emp = num_emp;
    }
     public int getNumCli() {
       return code_cli;
    }

    public void setNumCli(int code_cli) {
       this.num_cpte = code_cli;
    }
     public int getSolde() {
       return solde;
    }

    public void setSolde(int solde) {
       this.solde = solde;
    }
     public String getDateCr() {
       return date_cr;
    }

    public void setDateCr(String date_cr) {
       this.date_cr = date_cr;
    }
     public String getTypePte() {
       return type_pte;
    }

    public void setTypePte(String type_pte) {
       this.type_pte = type_pte;
    }
    
}

    

  
