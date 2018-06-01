/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.class_status;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
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
public class Repo_classStatus extends Repo_OLCM<ClassStatuses> {

    public Repo_classStatus() {
        super(ClassStatuses.class);
    }

    public List<ClassStatuses> allStatusOfAClass(long classId) throws ParseException {
        List<ClassStatuses> allStatusOfAClass = null;
        try {
            allStatusOfAClass = getEntityManager()
                    .createNamedQuery("status.all_status_of_a_class")
                    .setParameter("id", classId)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allStatusOfAClass;
    }

    public List<ClassStatuses> notMappedStatuses(long classId) throws ParseException {
        List<ClassStatuses> allStatusOfAClass = null;
        try {
            allStatusOfAClass = getEntityManager()
                    .createNamedQuery("status.notMappedStatuses")
                    .setParameter("id", classId)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allStatusOfAClass;
    }

    public ClassStatuses nextAllowableStatuByClassTypeAndActionEventAnRole(long classId, long actionEventId, long roleId) throws ParseException {
       ClassStatuses nextAllowableStatuByClassTypeAndActionEvent = null;
        try {
            nextAllowableStatuByClassTypeAndActionEvent = (ClassStatuses) getEntityManager()
                    .createNamedQuery("status.nextAllowableStatuByClassTypeAndActionEvent")
                    .setParameter("classtypeId", classId)
                    .setParameter("actionEventId", actionEventId)
                    .setParameter("roleId", roleId)
                    .getSingleResult();
        } catch (Exception exp) {
            throw exp;
        }
        return nextAllowableStatuByClassTypeAndActionEvent;
    }

}
