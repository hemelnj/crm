/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.class_status_mapping;

import java.text.ParseException;
import java.util.List;
import olcm.data.class_type.*;
import olcm.data.crud_action_event.*;
import olcm.data.edge_role_mapping.*;
import olcm.common.Repo_OLCM;

/**
 *
 * @author Admin
 */
public class Repo_classStatusMapping extends Repo_OLCM<ClassStatusMappings>{

    public Repo_classStatusMapping() {
        super(ClassStatusMappings.class);
    }
     public List<ClassStatusMappings> allClassStatusMappingsByClassType(long id) throws ParseException {
        List<ClassStatusMappings> allClassStatusMappingsByClassType = null;
        try {
            allClassStatusMappingsByClassType = getEntityManager()
                    .createNamedQuery("classStatusMappings.allEdgesByClassType")
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allClassStatusMappingsByClassType;
    }
    
    
}
