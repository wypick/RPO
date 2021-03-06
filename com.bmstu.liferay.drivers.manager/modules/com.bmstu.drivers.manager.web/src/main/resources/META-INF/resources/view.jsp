<%@include file="/init.jsp"%>

<%
	Driver traccarDriver = null;
%>

<aui:button-row cssClass="traccar-buttons">

	<portlet:renderURL var="addDriverURL">
		<portlet:param name="mvcPath" value="/edit_driver.jsp" />
	</portlet:renderURL>

	<aui:button onClick="<%=addDriverURL.toString()%>" value="Add Driver"></aui:button>

</aui:button-row>

<portlet:actionURL name="deleteDriver" var="deleteDriverURL"/>

<liferay-ui:search-container
	total="<%=DriverLocalServiceUtil.getDriversCount()%>">
	<liferay-ui:search-container-results
		results="<%=DriverLocalServiceUtil.getDrivers(searchContainer.getStart(), searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.bmstu.drivers.manager.core.model.Driver"
		modelVar="driver">

		<liferay-ui:search-container-column-text property="driverId" />

		<liferay-ui:search-container-column-text property="driverName" />
		
		<liferay-ui:search-container-column-text property="description" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<aui:form action="<%=deleteDriverURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=traccarDriver%>"
		model="<%=Driver.class%>" />

	<aui:fieldset>

		<aui:input name="driverId" type="clear"/>

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit" value="Delete"/>

	</aui:button-row>
</aui:form>