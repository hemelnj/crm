/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_type;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.class_type.ClassTypes;
import olcm.data.class_type.Repo_classType;

/**
 *
 * @author Admin
 */
@Stateless

public class Bean_classType {

    @Inject
    Repo_classType repo_classType;

    public Boolean save(ClassType object) {
        ClassTypes classTypes = new ClassTypes();
        try {
            Convert_classType.ViewToDataModelConverter(classTypes, object);
            repo_classType.create(classTypes);
            ClassType classType = new ClassType();
            Convert_classType.dataToViewModelConverter(classTypes, classType);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean saveList(List<ClassType> classTypes){
       try{
        for(int i=0;i<classTypes.size();i++){
            save(classTypes.get(i));
        }   
        return true;
       
       } catch (Exception e) {
            return false;
        }
    }
    public List<ClassType> getAll() {
        List<ClassType> allClassType = new ArrayList();
        List<ClassTypes> allClassTypes = repo_classType.readAll();
        for (int i = 0; i < allClassTypes.size(); i++) {
            ClassType classType = new ClassType();
            Convert_classType.dataToViewModelConverter(allClassTypes.get(i), classType);
            allClassType.add(classType);
        }
        return allClassType;
    }

    public ClassType getById(Object id) {
        ClassTypes classTypes = repo_classType.read(id);
        ClassType classType = new ClassType();
        Convert_classType.dataToViewModelConverter(classTypes, classType);
        return classType;
    }

    public Boolean edit(ClassType classType) {
        ClassTypes classTypes = new ClassTypes();
        try {
            Convert_classType.ViewToDataModelConverter(classTypes, classType);
            repo_classType.update(classTypes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
