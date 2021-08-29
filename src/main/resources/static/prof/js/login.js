var contextPath = window.location.origin; 

function toggleForm(toLogin, time) {
	if(toLogin) {
		$("form:last").hide(time);
		$("#divLogin").removeClass("inactive-form-tab");
		$("#divLogin").addClass("active-form-tab");
		$("#divReg").removeClass("active-form-tab");
		$("#divReg").addClass("inactive-form-tab");
		$("form:first").show(time);
	} else {
		$("form:last").show(time);
		$("#divLogin").removeClass("active-form-tab");
		$("#divLogin").addClass("inactive-form-tab");
		$("#divReg").removeClass("inactive-form-tab");
		$("#divReg").addClass("active-form-tab");
		$("form:first").hide(time);
	}
}
function isUserExist() {
	var userId=$("#txtUserId").val();
	setLabelMsg("lblUserId", false, "Please wait! We are checking User Id's availability");
	if(userId!==null && userId!="") {
		$("#btnRegister").hide();
		var pageUrl= contextPath+"/tujiorg_tuji/isUserExist";
		$.ajax({
			url: pageUrl,
			type:"post",
			data: {
				"userId":userId
			},
			success: function(result) {
				if(!result) {
					setLabelMsg("lblUserId", true, "You can take this User Id");
					$("#btnRegister").show();
				} else {
					setLabelMsg("lblUserId", false, "This id has taken, please try a different.");
				}
			},
			error: function(result) {
				console.log("not working. ERROR ::: "+err);
				$("#btnRegister").show();
			}
		});
	} else {
		setLabelMsg("lblUserId", false, "Please enter a User Id");
	}
}

function validateUser() {
	if($("#txtName").val()=="") {
		setLabelMsg("lblName", false, "Please enter your name")
		return false;
	}
	if($("#txtUserId").val()=="") {
		setLabelMsg("lblUserId", false, "Please enter a user id")
		return false;
	}
	var pass=$("#txtPass").val();
	var rePass=$("#txtRePass").val();
	if(pass=="") {
		setLabelMsg("lblPass", false, "Please enter a password")
		return false;
	}
	if(pass!=rePass) {
		setLabelMsg("lblRePass", false, "Password not match")
		return false;
	}
	return true
}

function registerUser() {
	if(validateUser() ) {
		$("#btnRegister").attr("disabled", true);
		$("#formRegister")[0].submit();
	}
}

function removeError(e) {
	e.nextElementSibling.innerHTML="";
}

function setLabelMsg(eleId,isSuccess, msg) {
	if(isSuccess) {
		$("#"+eleId).removeClass();
		$("#"+eleId).addClass("success-label")
		$("#"+eleId).text(msg);
	} else {
		$("#"+eleId).removeClass();
		$("#"+eleId).addClass("error-label")
		$("#"+eleId).text(msg);
	}
	
}