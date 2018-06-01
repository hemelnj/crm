/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.crud_action_event;

import olcm.data.class_type.ClassTypes;
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
import olcm.data.action_event.ActionEvents;
import olcm.data.class_status.ClassStatuses;
import olcm.data.role.Roles;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_CRUD_Action_EVENT")
@NamedQueries({
    @NamedQuery(name = "crud.allCRUDsByClassType", query = "SELECT g FROM CrudActionEvents g where g.classType.id=:id")
})
public class CrudActionEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @ManyToOne
    @JoinColumn(name = "CLASS_TYPE_ID")
    private ClassTypes classType;
    
    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private ClassStatuses classStatus;
    
    @ManyToOne
    @JoinColumn(name = "ACTION_ID")
    private ActionEvents actionEvent;
    
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

    public ClassTypes getClassType() {
        return classType;
    }

    public void setClassType(ClassTypes classType) {
        this.classType = classType;
    }

    public ClassStatuses getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(ClassStatuses classStatus) {
        this.classStatus = classStatus;
    }

    public ActionEvents getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(ActionEvents actionEvent) {
        this.actionEvent = actionEvent;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    
}
