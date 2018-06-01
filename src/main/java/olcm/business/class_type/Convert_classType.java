/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_type;

import olcm.data.class_type.ClassTypes;

/**
 *
 * @author Admin
 */
public class Convert_classType {

    public static void dataToViewModelConverter(ClassTypes dataModel, ClassType viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setName(dataModel.getName());
    }

    public static void ViewToDataModelConverter(ClassTypes dataModel, ClassType viewModel) {
        dataModel.setId(viewModel.getId());
        dataModel.setName(viewModel.getName());
    }
}
