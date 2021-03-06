package com.bmstu.drivers.manager.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bmstu.drivers.manager.web.constants.DriverManagerPortletKeys;
import com.bmstu.drivers.manager.core.service.DriverLocalService;
import com.bmstu.drivers.manager.core.model.Driver;

import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author Tatiana
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DriverManager",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DriverManagerPortletKeys.Web_module,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DriverManagerPortlet extends MVCPortlet {
	
	private DriverLocalService service;

	public void addDriver(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Driver.class.getName(), request);

		long driverId = ParamUtil.getLong(request, "driverId");
		String driverName = ParamUtil.getString(request, "driverName");
		String description = ParamUtil.getString(request, "description");
		
		try {
			service.addDriver(driverId, driverName, description, serviceContext);
			SessionMessages.add(request, "Driver Added");
		} catch (Exception e) {
			System.out.println(e);
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/edit_driver.jsp");
		}
	}
	
	public void deleteDriver(ActionRequest request, ActionResponse response) throws PortalException {
		long id = ParamUtil.getLong(request, "driverId");
		service.deleteDriver(id);
	}
	/**
	 * 
	 * Binds driver service.
	 * 
	 */
	@Reference(unbind = "-")
	protected void bindDriverService(DriverLocalService service) {
		this.service = service;
	}
	
}