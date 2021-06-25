package dusanstankovic3611.cs230.controller;

import dusanstankovic3611.cs230.entity.Event;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventFacade extends AbstractFacade<Event> {

    @PersistenceContext(unitName = "CS230-PZ-3611PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventFacade() {
        super(Event.class);
    }
    
}
