/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.role;

import olcm.data.crud_action_event.CrudActionEvents;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import olcm.business.crud_action_event.CrudActionEvent;
import olcm.business.edge_role_mapping.EdgeRoleMapping;
import olcm.data.edge_role_mapping.EdgeRoleMappings;

/**
 *
 * @author admin
 */
@XmlRootElement
public class Role {

    private Long id;

    private String name;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
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

}
