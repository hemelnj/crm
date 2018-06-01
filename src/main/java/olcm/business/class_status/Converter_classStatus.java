/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_status;

import olcm.data.class_status.ClassStatuses;

/**
 *
 * @author Admin
 */
public class Converter_classStatus {

    public static void dataToViewModelConverter(ClassStatuses dataModel, ClassStatus viewModel) {
        viewModel.setId(dataModel.getId());
        viewModel.setName(dataModel.getName());
    }

    public static void ViewToDataModelConverter(ClassStatuses dataModel, ClassStatus viewModel) {
        dataModel.setName(viewModel.getName());
    }

}
