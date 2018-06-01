/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.crud_action_event;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class CrudActionEventPostingTemplate {

    private Long id;

    private Long classType;
    private Long classStatus;

    private Long actionEvent;

    private Long role;

    public CrudActionEventPostingTemplate() {
    }

    public CrudActionEventPostingTemplate(Long id, Long classType, Long classStatus, Long actionEvent, Long role) {
        this.id = id;
        this.classType = classType;
        this.classStatus = classStatus;
        this.actionEvent = actionEvent;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CrudActionEventPostingTemplate{" + "id=" + id + ", classType=" + classType + ", classStatus=" + classStatus + ", actionEvent=" + actionEvent + ", role=" + role + '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassType() {
        return classType;
    }

    public void setClassType(Long classType) {
        this.classType = classType;
    }

    public Long getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Long classStatus) {
        this.classStatus = classStatus;
    }

    public Long getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(Long actionEvent) {
        this.actionEvent = actionEvent;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.classType);
        hash = 47 * hash + Objects.hashCode(this.classStatus);
        hash = 47 * hash + Objects.hashCode(this.actionEvent);
        hash = 47 * hash + Objects.hashCode(this.role);
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
        final CrudActionEventPostingTemplate other = (CrudActionEventPostingTemplate) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.classType, other.classType)) {
            return false;
        }
        if (!Objects.equals(this.classStatus, other.classStatus)) {
            return false;
        }
        if (!Objects.equals(this.actionEvent, other.actionEvent)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

}
