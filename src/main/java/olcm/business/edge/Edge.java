/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import olcm.data.class_type.ClassTypes;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import olcm.business.action_event.ActionEvent;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.ClassType;
import olcm.business.edge_role_mapping.EdgeRoleMapping;
import olcm.data.action_event.ActionEvents;
import olcm.data.class_status.ClassStatuses;
import olcm.data.edge_role_mapping.EdgeRoleMappings;

/**
 *
 * @author admin
 */
@XmlRootElement
public class Edge {

    private Long id;

    private ClassType classType;

    private ClassStatus status;
    

    private ActionEvent actionEvent;
    
 
    private ClassStatus endStatus;

    private List<EdgeRoleMapping> edgeRolMappings;
    
    

    //--------setters and getters--------//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public ClassStatus getStatus() {
        return status;
    }

    public void setStatus(ClassStatus status) {
        this.status = status;
    }

    public ActionEvent getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
    }

    public ClassStatus getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(ClassStatus endStatus) {
        this.endStatus = endStatus;
    }

    public List<EdgeRoleMapping> getEdgeRolMappings() {
        return edgeRolMappings;
    }

    public void setEdgeRolMappings(List<EdgeRoleMapping> edgeRolMappings) {
        this.edgeRolMappings = edgeRolMappings;
    }

   
    
    

}
