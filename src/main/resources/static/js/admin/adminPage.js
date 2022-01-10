$(function () {
	
	//=====================================테마라인
	
	$(".themeInsertBtn").on("click", function() {
		
		var themeName = $(".themeName").val();
		
	$.ajax({
			url: "/admin/themeInsert",
			type: "post",
			data: {"themeName":themeName},
			dataType: "text",
			success: function() {
				alert(themeName + "테마 방이 추가 되었습니다");
				location.reload();
			}
		})
	
	}) 
	
	
	
	$(".themedeleteBtn").on("click", function() {
		let themeNo = $(this).closest('tr').find(".themedeleteBtn").val();	
		
		if(confirm("삭제하시겠습니까?")){
			
			$.ajax({
				url: "/admin/themeDelete",
				type: "post",
				data: {"themeNo":themeNo},
				dataType: "text",
				success: function(data) {
					alert("삭제되었습니다.");
					location.reload();
				}
			})
			
			
		}else{
			
			alert("취소되었습니다.");
			
			
		}
		
	})
	
	
	$(".themeNo").change(function () {
		// 저렇게 쓸 필요없다. this.value쓰면 근처값 바로 땡겨준다.
		/*let themeNo = $(this).closest('option').find(".themeOptionChk").val();*/
		let themeNo = this.value
		
		$(".hiddenThemeNo").val(themeNo);
		
		$.ajax({
			url: "/admin/oneThemeCall",
			type: "post",
			data: {"themeNo":themeNo},
			dataType: "text",
			success: function(data) {
				$(".themeName").val(data);
				
			
			}
		})
		
	})
	
	$(".themeUpdateBtn").on("click", function () {
		let themeNo = $(".hiddenNo").val();
		let themeName = $(".themeName").val();
		
		$.ajax({
			url: "/admin/oneThemeUpdate",
			type: "post",
			data: {"themeNo":themeNo,
					"themeName":themeName
					},
			dataType: "text",
			success: function(data) {
				
				alert("수정이 완료되었습니다.");
				location.reload();
				
			
			}
		})
	})
	
	//=====================================테마라인
	
	//===================================== 이용시간 라인
	
	$(".playTimeInsertBtn").on("click", function() {
			
			let playTime = $(".playTime").val();
			alert(playTime);
			
		$.ajax({
				url: "/admin/playTimeInsert",
				type: "post",
				data: {"playTime":playTime},
				dataType: "text",
				success: function() {
					alert(playTime + "진행시간이 추가 되었습니다");
					location.reload();
				}
			})
		
		}) 
		
		
		$(".playTimeNo").change(function () {
		// 저렇게 쓸 필요없다. this.value쓰면 근처값 바로 땡겨준다.
		/*let themeNo = $(this).closest('option').find(".themeOptionChk").val();*/
		let playTimeNo = this.value
		
		$(".hiddenPlayTimeNo").val(playTimeNo);
		
		$.ajax({
			url: "/admin/onePlayTimeCall",
			type: "post",
			data: {"playTimeNo":playTimeNo},
			dataType: "text",
			success: function(data) {
				$(".playTime").val(data);
				
			
			}
		})
		
	})	
	
	$(".playTimeUpdateBtn").on("click", function () {
		let PlayTimeNo = $(".hiddenPlayTimeNo").val();
		let PlayTime = $(".playTime").val();
		
		$.ajax({
			url: "/admin/onePlayTimeUpdate",
			type: "post",
			data: {"PlayTimeNo":PlayTimeNo,
					"PlayTime":PlayTime
					},
			dataType: "text",
			success: function(data) {
				
				alert("수정이 완료되었습니다.");
				location.reload();
				
			
			}
		})
	})
		
		
		$(".playTimedeleteBtn").on("click", function() {
		let playTimeNo = $(this).closest('tr').find(".playTimedeleteBtn").val();	
		
		if(confirm("삭제하시겠습니까?")){
			
			$.ajax({
				url: "/admin/playTimeDelete",
				type: "post",
				data: {"playTimeNo":playTimeNo},
				dataType: "text",
				success: function(data) {
					alert("삭제되었습니다.");
					location.reload();
				}
			})
			
			
		}else{
			
			alert("취소되었습니다.");
			
			
		}
		
	})
	
	//===================================== 이용시간 라인
	
	//===============난이도
	
	$(".difficultyInsertBtn").on("click", function() {
		
		let difficulty = $(".difficulty").val();
		alert(difficulty);
		
	$.ajax({
			url: "/admin/difficultyInsert",
			type: "post",
			data: {"difficulty":difficulty},
			dataType: "text",
			success: function() {
				alert(difficulty + "난이도를 추가하였습니다.");
				location.reload();
			}
		})
	
	}) 
	
	
	$(".difficultydeleteBtn").on("click", function() {
		let difficultyNo = $(this).closest('tr').find(".difficultydeleteBtn").val();	
		
		alert(difficultyNo);
		
		if(confirm("삭제하시겠습니까?")){
			
			$.ajax({
				url: "/admin/difficultydelete",
				type: "post",
				data: {"difficultyNo":difficultyNo},
				dataType: "text",
				success: function(data) {
					alert("삭제되었습니다.");
					location.reload();
				}
			})
			
			
		}else{
			
			alert("취소되었습니다.");
			
			
		}
		
	})
	
	//===============난이도
	
	//============== 이용시간
	
	$(".operatingTimeInsertBtn").on("click", function() {
		
		var operatingTime = $(".operatingTime").val();
		
	$.ajax({
			url: "/admin/operatingInsert",
			type: "post",
			data: {"operatingTime":operatingTime},
			dataType: "text",
			success: function() {
				alert(operatingTime + "운영시간이 추가 되었습니다");
				location.reload();
			}
		})
	
	}) 
	
	
	
	$(".operatingTimedeleteBtn").on("click", function() {
		let operatingTimeNo = $(this).closest('tr').find(".operatingTimedeleteBtn").val();	
		
		if(confirm("삭제하시겠습니까?")){
			
			$.ajax({
				url: "/admin/operatingTimedelete",
				type: "post",
				data: {"operatingTimeNo":operatingTimeNo},
				dataType: "text",
				success: function(data) {
					alert("삭제되었습니다.");
					location.reload();
				}
			})
			
			
		}else{
			
			alert("취소되었습니다.");
			
			
		}
		
	})
	
	
	$(".operatingTimeNo").change(function () {
		// 저렇게 쓸 필요없다. this.value쓰면 근처값 바로 땡겨준다.
		
		let operatingTimeNo = this.value
		
		$(".hiddenOperatingTimeNo").val(operatingTimeNo);
		
		$.ajax({
			url: "/admin/oneOperatingTimeCall",
			type: "post",
			data: {"operatingTimeNo":operatingTimeNo},
			dataType: "text",
			success: function(data) {
				$(".operatingTime").val(data);
				
			
			}
		})
		
	})
	
	$(".operatingTimeUpdateBtn").on("click", function () {
		let operatingTimeNo = $(".hiddenOperatingTimeNo").val();
		let operatingTime = $(".operatingTime").val();
		
		$.ajax({
			url: "/admin/oneOperatingTimeUpdate",
			type: "post",
			data: {"operatingTimeNo":operatingTimeNo,
					"operatingTime":operatingTime
					},
			dataType: "text",
			success: function(data) {
				
				alert("수정이 완료되었습니다.");
				location.reload();
				
			
			}
		})
	})
	
	//============== 이용시간
	
	
})



