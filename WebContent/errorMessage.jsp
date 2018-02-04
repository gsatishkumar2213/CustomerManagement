<div style="color: red">
	<%! String message = ""; %>
	<%if(request.getAttribute("message") !=null){
		message = String.valueOf(request.getAttribute("message"));
	}
	
	%>
	<p><%= message %></p>

</div>