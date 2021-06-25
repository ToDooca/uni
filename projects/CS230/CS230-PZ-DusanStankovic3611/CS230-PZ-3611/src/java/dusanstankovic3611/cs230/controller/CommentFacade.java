package dusanstankovic3611.cs230.controller;

import dusanstankovic3611.cs230.entity.Comment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CommentFacade extends AbstractFacade<Comment> {

    @PersistenceContext(unitName = "CS230-PZ-3611PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }
    
}
