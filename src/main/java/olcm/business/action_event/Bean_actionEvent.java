/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.action_event;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.action_event.ActionEvents;
import olcm.data.action_event.Repo_actionEvent;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_actionEvent {

    @Inject
    Repo_actionEvent repo_actionEvent;

    public Boolean save(ActionEvent actionEvent) {
        ActionEvents actionEvents = new ActionEvents();
        try {
            Converter_actionEvent.ViewToDataModelConverter(actionEvents, actionEvent);
            repo_actionEvent.create(actionEvents);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(ActionEvent actionEvent) {
        ActionEvents actionEvents = new ActionEvents();
        try {
            Converter_actionEvent.ViewToDataModelConverter(actionEvents, actionEvent);
            repo_actionEvent.update(actionEvents);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean saveList(List<ActionEvent> actionEvents) {
        try {
            for (int i = 0; i < actionEvents.size(); i++) {
                save(actionEvents.get(i));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ActionEvent getById(Object Id) {
        ActionEvents actionEvents = new ActionEvents();
        actionEvents = repo_actionEvent.read(Id);
        ActionEvent actionEvent = new ActionEvent();
        Converter_actionEvent.dataToViewModelConverter(actionEvents, actionEvent);
        return actionEvent;
    }

    public List<ActionEvent> getAll() {
        List<ActionEvent> allActionEvent = new ArrayList();
        List<ActionEvents> allActionEvents = repo_actionEvent.readAll();
        getListOfViewModelFromDataModel(allActionEvents, allActionEvent);
        return allActionEvent;
    }

    public List<ActionEvent> allAllByType(String type) throws ParseException {
        List<ActionEvent> allActionEvent = new ArrayList();
        List<ActionEvents> allActionEvents = repo_actionEvent.allEventsByType(type);
        getListOfViewModelFromDataModel(allActionEvents, allActionEvent);
        return allActionEvent;
    }

    public List<ActionEvent> allAllowableActions(Long classTypeId, Long statusId, Long roleId) throws ParseException {
        List<ActionEvent> allActionEvent = new ArrayList();
        List<ActionEvents> allActionEvents = repo_actionEvent.allAllowableActions(classTypeId, statusId, roleId);
        getListOfViewModelFromDataModel(allActionEvents, allActionEvent);
        return allActionEvent;
    }

    public List<ActionEvent> allAllowableCRUDActions(Long classTypeId, Long statusId, Long roleId) throws ParseException {
        List<ActionEvent> allActionEvent = new ArrayList();
        List<ActionEvents> allActionEvents = repo_actionEvent.allAllowableCRUDActions(classTypeId, statusId, roleId);
        getListOfViewModelFromDataModel(allActionEvents, allActionEvent);
        return allActionEvent;
    }

    public List<ActionEvent> allAllByCRUDTypes() throws ParseException {
        List<String> crudTypes = new ArrayList();
        crudTypes.add("Create");
        crudTypes.add("View");
        crudTypes.add("Update");
        List<ActionEvent> allActionEvent = new ArrayList();
        List<ActionEvents> allActionEvents = repo_actionEvent.allEventsByTypes(crudTypes);
        getListOfViewModelFromDataModel(allActionEvents, allActionEvent);
        return allActionEvent;
    }

    private void getListOfViewModelFromDataModel(List<ActionEvents> allActionEvents, List<ActionEvent> allActionEvent) {
        for (int i = 0; i < allActionEvents.size(); i++) {
            ActionEvent actionEvent = new ActionEvent();
            Converter_actionEvent.dataToViewModelConverter(allActionEvents.get(i), actionEvent);
            allActionEvent.add(actionEvent);
        }
    }

    public ActionEvent getEventByName(String name, String type) throws ParseException {
            ActionEvent actionEvent = new ActionEvent();
            Converter_actionEvent.dataToViewModelConverter(repo_actionEvent.getEventByName(name, type), actionEvent);
            return actionEvent;
    }

}
