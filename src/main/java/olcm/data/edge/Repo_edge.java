/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.data.edge;

import java.text.ParseException;
import java.util.List;
import olcm.data.edge_role_mapping.*;
import olcm.common.Repo_OLCM;

/**
 *
 * @author Admin
 */
public class Repo_edge extends Repo_OLCM<Edges> {

    public Repo_edge() {
        super(Edges.class);
    }

    public List<Edges> allEdgesByClassType(long id) throws ParseException {
        List<Edges> allEdgesByClassType = null;
        try {
            allEdgesByClassType = getEntityManager()
                    .createNamedQuery("edge.allEdgesByClassType")
                    .setParameter("id", id)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return allEdgesByClassType;
    }
    


}
