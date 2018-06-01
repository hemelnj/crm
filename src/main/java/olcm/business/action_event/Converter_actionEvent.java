/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.action_event;

import olcm.data.action_event.ActionEvents;

/**
 *
 * @author Admin
 */
public class Converter_actionEvent {
    
    public static void dataToViewModelConverter(ActionEvents dataModel, ActionEvent viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setName(dataModel.getName());
        viewModel.setType(dataModel.getType());
    }
    
    public static void ViewToDataModelConverter(ActionEvents dataModel, ActionEvent viewModel) {
        dataModel.setName(viewModel.getName());
        dataModel.setType(viewModel.getType());
        dataModel.setCrudActionEvents(null);
        dataModel.setEdges(null);
    }
}
