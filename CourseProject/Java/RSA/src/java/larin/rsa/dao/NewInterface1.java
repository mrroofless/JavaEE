/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.rsa.dao;

import javax.persistence.EntityManager;

/**
 *
 * @author Учебный
 */
public interface NewInterface1 {

    /**
     * @return the em
     */
    EntityManager getEm();

    /**
     * @param em the em to set
     */
    void setEm(EntityManager em);
    
}
