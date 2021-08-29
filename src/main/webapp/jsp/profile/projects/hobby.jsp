<%@page import="tujiorg.profile.db.entities.ProjectsHo"%>
<%@page import="java.util.List"%>
<div class="row" style="padding: 30px;padding-bottom: 0px;">
		<%
		List<ProjectsHo> projectsHoList = (List<ProjectsHo>) request.getAttribute("ProjectsHo");
		if(projectsHoList!=null) {
			for(ProjectsHo projectsHo: projectsHoList) {
				%>
			<div class="col-xl-3 col-lg-3 col-md-4 col-sm-12" style="padding-bottom: 30px;">
				<div class="card" style="min-height:100%; background: transparent; color: #ffebeb;box-shadow: 0px 0px 2px #fff,0px 0px 2px aliceblue,inset 0px 0px 5px #fe9696,0px 0px 5px #ff3434,0px 0px 2px aliceblue,0px 0px 5px aliceblue;">
					<div style="padding: 10px;">
						<div style="width: 100%;height: 250px;overflow: hidden; border-radius: 10%;">
							<img alt="Logo" src="<%= projectsHo.getLogoUrl()%>" class="card-img-top" style="height: 100%">
						</div>
					</div>
					<div class="card-body" style="background: transparent;">
						<h4 class="card-title"><%= projectsHo.getTitle()%></h4>
						<p class="card-text"><%= projectsHo.getDescription()%></p>
						<p class="card-text"><span style="font-weight: bold;">Technologies: </span><%= projectsHo.getTechnology()%></p>
						<a href="<%= projectsHo.getUrl()%>" class="btn" style="border: 2px solid #ffebeb;color: #ffebeb; bottom: 20px;">More</a>
					</div>
				</div>
			</div>
			<%}
		}
		%>
</div>