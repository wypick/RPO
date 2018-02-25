<%@include file="/init.jsp"%>

<%
	Driver device = null;
%>

<portlet:renderURL var="viewURL">

	<portlet:param name="mvcPath" value="/view.jsp" />

</portlet:renderURL>

<portlet:actionURL name="addDriver" var="addDriverURL" />

<aui:form action="<%=addDriverURL%>" name="<portlet:namespace />fm">

<aui:model-context bean="<%=device%>"
		model="<%=Driver.class%>" />

	<aui:fieldset>

		<aui:input name="driverId" />
		<aui:input name="driverName" />
		<aui:input name="description" />

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>" />

	</aui:button-row>
</aui:form>