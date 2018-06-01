/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_status_mapping;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.business.class_status.Bean_classStatus;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.Bean_classType;
import olcm.business.class_type.ClassType;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_ClassStatusPosting {

    @Inject
    Bean_classStatusMapping bean_classStatusMapping;
    @Inject
    Bean_classType Bean_classType;
    @Inject
    Bean_classStatus Bean_classStatus;
    @Inject
    ClassStatusMapping classStatusMapping;

    public Boolean save(ClassStatusMappingPostingTemplate classStatusMappingPostingTemplate) {
        ClassType classType = new ClassType();
        ClassStatus classStatus = new ClassStatus();
        classType = Bean_classType.getById(classStatusMappingPostingTemplate.getClassTypeId());
        classStatus = Bean_classStatus.getById(classStatusMappingPostingTemplate.getStatusId());
        classStatusMapping.setClassStatus(classStatus);
        classStatusMapping.setClassType(classType);
        try {
            bean_classStatusMapping.save(classStatusMapping);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Boolean save(List<ClassStatusMappingPostingTemplate> classStatusMappingPostingtemplate_List) {

        try {
            for (int i = 0; i < classStatusMappingPostingtemplate_List.size(); i++) {
                individualInsertionOfClassStatusMappingPostingTemplate(classStatusMappingPostingtemplate_List, i);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void individualInsertionOfClassStatusMappingPostingTemplate(List<ClassStatusMappingPostingTemplate> classStatusMappingPostingtemplate_List, int i) {
        ClassType classType = new ClassType();
        ClassStatus classStatus = new ClassStatus();
        classType = Bean_classType.getById(classStatusMappingPostingtemplate_List.get(i).getClassTypeId());
        classStatus = Bean_classStatus.getById(classStatusMappingPostingtemplate_List.get(i).getStatusId());
        classStatusMapping.setClassStatus(classStatus);
        classStatusMapping.setClassType(classType);
        bean_classStatusMapping.save(classStatusMapping);
    }

}
