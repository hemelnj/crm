/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.common;

import java.util.ArrayList;
import java.util.List;
import olcm.business.action_event.ActionEvent;
import olcm.business.class_status.ClassStatus;
import olcm.business.class_type.ClassType;
import olcm.business.edge.Edge;
import olcm.business.edge_role_mapping.EdgeRoleMapping;
import olcm.business.role.Role;
import olcm.data.action_event.ActionEvents;
import olcm.data.class_status.ClassStatuses;
import olcm.data.class_type.ClassTypes;
import olcm.data.edge.Edges;
import olcm.data.edge_role_mapping.EdgeRoleMappings;
import olcm.data.role.Roles;

/**
 *
 * @author Admin
 */
public class DataConverter {

    public static ClassType dataToView_classType(ClassTypes classTypes) {
        ClassType classType = new ClassType();
        classType.setId(classTypes.getId());
        classType.setName(classTypes.getName());
        return classType;
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

    public static Role dataToView_role(Roles roles) {
        Role role = new Role();
        role.setId(roles.getId());
        role.setName(roles.getName());
        return role;
    }

    public static Edge dataToView_edge(Edges edges) {
        Edge edge = new Edge();
        edge.setId(edges.getId());
        edge.setActionEvent(dataToView_actionEvent(edges.getActionEvent()));
        edge.setClassType(dataToView_classType(edges.getClassType()));
        edge.setEdgeRolMappings(null);
        edge.setStatus(dataToView_classStatus(edges.getStatus()));
        edge.setEndStatus(dataToView_classStatus(edges.getEndStatus()));
        return edge;
    }

    public static Edges viewToData_edge(Edge edge) {
        Edges edges = new Edges();
        edges.setId(edge.getId());
        edges.setActionEvent(viewToData_actionEvent(edge.getActionEvent()));
        edges.setClassType(viewToData_classType(edge.getClassType()));
        edges.setEdgeRolMappings(null);
        edges.setStatus(viewToData_classStatus(edge.getStatus()));
        edges.setEndStatus(viewToData_classStatus(edge.getEndStatus()));
        return edges;
    }

    public static Roles viewToData_role(Role role) {
        Roles roles = new Roles();
        roles.setId(role.getId());
        roles.setName(role.getName());
        roles.setCrudActionEvents(null);
        roles.setEdgeRolMappings(null);

        return roles;
    }

    public static ActionEvent dataToView_actionEvent(ActionEvents actionEvents) {
        ActionEvent actionEvent = new ActionEvent();
        actionEvent.setId(actionEvents.getId());
        actionEvent.setName(actionEvents.getName());
        actionEvent.setType(actionEvents.getType());
        return actionEvent;
    }

    public static EdgeRoleMapping dataToView_edgeRoleMapping(EdgeRoleMappings edgeRoleMappings) {
        EdgeRoleMapping edgeRoleMapping = new EdgeRoleMapping();
        edgeRoleMapping.setId(edgeRoleMappings.getId());
        edgeRoleMapping.setEdge(dataToView_edge(edgeRoleMappings.getEdge()));
        edgeRoleMapping.setRole(dataToView_role(edgeRoleMappings.getRole()));
        return edgeRoleMapping;
    }

    public static List<EdgeRoleMapping> dataToView_edgeRoleMapping_List(List<EdgeRoleMappings> edgeRoleMappings) {
      List<EdgeRoleMapping> edgeRoleMapping_List=new ArrayList<>();
        for (int i = 0; i < edgeRoleMappings.size(); i++) {
            EdgeRoleMapping edgeRoleMapping = new EdgeRoleMapping();
            edgeRoleMapping=dataToView_edgeRoleMapping(edgeRoleMappings.get(i));
            edgeRoleMapping_List.add(edgeRoleMapping);
        }
        return edgeRoleMapping_List;
    }

    public static ActionEvents viewToData_actionEvent(ActionEvent actionEvent) {
        ActionEvents actionEvents = new ActionEvents();
        actionEvents.setId(actionEvent.getId());
        actionEvents.setName(actionEvent.getName());
        actionEvents.setType(actionEvent.getType());
        actionEvents.setCrudActionEvents(null);
        actionEvents.setEdges(null);
        return actionEvents;
    }

    public static ClassStatus dataToView_classStatus(ClassStatuses classStatuses) {
        ClassStatus classStatus = new ClassStatus();
        classStatus.setId(classStatuses.getId());
        classStatus.setName(classStatuses.getName());
        return classStatus;
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
