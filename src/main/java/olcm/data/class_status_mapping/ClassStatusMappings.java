/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.class_status_mapping;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import olcm.data.class_status.ClassStatuses;
import olcm.data.class_type.ClassTypes;
 
/**
 *
 * @author admin
 */
@Entity
@Table(name = "OLCM_CLASS_STATUS_MAPPING")
@NamedQueries({
    @NamedQuery(name = "classStatusMappings.allEdgesByClassType", query = "SELECT g FROM ClassStatusMappings g where g.classType.id=:id")
})
public class ClassStatusMappings implements Serializable {

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

    
   
    
    
}
