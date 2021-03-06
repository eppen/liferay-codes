<%@page import="com.service.service.newhireLocalServiceUtil"%>
<%@page import="com.service.model.newhire"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="javax.portlet.PortletURL"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects/>

<%

long newhireId = ParamUtil.getInteger(request, "newhireId");
newhire com=null;


com=newhireLocalServiceUtil.getnewhire(newhireId);
	
System.out.println("new hire Id before if..." + com.getNewhire_id());
	
	if (newhireId >= 01) 
	{
		
		System.out.print("...........newhireId .........."+newhireId);
		System.out.println("newhireId ####" + com.getNewhire_id());
	
	
	}
%>
<%
PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("jspPage", "/jsp/editnewhiredetails.jsp");
%>
<liferay-ui:header title="Edit New Hire Details" backLabel="&laquo; Back to search" backURL="<%=backURL.toString()%>" />

<portlet:actionURL var="action" name="submitNewHireDetails"></portlet:actionURL>

<aui:form action="${action}" method="post">



<aui:input type="text" name="Name" label="Name(Enter Maximum 100 Characters)" helpMessage="Please Enter Charcaters less than 100" value="<%=com.getNewhire_name()%>">
<aui:validator name="required"></aui:validator>

<aui:validator name="maxLength" errorMessage="Name should not be greater than 100 Characters">100</aui:validator>
                           <aui:validator name="custom"            
                                  errorMessage="Only Alphabets are allowed">
                                    function (val, fieldNode, ruleValue)
                                       {
                                           var result = true;
                                           var pattern=/[^a-z|^A-Z|^\s]/;
                                          var check = val.match(pattern);
                                          if(check!=null)
                                         {
                                            result=false;
                                          }
                                          val=$.trim(val);
                                         $("#<portlet:namespace />Name").val(val);
                                      return result;
                                        }
                            </aui:validator>
</aui:input><br><br>

<aui:input type="text" name="Designation" label="Designation(Enter Maximum 100 Characters)" helpMessage="Please Enter Charcaters less than 100" value="<%=com.getNewhire_designation()%>">
<aui:validator name="required" errorMessage="Designation is required"/>
<aui:validator name="maxLength" errorMessage="Designation should not be greater than 100 Characters">100</aui:validator>

                           <aui:validator name="custom"            
                                  errorMessage="Only Alphabets are allowed">
                                    function (val, fieldNode, ruleValue)
                                       {
                                           var result = true;
                                          <!--  var pattern=/[^a-z|^A-Z|^\s]/; -->
                                           <!-- var pattern=/(?=.*[a-zA-Z])[a-zA-Z0-9 +&,#_\-\/\.]+/; -->
                                           var re = /^[ A-Za-z0-9_@./#&+-]*$/
                                          var check = val.match(re);
                                          if(check!=null)
                                         {
                                            result=false;
                                          }
                                          val=$.trim(val);
                                         $("#<portlet:namespace />Designation").val(val);
                                      return result;
                                        }
                            </aui:validator>

</aui:input><br><br>

 <aui:input type="file" name="profileimage" label="Please Select Profile Image to upload" value="<%=com.getNewhire_profileimage()%>">
<aui:validator name="required" errorMessage="Profile Image is Required"/>
<aui:validator name="acceptFiles">'jpg,jpeg,png,tif,gif'</aui:validator>
</aui:input>

 <aui:input type="file" name="detailedimage" label="Please Select Detailed Image to upload" value="<%=com.getNewhire_detailedimage()%>">
<aui:validator name="required" errorMessage="Detail Image is Required"/>
<aui:validator name="acceptFiles">'jpg,jpeg,png,tif,gif'</aui:validator>
</aui:input>
 
<aui:input type="hidden" name="newhireId" value="<%=com.getNewhire_id()%>"></aui:input><br/>

<aui:button-row>
<aui:button type="submit" value="Submit" />
<aui:button type="reset" value="Reset" last="true"/>
</aui:button-row>

</aui:form>







