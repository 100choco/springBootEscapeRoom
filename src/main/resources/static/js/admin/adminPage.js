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
		
		$(".hiddenNo").val(themeNo);
		
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
		
	//===================================== 이용시간 라인
	
})



