/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import java.util.List;
import olcm.business.edge_role_mapping.EdgeRoleMappingPostingTemplate;

/**
 *
 * @author Admin
 */
public class EdgeAndEdgeRoleMappingPostingTemplate {

private EdgePostingTemplate edgePostingTemplate;
        
    private List<Long> role;

    public EdgePostingTemplate getEdgePostingTemplate() {
        return edgePostingTemplate;
    }

    public void setEdgePostingTemplate(EdgePostingTemplate edgePostingTemplate) {
        this.edgePostingTemplate = edgePostingTemplate;
    }

 
    public List<Long> getRole() {
        return role;
    }

    public void setRole(List<Long> role) {
        this.role = role;
    }

   
}
