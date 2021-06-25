package dusanstankovic3611.cs230.rest.service;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(dusanstankovic3611.cs230.rest.service.EventFacadeREST.class);
        resources.add(dusanstankovic3611.cs230.rest.service.NewsFacadeREST.class);
        resources.add(dusanstankovic3611.cs230.rest.service.PlaceFacadeREST.class);
        resources.add(dusanstankovic3611.cs230.rest.service.ProblemFacadeREST.class);
        resources.add(dusanstankovic3611.cs230.rest.service.RoleFacadeREST.class);
        resources.add(dusanstankovic3611.cs230.rest.service.UserFacadeREST.class);
    }
    
}
