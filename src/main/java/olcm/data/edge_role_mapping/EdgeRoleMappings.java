/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.edge_role_mapping;

import olcm.data.role.Roles;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import olcm.data.edge.Edges;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_EDGE_ROLE_MAPPING")
@NamedQueries({
    @NamedQuery(name = "edgeRoleMapping.edgeInfoByClassType", query = "SELECT g FROM EdgeRoleMappings g,Edges e where g.edge.id=e.id and g.edge.classType.id=:id"),
     @NamedQuery(name = "edgeRoleMapping.delete", query = "DELETE FROM EdgeRoleMappings g where g.edge.id=:eid")
  
})
public class EdgeRoleMappings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EDGE_ID")
    private Edges edge;
    
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Roles role;
    
    
    //--------setters and getters--------//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Edges getEdge() {
        return edge;
    }

    public void setEdge(Edges edge) {
        this.edge = edge;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

  

    
}
