<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@ include file ="/jsp/profile/cssAndScript.jsp" %>
		<title>My Profile</title>
	</head>
	<body>
		<script type="text/javascript">
			function setActiveTab(tabId) {
				$(".nav-link").removeClass("active-link");
				$("#"+tabId).addClass("active-link");
			}
		</script>
		<div class="container">
			<div class="glow-box1">
				<div class="row" style="text-align: center;">
					<div class="col-sm-12 glow-text1">
						Rishabh Kabra
					</div>
					<div class="col-sm-12 glow-text2">
						Welcomes You!
					</div>
				</div>
			</div>
			
			<div class="glow-box2" style="margin-bottom: 200px;">
				<%@ include file="/jsp/profile/navbar.jsp" %>
				
				<div class="row" style="background: transparent;">
					<div class="col">
						<%if(request.getAttribute("pageVal")=="0") { %>
							<script type="text/javascript"> setActiveTab("navLiAbout"); </script>
							<%@ include file="/jsp/profile/about.jsp" %>
						<%}%>
						<%if(request.getAttribute("pageVal")=="1") { %>
							<script type="text/javascript"> setActiveTab("navLiProjects"); </script>
							<%@ include file="/jsp/profile/projects/hobby.jsp" %>
						<%}%>
						<%if(request.getAttribute("pageVal")=="2") { %>
							<script type="text/javascript"> setActiveTab("navLiProjects"); </script>
							<%@ include file="/jsp/profile/projects/cooperate.jsp" %>
						<%}%>
						<%if(request.getAttribute("pageVal")=="3") { %>
							<script type="text/javascript"> setActiveTab("navLiAchive"); </script>
							<%@ include file="/jsp/profile/achivements.jsp" %>
						<%}%>
						<%if(request.getAttribute("pageVal")=="4") { %>
							<script type="text/javascript"> setActiveTab("navLiQual"); </script>
							<%@ include file="/jsp/profile/qualifications.jsp" %>
						<%}%>
					</div>
				</div>
				
			</div>
			<%@ include file="/jsp/profile/footer.jsp" %>
		</div>
		
	</body>
</html>