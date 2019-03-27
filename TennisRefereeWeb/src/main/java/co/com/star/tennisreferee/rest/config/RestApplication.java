package co.com.star.tennisreferee.rest.config;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import co.com.star.tennisreferee.rest.services.TennisRefereeExceptionMapper;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("rest")
public class RestApplication extends Application {

    public RestApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"https"});
        beanConfig.setBasePath("TennisRefereeWeb/rest");
        beanConfig.setResourcePackage("co.com.star.tennisreferee.rest.services");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        resources.add(TennisRefereeExceptionMapper.class);
        return resources;
    }
}
