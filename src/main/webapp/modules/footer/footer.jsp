<jsp:directive.page import="java.util.Calendar"/>
<%
Calendar calendar = Calendar.getInstance();
 %>
<html>
	<body>
		<div class="row">
		 	<div class="container">
				<div class="col-md-6 col-md-offset-6">
					<div class="copyright">&copy; <%=calendar.get(java.util.Calendar.YEAR)%> Copyrighted</div>
				</div>
			</div>
		</div>
	</body>
</html>