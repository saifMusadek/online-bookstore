package bookstore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null; // configures database connections
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebApplicationContextConfig.class};
//        return new Class[]{SecurityConfig.class,WebApplicationContextConfig.class};

    }

    protected String[] getServletMappings() {
        return new String[]{"/"}; //for all the requests it will go to dispatcher servlet
    }


}
