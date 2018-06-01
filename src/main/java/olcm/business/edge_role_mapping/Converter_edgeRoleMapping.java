/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge_role_mapping;

import olcm.business.edge.Edge;
import olcm.common.DataConverter;
import olcm.data.edge.Edges;
import olcm.data.edge_role_mapping.EdgeRoleMappings;

/**
 *
 * @author Admin
 */
public class Converter_edgeRoleMapping {

    public static void dataToViewModelConverter(EdgeRoleMappings dataModel, EdgeRoleMapping viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setEdge(DataConverter.dataToView_edge(dataModel.getEdge()));
        viewModel.setRole(DataConverter.dataToView_role(dataModel.getRole()));
    }

    public static void ViewToDataModelConverter(EdgeRoleMappings dataModel, EdgeRoleMapping viewModel) {
        dataModel.setEdge(DataConverter.viewToData_edge(viewModel.getEdge()));
        dataModel.setRole(DataConverter.viewToData_role(viewModel.getRole()));
    }
}
