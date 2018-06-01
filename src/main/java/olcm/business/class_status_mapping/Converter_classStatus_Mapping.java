/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_status_mapping;

import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.ClassType;
import olcm.data.class_status.ClassStatuses;
import olcm.data.class_status_mapping.ClassStatusMappings;
import olcm.data.class_type.ClassTypes;

/**
 *
 * @author Admin
 */
public class Converter_classStatus_Mapping {

    public static void dataToViewModelConverter(ClassStatusMappings dataModel, ClassStatusMapping viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setClassType(dataToView_classType(dataModel.getClassType()));
        viewModel.setClassStatus(dataToView_classStatus(dataModel.getClassStatus()));
    }

    public static ClassType dataToView_classType(ClassTypes classTypes) {
        ClassType classType = new ClassType();
        classType.setId(classTypes.getId());
        classType.setName(classTypes.getName());
        return classType;
    }

    public static ClassStatus dataToView_classStatus(ClassStatuses classStatuses) {
        ClassStatus classStatus = new ClassStatus();
        classStatus.setId(classStatuses.getId());
        classStatus.setName(classStatuses.getName());
        return classStatus;
    }

    public static void viewToDataModelConverter(ClassStatusMappings dataModel, ClassStatusMapping viewModel) {
        dataModel.setId(viewModel.getId());
        dataModel.setClassType(viewToData_classType(viewModel.getClassType()));
        dataModel.setClassStatus(viewToData_classStatus(viewModel.getClassStatus()));
    }

    public static ClassTypes viewToData_classType(ClassType classType) {
        ClassTypes classTypes = new ClassTypes();
        classTypes.setId(classType.getId());
        classTypes.setName(classType.getName());
        classTypes.setClassStatusMappings(null);
        classTypes.setCrudActionEvents(null);
        classTypes.setEgdes(null);
        return classTypes;
    }

    public static ClassStatuses viewToData_classStatus(ClassStatus classStatus) {
        ClassStatuses classStatuses = new ClassStatuses();
        classStatuses.setId(classStatus.getId());
        classStatuses.setName(classStatus.getName());
        classStatuses.setClassStatusMappings(null);
        classStatuses.setCrudActionEvents(null);
        classStatuses.setEndEdges(null);
        classStatuses.setStartEdges(null);
        return classStatuses;
    }

}
