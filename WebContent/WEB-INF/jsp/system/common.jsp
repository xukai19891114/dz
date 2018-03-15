<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	System.out.println(basePath);
	request.setAttribute("basePath", basePath);
%>