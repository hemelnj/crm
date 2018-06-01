/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import java.util.List;
import java.util.Objects;
import olcm.business.action_event.ActionEvent;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.ClassType;
import olcm.business.role.Role;

/**
 *
 * @author Admin
 */
public class DetailedEdgeViewTemplate {
    private long id;
    private ClassType classType;
    private ClassStatus classStatus;
    private ClassStatus endClassStatus;
    private ActionEvent actionEvent;
    private List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassType getClassType() {
        return classType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.classType);
        hash = 37 * hash + Objects.hashCode(this.classStatus);
        hash = 37 * hash + Objects.hashCode(this.endClassStatus);
        hash = 37 * hash + Objects.hashCode(this.actionEvent);
        hash = 37 * hash + Objects.hashCode(this.roles);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetailedEdgeViewTemplate other = (DetailedEdgeViewTemplate) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.classType, other.classType)) {
            return false;
        }
        if (!Objects.equals(this.classStatus, other.classStatus)) {
            return false;
        }
        if (!Objects.equals(this.endClassStatus, other.endClassStatus)) {
            return false;
        }
        if (!Objects.equals(this.actionEvent, other.actionEvent)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
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

    public ClassStatus getEndClassStatus() {
        return endClassStatus;
    }

    public void setEndClassStatus(ClassStatus endClassStatus) {
        this.endClassStatus = endClassStatus;
    }

    public ActionEvent getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
}
