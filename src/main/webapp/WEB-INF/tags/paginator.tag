<%@ attribute name="count"  required="true" rtexprvalue="true" type="java.lang.Integer"%>
<%@ attribute name="step"  required="true" rtexprvalue="true" type="java.lang.Integer"%>
<%@ attribute name="urlprefix"  required="true" rtexprvalue="true" type="java.lang.String"%>
<%
    for (int i = 0; i <= count/step; i++) {
        out.println(String.format("&nbsp<a href='%s%d'>%d</a>",urlprefix,i*step,i+1));
    }
%>
