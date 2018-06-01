/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_type;

import olcm.data.crud_action_event.CrudActionEvents;
import olcm.data.class_status_mapping.ClassStatusMappings;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import olcm.business.class_status_mapping.ClassStatusMapping;
import olcm.business.crud_action_event.CrudActionEvent;
import olcm.business.edge.Edge;
import olcm.data.edge.Edges;

/**
 *
 * @author admin
 */
@XmlRootElement
public class ClassType {
    private Long id;
    private String name;

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
