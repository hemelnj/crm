/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.role;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.class_type.ClassTypes;
import olcm.data.role.Repo_role;
import olcm.data.role.Roles;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_role {

    @Inject
    Repo_role repo_role;

    public Boolean save(Role dmRole) {
        Roles roles = new Roles();
        try {
            Converter_role.ViewToDataModelConverter(roles, dmRole);
            repo_role.create(roles);
            return true;
        } catch (Exception e) {
            return false;
        }

    } 
    
      public Boolean edit(Role dmRole) {
     Roles roles = new Roles();
        try {
           Converter_role.ViewToDataModelConverter(roles, dmRole);
           repo_role.update(roles);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

     public Boolean saveList(List<Role> roles){
         try{ 
             for(int i=0;i<roles.size();i++){
                 save(roles.get(i));
             }
             return true;
         } catch (Exception e) {
            return false;
        }
     }

    public Role getById(Object Id) {
        Roles roles = new Roles();
        roles = repo_role.read(Id);
        Role role = new Role();
        Converter_role.dataToViewModelConverter(roles, role);
        return role;
    }

    public List<Role> getAll() {
        List<Role> allRole = new ArrayList();
        List<Roles> allRoles = repo_role.readAll();
        for (int i = 0; i < allRoles.size(); i++) {
            Role role = new Role();
            Converter_role.dataToViewModelConverter(allRoles.get(i), role);
            allRole.add(role);
        }
        return allRole;
    }

    public List<Role> getAllRoleByEdge(long id) throws ParseException {
        List<Role> allRole = new ArrayList();
        List<Roles> allRoles = repo_role.getAllrolesByEdge(id);
        for (int i = 0; i < allRoles.size(); i++) {
            Role role = new Role();
            Converter_role.dataToViewModelConverter(allRoles.get(i), role);
            allRole.add(role);
        }
        return allRole;
    }

}
