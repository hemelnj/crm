/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.common;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author MSI
 */
@Stateless
public class Bean_ObjectDefinition {

    @Inject
    Repo_ObjectDefinition repo;

    public ObjectDefinition getById(Object Id) {
        return repo.read(Id);
    }

    public Boolean save(ObjectDefinition entity) {
        try {          
            repo.create(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

      public List<ObjectDefinition> getAll() {
        List<ObjectDefinition> allClassTypes = repo.readAll();
        return allClassTypes;
    }
    public Boolean saveList(List<ObjectDefinition> entities) {
        try {
            for (int i = 0; i < entities.size(); i++) {
                save(entities.get(i));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
