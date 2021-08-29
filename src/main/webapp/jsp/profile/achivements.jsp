
<%@page import="tujiorg.profile.db.entities.Awards"%>
<%@page import="java.util.List"%>
<div class="row" style="padding: 30px;padding-bottom: 0px;" id="divRowAwards">
	<%
	List<Awards> awardsList=(List<Awards>)request.getAttribute("Awards");
	if(awardsList!=null) {
		int i=0;
		for(Awards award:awardsList) {
			%>
			<div class="col-xl-3 col-lg-3 col-md-4 col-sm-12" style="padding-bottom: 30px;">
				<div class="card" style="display:grid; align-items:center; min-height:400px; background: transparent; color: #ffebeb;box-shadow: 0px 0px 2px #fff,0px 0px 2px aliceblue,inset 0px 0px 5px #fe9696,0px 0px 5px #ff3434,0px 0px 2px aliceblue,0px 0px 5px aliceblue;">
				
					<div style="padding: 10px;">
						<div>
							<img alt="Logo" src="<%= award.getImgUrl()%>" class="card-img-top"  style="cursor: pointer;" data-toggle="modal" data-target="#divAwardModal"  onclick="setupImgModal('<%= award.getImgUrl()%>')">
						</div>
					</div>
					<div style="display: block;width: 100%;height: 100%;position: absolute;z-index: -1;filter: blur(50px);" id="divImgBack<%= i%>"></div>
				
				</div>
			</div>
			<%
			i++;
		}
	}
	%>
	<div class="modal fade" id="divAwardModal">
		
		<div class="modal-dialog" >
			<div class="modal-content">
				<div class="">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				 <div class="modal-body">
				 	<img alt="Loding Image..." src="" id="imgModalAward" style="width: 100%;">
			      </div>
			      <div class="modal-footer">
			      	<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      	</div>
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
	var gColorCnt=0;
	
		function setupImgModal(url) {
			$("#imgModalAward").attr("src", url)
		}
		
		$(document).ready(function() {
			setInterval(changeCardBackground, 500);
		});
		
		function changeCardBackground() {
			var colLen=$("#divRowAwards").children().length-1;
			for(var x=0;x<colLen;x++) {
				gColorCnt++;
				if(gColorCnt>20) { gColorCnt=0; }
				var ramColor;
				switch(gColorCnt) {
				case 0 :  ramColor="#ED5D5D1F"; break;
				case 1 :  ramColor="#ED8C5D1F"; break;
				case 2 :  ramColor="#EDA15D1F"; break;
				case 3 :  ramColor="#EDC25D1F"; break;
				case 4 :  ramColor="#EDD05D1F"; break;
				
				case 5 :  ramColor="#EDEB5D1F"; break;
				case 6 :  ramColor="#B9ED5D1F"; break;
				case 7 :  ramColor="#7CED5D1F"; break;
				case 8 :  ramColor="#5DED8F1F"; break;
				
				case 9 :  ramColor="#5DEDCB1F"; break;
				case 10 :  ramColor="#5DD9ED1F"; break;
				case 11 :  ramColor="#5DBEED1F"; break;
				case 12 :  ramColor="#5D95ED1F"; break;
				
				case 13 :  ramColor="#5D6DED1F"; break;
				case 14 :  ramColor="#765DED1F"; break;
				case 15 :  ramColor="#985DED1F"; break;
				case 16 :  ramColor="#CE5DED1F"; break;
				
				case 17 :  ramColor="#ED5DD71F"; break;
				case 18 :  ramColor="#ED5DA71F"; break;
				case 19 :  ramColor="#ED5D7F1F"; break;
				case 20 :  ramColor="#ED5D5D1F"; break;
				
				default: ramColor="#F2F4F71F"; break;
				}
				$("#divImgBack"+x).css("background",ramColor);
			}
		}
	</script>
</div>