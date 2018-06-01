/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge_role_mapping;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.business.edge.Bean_edge;
import olcm.business.edge.Edge;
import olcm.business.role.Bean_role;
import olcm.business.role.Role;
import olcm.data.edge_role_mapping.EdgeRoleMappings;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_edgeRoleMappingPosting {

    @Inject
    Bean_edgeRoleMapping bean_edgeRoleMapping;
    @Inject
    Bean_edge bean_Edge;
    @Inject
    Bean_role bean_role;

    public Boolean save(List<EdgeRoleMappingPostingTemplate> edgeRoleMappingPostingTemplate_List) {

        try {
            for (int i = 0; i < edgeRoleMappingPostingTemplate_List.size(); i++) {
                individualInsertionOfEdgeRoleMappingPostingTemplate(edgeRoleMappingPostingTemplate_List, i);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
     public Boolean update(List<EdgeRoleMappingPostingTemplate> edgeRoleMappingPostingTemplate_List) {

        try {
            for (int i = 0; i < edgeRoleMappingPostingTemplate_List.size(); i++) {
                individualInsertionOfEdgeRoleMappingPostingTemplate(edgeRoleMappingPostingTemplate_List, i);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void individualInsertionOfEdgeRoleMappingPostingTemplate(List<EdgeRoleMappingPostingTemplate> edgeRoleMappingPostingTemplate_List, int i) {
        Role role = new Role();
        Edge edge = new Edge();
        edge = bean_Edge.getById(edgeRoleMappingPostingTemplate_List.get(i).getEdge());
        role = bean_role.getById(edgeRoleMappingPostingTemplate_List.get(i).getRole());
        EdgeRoleMapping edgeRoleMapping = new EdgeRoleMapping();
        edgeRoleMapping.setEdge(edge);
        edgeRoleMapping.setRole(role);
        bean_edgeRoleMapping.save(edgeRoleMapping);
    }
    
     private void updateIndividualEdgeRoleMappingPostingTemplate(List<EdgeRoleMappingPostingTemplate> edgeRoleMappingPostingTemplate_List, int i) {
        Role role = new Role();
        Edge edge = new Edge();
        edge = bean_Edge.getById(edgeRoleMappingPostingTemplate_List.get(i).getEdge());
        role = bean_role.getById(edgeRoleMappingPostingTemplate_List.get(i).getRole());
        EdgeRoleMapping edgeRoleMapping = new EdgeRoleMapping();
        edgeRoleMapping.setEdge(edge);
        edgeRoleMapping.setRole(role);
        bean_edgeRoleMapping.update(edgeRoleMapping);
    }
}
