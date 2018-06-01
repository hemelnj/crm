/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.crud_action_event;

import java.text.ParseException;
import java.util.List;
import olcm.data.edge_role_mapping.*;
import olcm.common.Repo_OLCM;

/**
 *
 * @author Admin
 */
public class Repo_crudActionEvent extends Repo_OLCM<CrudActionEvents>{

    public Repo_crudActionEvent() {
        super(CrudActionEvents.class);
    }
    
      public List<CrudActionEvents> allCRUDsByClassType(long id) throws ParseException {
        List<CrudActionEvents> allCRUDsByClassType = null;
        try {
            allCRUDsByClassType = getEntityManager()
                    .createNamedQuery("crud.allCRUDsByClassType")
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allCRUDsByClassType;
    }
}
