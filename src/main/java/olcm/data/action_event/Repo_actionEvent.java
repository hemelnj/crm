/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.action_event;

import java.text.ParseException;
import java.util.List;
import olcm.data.class_status.*;
import olcm.data.class_status_mapping.*;
import olcm.data.class_type.*;
import olcm.data.crud_action_event.*;
import olcm.data.edge.*;
import olcm.data.edge_role_mapping.*;
import olcm.common.Repo_OLCM;

/**
 *
 * @author Admin
 */
public class Repo_actionEvent extends Repo_OLCM<ActionEvents> {

    public Repo_actionEvent() {
        super(ActionEvents.class);
    }

    public List<ActionEvents> allEventsByType(String type) throws ParseException {
        List<ActionEvents> allEventsByType = null;
        try {
            allEventsByType = getEntityManager()
                    .createNamedQuery("event.allEventsByType")
                    .setParameter("type", type)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allEventsByType;
    }

    public List<ActionEvents> allEventsByTypes(List<String> types) throws ParseException {
        List<ActionEvents> allEventsByType = null;
        try {
            allEventsByType = getEntityManager()
                    .createNamedQuery("event.allEventsByTypes")
                    .setParameter("types", types)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allEventsByType;
    }

    public List<ActionEvents> allAllowableActions(Long classTypeId, Long statusId, Long roleId) throws ParseException {
        List<ActionEvents> allEventsByType = null;
        try {
            allEventsByType = getEntityManager()
                    .createNamedQuery("event.allAllowableActions")
                    .setParameter("classTypeId", classTypeId)
                    .setParameter("statusId", statusId)
                    .setParameter("roleId", roleId)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allEventsByType;
    }

    public List<ActionEvents> allAllowableCRUDActions(Long classTypeId, Long statusId, Long roleId) throws ParseException {
        List<ActionEvents> allEventsByType = null;
        try {
            allEventsByType = getEntityManager()
                    .createNamedQuery("event.allAllowableCRUDActions")
                    .setParameter("classTypeId", classTypeId)
                    .setParameter("statusId", statusId)
                    .setParameter("roleId", roleId)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allEventsByType;
    }

    public ActionEvents getEventByName(String name, String type) throws ParseException {
        
        ActionEvents getEventByName = null;
        try {
            getEventByName = (ActionEvents) getEntityManager()
                    .createNamedQuery("event.getEventByName")
                    .setParameter("name", name)
                    .setParameter("type", type)
                    .getSingleResult();
        } catch (Exception exp) {
            throw exp;
        }
        return getEventByName;
    }

}
