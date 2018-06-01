/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_status_mapping;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.class_status_mapping.ClassStatusMappings;
import olcm.data.class_status_mapping.Repo_classStatusMapping;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_classStatusMapping {

    @Inject
    Repo_classStatusMapping epo_classStatusMapping;

    public Boolean save(ClassStatusMapping object) {
        ClassStatusMappings classStatusMappings = new ClassStatusMappings();
        try {
            Converter_classStatus_Mapping.viewToDataModelConverter(classStatusMappings, object);
            epo_classStatusMapping.create(classStatusMappings);
            ClassStatusMapping classStatusMapping = new ClassStatusMapping();
            Converter_classStatus_Mapping.dataToViewModelConverter(classStatusMappings, classStatusMapping);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<ClassStatusMapping> getAll() {
        List<ClassStatusMapping> allClassStatusMapping = new ArrayList();
        List<ClassStatusMappings> allClassStatusMappings = epo_classStatusMapping.readAll();
        for (int i = 0; i < allClassStatusMappings.size(); i++) {
            ClassStatusMapping classStatusMapping = new ClassStatusMapping();
            Converter_classStatus_Mapping.dataToViewModelConverter(allClassStatusMappings.get(i), classStatusMapping);
            allClassStatusMapping.add(classStatusMapping);
        }
        return allClassStatusMapping;
    }
    
        public List<ClassStatusMapping> getAllByClassType(long classId) throws ParseException {
        List<ClassStatusMapping> allClassStatusMapping = new ArrayList();
        List<ClassStatusMappings> allClassStatusMappings = epo_classStatusMapping.allClassStatusMappingsByClassType(classId);
        for (int i = 0; i < allClassStatusMappings.size(); i++) {
            ClassStatusMapping classStatusMapping = new ClassStatusMapping();
            Converter_classStatus_Mapping.dataToViewModelConverter(allClassStatusMappings.get(i), classStatusMapping);
            allClassStatusMapping.add(classStatusMapping);
        }
        return allClassStatusMapping;
    }
}
