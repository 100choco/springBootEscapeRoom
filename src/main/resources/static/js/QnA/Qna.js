$(function () {
	
	$(".qnaDeleteBtn").on("click", function (e) {
		if(confirm("삭제하시겠습니까?")){
			
			alert("삭제되었습니다.");
			
		}else{
			e.preventDefault();
			alert("아니오");
			
		}
		
	})
	
	
})




