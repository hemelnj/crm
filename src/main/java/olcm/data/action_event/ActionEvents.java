/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.action_event;

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
import olcm.data.edge.Edges;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_ACTION_EVENT")
@NamedQueries({
    @NamedQuery(name = "event.allEventsByType", query = "SELECT g FROM ActionEvents g where g.type=:type")
    ,
    @NamedQuery(name = "event.allEventsByTypes", query = "SELECT g FROM ActionEvents g where g.type IN :types")
    ,
    @NamedQuery(name = "event.allAllowableActions", query = "SELECT ae FROM "
            + " ClassTypes ct,ClassStatuses cs,ActionEvents ae,EdgeRoleMappings erm,Edges ed,Roles ro Where "
            + " ct.id=ed.classType.id AND "
            + " cs.id = ed.status.id AND "
            + " ae.id = ed.actionEvent.id AND "
            + " erm.edge.id = ed.id AND "
            + " ro.id = erm.role.id "
            + " AND ct.id=:classTypeId  AND cs.id =:statusId  AND ro.id =:roleId")
    ,
    @NamedQuery(name = "event.allAllowableCRUDActions", query = "SELECT ae FROM "
            + " ClassTypes ct,ClassStatuses cs,ActionEvents ae,CrudActionEvents cae,Roles ro "
            + " Where ct.id=cae.classType.id AND "
            + " cs.id = cae.classStatus.id AND "
            + " ae.id = cae.actionEvent.id AND "
            + " ro.id = cae.role.id "
            + " AND ct.id=:classTypeId  AND cs.id =:statusId  AND ro.id =:roleId")
    ,
     @NamedQuery(name = "event.getEventByName", query = "SELECT g FROM ActionEvents g where g.name=:name and g.type=:type")
})
public class ActionEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ACTION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "actionEvent")
    private List<CrudActionEvents> crudActionEvents;

    @OneToMany(mappedBy = "actionEvent")
    private List<Edges> edges;

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

    public List<CrudActionEvents> getCrudActionEvents() {
        return crudActionEvents;
    }

    public void setCrudActionEvents(List<CrudActionEvents> crudActionEvents) {
        this.crudActionEvents = crudActionEvents;
    }

    public List<Edges> getEdges() {
        return edges;
    }

    public void setEdges(List<Edges> edges) {
        this.edges = edges;
    }

}
