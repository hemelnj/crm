/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.role;

import olcm.data.role.Roles;

/**
 *
 * @author Admin
 */
public class Converter_role {

    public static void dataToViewModelConverter(Roles dataModel, Role viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setName(dataModel.getName());


    }

    public static void ViewToDataModelConverter(Roles dataModel, Role viewModel) {
        dataModel.setName(viewModel.getName());
        dataModel.setCrudActionEvents(null);
        dataModel.setEdgeRolMappings(null);
    }

}
