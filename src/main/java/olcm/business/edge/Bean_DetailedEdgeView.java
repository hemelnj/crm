/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.business.role.Bean_role;
import olcm.business.role.Role;
import olcm.data.edge.Edges;
import olcm.data.edge.Repo_edge;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_DetailedEdgeView {

    @Inject
    Bean_edge bean_edge;
    @Inject
    Bean_role bean_role;

    public List<DetailedEdgeViewTemplate> detailedEdgesInfoByClassType(long id) throws ParseException {
        List<DetailedEdgeViewTemplate> detailedEdgeViewTemplates = new ArrayList();
        List<Edge> allEdge = bean_edge.allEdgesByClassType(id);
   
        for(int i=0;i<allEdge.size();i++){
            DetailedEdgeViewTemplate detailedEdgeViewTemplate=new DetailedEdgeViewTemplate();
            detailedEdgeViewTemplate.setId(allEdge.get(i).getId());
            detailedEdgeViewTemplate.setActionEvent(allEdge.get(i).getActionEvent());
            detailedEdgeViewTemplate.setClassStatus(allEdge.get(i).getStatus());
            detailedEdgeViewTemplate.setClassType(allEdge.get(i).getClassType());
            detailedEdgeViewTemplate.setEndClassStatus(allEdge.get(i).getEndStatus());
             List<Role>  allRole = bean_role.getAllRoleByEdge(allEdge.get(i).getId());
            detailedEdgeViewTemplate.setRoles(allRole);
            detailedEdgeViewTemplates.add(detailedEdgeViewTemplate);
        }
        return detailedEdgeViewTemplates;
    }
}
