/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.role;

import olcm.data.crud_action_event.CrudActionEvents;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import olcm.data.edge_role_mapping.EdgeRoleMappings;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_ROLE")
@NamedQueries({
    @NamedQuery(name = "role.roleByEdge", query = "SELECT r FROM Roles r, EdgeRoleMappings erm where r.id=erm.role.id and erm.edge.id=:id")
})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String name;

    
    @OneToMany(mappedBy = "role")
    private List<EdgeRoleMappings> edgeRolMappings;
    
    @OneToMany(mappedBy = "role")
    private List<CrudActionEvents> crudActionEvents;
    
    //--------setters and getters--------//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EdgeRoleMappings> getEdgeRolMappings() {
        return edgeRolMappings;
    }

    public void setEdgeRolMappings(List<EdgeRoleMappings> edgeRolMappings) {
        this.edgeRolMappings = edgeRolMappings;
    }

    public List<CrudActionEvents> getCrudActionEvents() {
        return crudActionEvents;
    }

    public void setCrudActionEvents(List<CrudActionEvents> crudActionEvents) {
        this.crudActionEvents = crudActionEvents;
    }


    
}
