/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.rsa.dao;

import java.sql.SQLException;
import larin.rsa.entity.Unfairlistofclients;

/**
 *
 * @author Учебный
 */
public interface NewInterface {

    void addUnfairClient(Unfairlistofclients ucl) throws SQLException;
    
}
