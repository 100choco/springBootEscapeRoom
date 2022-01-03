$(function () {
	
//	alert("QnAInsert페이지");
	$(".qnaPWchk").change(function () {
		
	      if(this.checked){
	         $("input.qnaPassword").prop("disabled", false);
	         
	      }else {
	         $("input.qnaPassword").prop("disabled", true);
	         $("input.qnaPassword").val("");

	      }
	   });
	
	$(".qnaUpdateBtn").on("click", function () {
		
		var PBchk = $(".qnaPWchk").is(":checked");
		
		var Tchk = $(".qnaTitle").val();
		var Cchk = $(".qnaContents").val();
		var Pchk = $(".qnaPassword").val();
		alert(Tchk+"=========="+PBchk+"=========="+Cchk+"=========="+Pchk);
		if(PBchk == true){
			if(Tchk == ""){
				alert("작성자의 제목을 입력해 주세요");
			}else if(Cchk == ""){
				alert("작성글을 입력해 주세요");
			}else  if(Pchk == ""){
				alert("작성글의 비밀번호를 입력해 주세요");
			}else{
				alert("입력완료");
				$(".qnaUpdateBtn").prop('type', 'submit').submit();
			}
		}else if(PBchk == false){
			if(Nchk == ""){
				alert("작성자의 이름을 입력해 주세요");
			}else if(Tchk == ""){
				alert("작성자의 제목을 입력해 주세요");
			}else if(Cchk == ""){
				alert("작성글을 입력해 주세요");
			}else{
				alert("입력완료");
				$(".qnaUpdateBtn").prop('type', 'submit').submit();
			}
			
		}
			
		
		
		
	})
	
})




