/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.class_type;

import olcm.data.crud_action_event.CrudActionEvents;
import olcm.data.class_status_mapping.ClassStatusMappings;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import olcm.data.edge.Edges;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_CLASS_TYPE")

public class ClassTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CLASS_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull 
    @Column(name="name", unique=true)
    private String name;
    
    @OneToMany(mappedBy = "classType")
    private List<ClassStatusMappings> classStatusMappings;
    
    
    @OneToMany(mappedBy = "classType")
    private List<CrudActionEvents> crudActionEvents;
    
    @OneToMany(mappedBy = "classType")
    private List<Edges> egdes;
    
    
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

    public List<Edges> getEgdes() {
        return egdes;
    }

    public void setEgdes(List<Edges> egdes) {
        this.egdes = egdes;
    }

   
    
    
}
