/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.crud_action_event;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.crud_action_event.CrudActionEvents;
import olcm.data.crud_action_event.Repo_crudActionEvent;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_crudActionEvent {

    @Inject
    Repo_crudActionEvent repo_crudActionEvent;

    public Boolean save(CrudActionEvent object) {
        CrudActionEvents crudActionEvents = new CrudActionEvents();
        try {
            Converter_crudActionEvent.ViewToDataModelConverter(crudActionEvents, object);
            repo_crudActionEvent.create(crudActionEvents);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<CrudActionEvent> getAll() {
        List<CrudActionEvent> allCrudActionEvent = new ArrayList();
        List<CrudActionEvents> allCrudActionEvents = repo_crudActionEvent.readAll();
        for (int i = 0; i < allCrudActionEvents.size(); i++) {
            CrudActionEvent crudActionEvent = new CrudActionEvent();
            Converter_crudActionEvent.dataToViewModelConverter(allCrudActionEvents.get(i), crudActionEvent);
            allCrudActionEvent.add(crudActionEvent);
        }
        return allCrudActionEvent;
    }

    
        public List<CrudActionEvent> allEdgesByClassType(long id) throws ParseException {
        List<CrudActionEvent> allCrudActionEvent = new ArrayList();
        List<CrudActionEvents> allCrudActionEvents = repo_crudActionEvent.allCRUDsByClassType(id);
        for (int i = 0; i < allCrudActionEvents.size(); i++) {
            CrudActionEvent crudActionEvent = new CrudActionEvent();
            Converter_crudActionEvent.dataToViewModelConverter(allCrudActionEvents.get(i), crudActionEvent);
            allCrudActionEvent.add(crudActionEvent);
        }
        return allCrudActionEvent;
    }
}
