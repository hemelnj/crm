/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.role;

import java.text.ParseException;
import java.util.List;
import olcm.common.Repo_OLCM;

/**
 *
 * @author Admin
 */
public class Repo_role extends Repo_OLCM<Roles> {

    public Repo_role() {
        super(Roles.class);
    }

    public List<Roles> getAllrolesByEdge(long id) throws ParseException {
        List<Roles> getAllrolesByEdge = null;
        try {
            getAllrolesByEdge = getEntityManager()
                    .createNamedQuery("role.roleByEdge")
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return getAllrolesByEdge;
    }
}
