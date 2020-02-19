/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comptes;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author Ferhat Yacine
 */
@Local
public interface AjouterCompteLocal {
    void addCompte(Compte compte);
    List<Compte> getComptes();
    List<Compte> getSingleCompte(int idCompte);
}


