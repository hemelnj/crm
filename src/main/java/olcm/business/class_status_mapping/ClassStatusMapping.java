/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_status_mapping;

import javax.xml.bind.annotation.XmlRootElement;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.ClassType;
import olcm.data.class_status.ClassStatuses;
import olcm.data.class_type.ClassTypes;

/**
 *
 * @author admin
 */
@XmlRootElement
public class ClassStatusMapping {

    private Long id;
    private ClassType classType;
    private ClassStatus classStatus;

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

    

}
