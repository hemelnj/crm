/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import olcm.common.DataConverter;
import olcm.data.edge.Edges;

/**
 *
 * @author Admin
 */
public class Converter_edge {

    public static void dataToViewModelConverter(Edges dataModel, Edge viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setActionEvent(DataConverter.dataToView_actionEvent(dataModel.getActionEvent()));
        viewModel.setClassType(DataConverter.dataToView_classType(dataModel.getClassType()));
        viewModel.setStatus(DataConverter.dataToView_classStatus(dataModel.getStatus()));
        viewModel.setEndStatus(DataConverter.dataToView_classStatus(dataModel.getEndStatus()));
        viewModel.setEdgeRolMappings(null);
    }

    public static void dataToViewModelConverter_Detailed(Edges dataModel, Edge viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setActionEvent(DataConverter.dataToView_actionEvent(dataModel.getActionEvent()));
        viewModel.setClassType(DataConverter.dataToView_classType(dataModel.getClassType()));
        viewModel.setStatus(DataConverter.dataToView_classStatus(dataModel.getStatus()));
        viewModel.setEndStatus(DataConverter.dataToView_classStatus(dataModel.getEndStatus()));
        viewModel.setEdgeRolMappings(DataConverter.dataToView_edgeRoleMapping_List(dataModel.getEdgeRolMappings()));
    }


    public static void ViewToDataModelConverter(Edges dataModel, Edge viewModel) {
        dataModel.setId(viewModel.getId());
        dataModel.setActionEvent(DataConverter.viewToData_actionEvent(viewModel.getActionEvent()));
        dataModel.setClassType(DataConverter.viewToData_classType(viewModel.getClassType()));
        dataModel.setStatus(DataConverter.viewToData_classStatus(viewModel.getStatus()));
        dataModel.setEndStatus(DataConverter.viewToData_classStatus(viewModel.getEndStatus()));
        dataModel.setEdgeRolMappings(null);

    }

}
