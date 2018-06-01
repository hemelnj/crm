/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge_role_mapping;

import olcm.data.role.Roles;
import javax.xml.bind.annotation.XmlRootElement;
import olcm.business.edge.Edge;
import olcm.business.role.Role;
import olcm.data.edge.Edges;

/**
 *
 * @author admin
 */
@XmlRootElement
public class EdgeRoleMapping {

    private Long id;

    private Edge edge;
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

  
}
