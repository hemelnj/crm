/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.crud_action_event;

import olcm.business.action_event.ActionEvent;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.ClassType;
import olcm.business.role.Role;
import olcm.common.DataConverter;
import olcm.data.action_event.ActionEvents;
import olcm.data.class_status.ClassStatuses;
import olcm.data.class_type.ClassTypes;
import olcm.data.crud_action_event.CrudActionEvents;
import olcm.data.role.Roles;

/**
 *
 * @author Admin
 */
public class Converter_crudActionEvent {

    public static void dataToViewModelConverter(CrudActionEvents dataModel, CrudActionEvent viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setClassType(DataConverter.dataToView_classType(dataModel.getClassType()));
        viewModel.setRole(DataConverter.dataToView_role(dataModel.getRole()));
        viewModel.setActionEvent(DataConverter.dataToView_actionEvent(dataModel.getActionEvent()));
        viewModel.setClassStatus(DataConverter.dataToView_classStatus(dataModel.getClassStatus()));
    }

    public static void ViewToDataModelConverter(CrudActionEvents dataModel, CrudActionEvent viewModel) {
      //  dataModel.setId(viewModel.getId());
        dataModel.setActionEvent(DataConverter.viewToData_actionEvent(viewModel.getActionEvent()));
        dataModel.setClassStatus(DataConverter.viewToData_classStatus(viewModel.getClassStatus()));
        dataModel.setClassType(DataConverter.viewToData_classType(viewModel.getClassType()));
        dataModel.setRole(DataConverter.viewToData_role(viewModel.getRole()));
    }

}
