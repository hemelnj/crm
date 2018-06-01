/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.common;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Entity;
import olcm.business.class_type.Bean_classType;
import olcm.business.class_type.ClassType;
import org.reflections.Reflections;

/**
 *
 * @author MSI
 */
@Stateless
public class Bean_ObjectDefinitionAndFieldRecording {

    @Inject
    Bean_ObjectDefinition bean_ObjectDefinition;
    @Inject
    Bean_classType bean_classType;

    public String RecreateObjectDefinition() throws IllegalArgumentException, IllegalAccessException {
        Reflections reflection = new Reflections("crm.data");
        Set<Class<?>> annotated = reflection.getTypesAnnotatedWith(Entity.class);
        List<Class> list = new ArrayList();
        list.addAll(annotated);
        try {
            for (int i = 0; i < list.size(); i++) {
                Class classObject = list.get(i);
                List< java.lang.reflect.Field> privateFields = new ArrayList<>();
                List<DataField> dataFields = new ArrayList<>();
                java.lang.reflect.Field[] allFields = classObject.getDeclaredFields();

                String className = classObject.getSimpleName();
                ObjectDefinition objectDefinition = new ObjectDefinition();

                for (java.lang.reflect.Field field : allFields) {
                    if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        DataField dataField = new DataField();
                        String fieldName = field.getName();
                        if (fieldName.charAt(0) == 'm') {
                            fieldName = fieldName.substring(1);
                        }
                        dataField.setmName(fieldName);
                        dataField.setmType(field.getType().getSimpleName());;
                        dataFields.add(dataField);
                        privateFields.add(field);
                    }
                }

                objectDefinition.setmName(className);
                objectDefinition.setFields(dataFields);
                bean_ObjectDefinition.save(objectDefinition);
                ClassType classType = new ClassType();
                classType.setId(objectDefinition.getmId());
                classType.setName(objectDefinition.getmName());
                bean_classType.save(classType);
            }
            return "Done";
        } catch (Exception e) {
            return "Sorry! Wasn't Possible";
        }

    }
}
