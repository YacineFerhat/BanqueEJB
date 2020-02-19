/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comptes;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ferhat Yacine
 */
@Local
public interface ListerCompteLocal {
        List<Compte> getComptes();

}
