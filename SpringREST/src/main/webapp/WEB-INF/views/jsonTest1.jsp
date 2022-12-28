<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" 
		integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
		crossorigin="anonymous"></script>
<link rel="stylesheet" href="./bootstrapt/css/bootstrap.min.css" />
<script src="./bootstrapt/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>jsonTest1.jsp</h1>
	
	<input type="button" value="정보전송" id="btn1">

	<input type="text" name="id" id="id"> 

	<button id="testBtn" class="btn">모달 테스트</button>
  <!-- 회원가입 확인 Modal-->
	<div class="modal fade" id="testModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					</button>
					<h3 class="modal-title" id="exampleModalLabel">모달테스트</h5>
				</div>
				<div class="modal-body">내용 입력 !!</div>
				<div class="modal-footer">
					<a class="btn" id="modalY" href="#">예</a>
					<button class="btn" type="button" data-dismiss="modal">아니요</button>
				</div>
			</div>
		</div>
	</div>
	

		
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#btn1").click(function(){
			//alert(" 클릭 ! ");
			var member = {"id":$("#id").val(), "pw":"1234", "no":22, "tel":"010-2222-2222"};
			
			// JSON.stringify(객체) : 객체정보를 JSON 형태로 전달
			
			$.ajax({
				url:"/restPost",
				type:"post",
				contentType:"application/json",
				data: JSON.stringify(member),
				//data: member,
				success:function(){
					alert(" 성공 ! ");
					
				}
			});
			
			
		});
		
	});
</script>
<script type="text/javascript">
<script>
$('#testBtn').click(function(e){
	e.preventDefault();
	$('#testModal').modal("show");
});
</script>
	
  
</body>
</html>