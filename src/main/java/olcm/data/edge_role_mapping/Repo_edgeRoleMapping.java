/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.edge_role_mapping;

import java.text.ParseException;
import java.util.List;
import olcm.common.Repo_OLCM;

/**
 *
 * @author Admin
 */
public class Repo_edgeRoleMapping extends Repo_OLCM<EdgeRoleMappings> {

    public Repo_edgeRoleMapping() {
        super(EdgeRoleMappings.class);
    }

    public List<EdgeRoleMappings> allEdgeRoleMappingsByClassType(long id) throws ParseException {
        List<EdgeRoleMappings> allEdgeRoleMappingsByClassType = null;
        try {
            allEdgeRoleMappingsByClassType = getEntityManager()
                    .createNamedQuery("edgeRoleMapping.edgeInfoByClassType")
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allEdgeRoleMappingsByClassType;
    }

    public boolean deleteRecord(long edgeId) throws ParseException {
        try {
            getEntityManager()
                    .createNamedQuery("edgeRoleMapping.delete")
                    .setParameter("eid", edgeId)
                    .executeUpdate();
            return true;
        } catch (Exception exp) {
            return false;
        }
    }
}
