/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.crud_action_event;

import olcm.data.class_type.ClassTypes;
import javax.xml.bind.annotation.XmlRootElement;
import olcm.business.action_event.ActionEvent;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.ClassType;
import olcm.business.role.Role;
import olcm.data.action_event.ActionEvents;
import olcm.data.class_status.ClassStatuses;
import olcm.data.role.Roles;

/**
 *
 * @author admin
 */
@XmlRootElement
public class CrudActionEvent{


    private Long id;
    

    private ClassType classType;
    
 
    private ClassStatus classStatus;
    

    private ActionEvent actionEvent;
    
  
    private Role role;

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

    public ClassStatus getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(ClassStatus classStatus) {
        this.classStatus = classStatus;
    }

    public ActionEvent getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
   

    
}
