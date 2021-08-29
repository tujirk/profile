<%@page import="tujiorg.profile.db.entities.ProjectsCo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<div style="padding-bottom: 40px;padding-left: 50px;text-align: center;">
	<%
		List<ProjectsCo> prjCoList = (List<ProjectsCo>)request.getAttribute("ProjectsCo");
		int x=0;
		for(ProjectsCo prjCo : prjCoList) {
			%>
			<div class="row row-strip">
				<div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 glow-box-coop-comm glow-box-left" style="">
					<%
					Date endDate = prjCo.getEndDate();
					SimpleDateFormat sf= new SimpleDateFormat("MMM, yyyy");
					String strEndDate= endDate==null?"Present":sf.format(endDate);
					out.print(sf.format(prjCo.getStartDate())+" - "+ strEndDate);
					out.print("<br>"+prjCo.getTitle());
					%>
				</div>
				<div class="col-lg-8 col-md-7 col-sm-12 col-xs-12 glow-box-coop-comm glow-box-right" style="">
					<span class="prj-heading">Description: </span> <% out.print(prjCo.getDescription());%><br>
					<span class="prj-heading">Responsibilities: </span><br> <% String[] responsibilyArr=prjCo.getResponsibility().split("\\n");%>
						<ul>
						<%for(String responsibily : responsibilyArr) {
							%>
							<li><%= responsibily%>
							<%
						}
					%>
					</ul>
					<span class="prj-heading">Technologies: </span> <% out.print(prjCo.getTechnology());%><br>
					<%if(prjCo.getMethdology()!=null) {
						out.print("<span class='prj-heading'>Methodology: </span>"+prjCo.getMethdology());
					}
					%>
				</div>
			</div>
			<%
			x++;
		}
	%>
</div>