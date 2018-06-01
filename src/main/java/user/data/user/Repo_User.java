/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.data.user;

import java.text.ParseException;
import olcm.data.role.Roles;
import user.common.Repo_auth;

/**
 *
 * @author shamim
 */
public class Repo_User extends Repo_auth<Roles> {

    public Repo_User() {
        super(Roles.class);
    }
public Long getRoleId(String username,String password) throws ParseException {
        Long roleId=null;
        try {
            roleId = (Long) getEntityManager()
                    .createNamedQuery("user.getroleId")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception exp) {
            throw exp;
        }
        return roleId;
    }
}
