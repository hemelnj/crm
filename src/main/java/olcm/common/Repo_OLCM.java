/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.common;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import olcm.core.AbstractRepository;

public class Repo_OLCM<T> extends AbstractRepository<T> {

    @PersistenceContext(unitName ="GLPU")
    private EntityManager em;

    public Repo_OLCM(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
