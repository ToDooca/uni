package dusanstankovic3611.cs230.controller;

import dusanstankovic3611.cs230.entity.Problem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProblemFacade extends AbstractFacade<Problem> {

    @PersistenceContext(unitName = "CS230-PZ-3611PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProblemFacade() {
        super(Problem.class);
    }
    
}
