/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge_role_mapping;

/**
 *
 * @author Admin
 */
public class EdgeRoleMappingPostingTemplate {

    private Long id;
    private Long edge;
    private Long role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEdge() {
        return edge;
    }

    public void setEdge(Long edge) {
        this.edge = edge;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
}
