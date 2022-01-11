$(function () {
	
	
	$(".themeNo").on("click", function () {
		// 저렇게 쓸 필요없다. this.value쓰면 근처값 바로 땡겨준다.
		
		let themeNo = this.value
		
		$(".hiddenRoomName").val(themeNo);
		
		$.ajax({
			url: "/admin/oneThemeCall",
			type: "post",
			data: {"themeNo":themeNo},
			dataType: "text",
			success: function(data) {
				$(".hiddenRoomName").val(data);
				
			
			}
		})
		
		
		$(".createRoomBtn").on("click", function () {
			
			alert("등록되었습니다.");
			$(".createRoomForm").submit();
			
		})
		
	})
	
	
	
	
})



