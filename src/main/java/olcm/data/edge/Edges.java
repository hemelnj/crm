/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.edge;

import olcm.data.class_type.ClassTypes;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import olcm.data.action_event.ActionEvents;
import olcm.data.class_status.ClassStatuses;
import olcm.data.edge_role_mapping.EdgeRoleMappings;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_EDGE")
@NamedQueries({
    @NamedQuery(name = "edge.allEdgesByClassType", query = "SELECT g FROM Edges g where g.classType.id=:id")
})
public class Edges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "EDGE_ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "CLASS_ID")
    private ClassTypes classType;
    
    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private ClassStatuses status;
    
    @ManyToOne
    @JoinColumn(name = "ACTION_ID")
    private ActionEvents actionEvent;
    
    @ManyToOne
    @JoinColumn(name = "END_STATUS_ID")
    private ClassStatuses endStatus;
    
    @OneToMany(mappedBy = "edge")
    private List<EdgeRoleMappings> edgeRolMappings;
    
    

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

    public ClassStatuses getStatus() {
        return status;
    }

    public void setStatus(ClassStatuses status) {
        this.status = status;
    }

    public ActionEvents getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(ActionEvents actionEvent) {
        this.actionEvent = actionEvent;
    }

    public ClassStatuses getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(ClassStatuses endStatus) {
        this.endStatus = endStatus;
    }

    public List<EdgeRoleMappings> getEdgeRolMappings() {
        return edgeRolMappings;
    }

    public void setEdgeRolMappings(List<EdgeRoleMappings> edgeRolMappings) {
        this.edgeRolMappings = edgeRolMappings;
    }

   
    

}
