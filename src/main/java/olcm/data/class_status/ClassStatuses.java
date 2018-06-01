/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.class_status;

import olcm.data.crud_action_event.CrudActionEvents;
import olcm.data.class_status_mapping.ClassStatusMappings;
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
import olcm.data.edge.Edges;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_CLASS_STATUS")
@NamedQueries({
    @NamedQuery(name = "status.all_status_of_a_class", query = "SELECT cs FROM ClassStatuses cs,ClassStatusMappings csm where cs.id=csm.classStatus.id and csm.classType.id=:id"),
     @NamedQuery(name = "status.notMappedStatuses", query = "SELECT cs FROM ClassStatuses cs,ClassStatusMappings csm where cs.id=csm.classStatus.id and csm.classType.id <> :id"),
     @NamedQuery(name = "status.nextAllowableStatuByClassTypeAndActionEvent", query = "Select cs FROM ClassStatuses cs,ClassStatuses endcs,Edges ed,ActionEvents ae,ClassTypes ct, EdgeRoleMappings erm, Roles r where endcs.id=ed.status.id and cs.id=ed.endStatus.id and ae.id=ed.actionEvent.id and ct.id=ed.classType.id and erm.edge.id=ed.id and r.id=erm.role.id and ed.classType.id=:classtypeId and ed.actionEvent.id=:actionEventId and r.id=:roleId")
})
public class ClassStatuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "STATUS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String name;
    
    @OneToMany(mappedBy = "classStatus")
    private List<ClassStatusMappings> classStatusMappings;
    
    @OneToMany(mappedBy = "classStatus")
    private List<CrudActionEvents> crudActionEvents;
    
    @OneToMany(mappedBy = "status")
    private List<Edges> startEdges;
    
    
    @OneToMany(mappedBy = "endStatus")
    private List<Edges> endEdges;

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

    public List<ClassStatusMappings> getClassStatusMappings() {
        return classStatusMappings;
    }

    public void setClassStatusMappings(List<ClassStatusMappings> classStatusMappings) {
        this.classStatusMappings = classStatusMappings;
    }

    public List<CrudActionEvents> getCrudActionEvents() {
        return crudActionEvents;
    }

    public void setCrudActionEvents(List<CrudActionEvents> crudActionEvents) {
        this.crudActionEvents = crudActionEvents;
    }

    public List<Edges> getStartEdges() {
        return startEdges;
    }

    public void setStartEdges(List<Edges> startEdges) {
        this.startEdges = startEdges;
    }

    public List<Edges> getEndEdges() {
        return endEdges;
    }

    public void setEndEdges(List<Edges> endEdges) {
        this.endEdges = endEdges;
    }

  
   
    
}
