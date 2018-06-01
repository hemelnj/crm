/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.crud_action_event;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.business.action_event.ActionEvent;
import olcm.business.action_event.Bean_actionEvent;
import olcm.business.class_status.Bean_classStatus;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.Bean_classType;
import olcm.business.class_type.ClassType;
import olcm.business.role.Bean_role;
import olcm.business.role.Role;
import olcm.data.crud_action_event.CrudActionEvents;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_crudActionEventPosting {

    @Inject
    Bean_crudActionEvent bean_crudActionEvent;
    @Inject
    Bean_classType bean_classType;
    @Inject
    Bean_classStatus bean_classStatus;
    @Inject
    Bean_actionEvent bean_actionEvent;
    @Inject
    Bean_role bean_role;
    
       public Boolean save_List(List<CrudActionEventPostingTemplate> crudActionEventPostingTemplates) {
       
        try {
            for(int i=0;i<crudActionEventPostingTemplates.size();i++){
                save(crudActionEventPostingTemplates.get(i));
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Boolean save(CrudActionEventPostingTemplate crudActionEventPostingTemplate) {
        ClassType classType = new ClassType();
        ClassStatus classStatus = new ClassStatus();
        ActionEvent actionEvent = new ActionEvent();
        Role role = new Role();
        classType = bean_classType.getById(crudActionEventPostingTemplate.getClassType());
        classStatus = bean_classStatus.getById(crudActionEventPostingTemplate.getClassStatus());
        actionEvent = bean_actionEvent.getById(crudActionEventPostingTemplate.getActionEvent());
        role = bean_role.getById(crudActionEventPostingTemplate.getRole());
        CrudActionEvent crudActionEvent = new CrudActionEvent();
        crudActionEvent.setActionEvent(actionEvent);
        crudActionEvent.setClassStatus(classStatus);
        crudActionEvent.setClassType(classType);
        crudActionEvent.setRole(role);
        try {
            bean_crudActionEvent.save(crudActionEvent);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
