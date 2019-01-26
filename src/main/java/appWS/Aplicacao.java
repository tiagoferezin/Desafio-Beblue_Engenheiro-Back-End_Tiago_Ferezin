/**
 * 
 */
package appWS;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Tiago Ferezin Data: 25/01/2019
 */
public class Aplicacao implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		String localConfig = "appWS.config";
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation(localConfig);

		Dynamic appServlet = servletContext.addServlet("appServlet",
				new DispatcherServlet(webApplicationContext));

		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");

		servletContext.addListener(new ContextLoaderListener(
				webApplicationContext));

		FilterRegistration.Dynamic filter = servletContext.addFilter(
				"openEntityManagerFilter", buildOpenEntityManagerFilter());

		filter.addMappingForUrlPatterns(getDispatcherTypes(), false, "/*");
	}

	private OpenEntityManagerInViewFilter buildOpenEntityManagerFilter() {
		OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
		openEntityManagerInViewFilter
				.setEntityManagerFactoryBeanName("entityManagerFactory");
		return openEntityManagerInViewFilter;
	}

	private EnumSet<DispatcherType> getDispatcherTypes() {
		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD,
				DispatcherType.INCLUDE, DispatcherType.ASYNC);
	}

}
