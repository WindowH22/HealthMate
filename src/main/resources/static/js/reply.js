// postObject 객체 선언 
let replyObject = {

	// init() 함수 선언 
	init: function() {
		let _this = this;

		// "#btn-save" 버튼에 "click" 이벤트가 발생하면 insertPost() 함수를 호출한다. 
		$("#btn-reply-insert").on("click", () => {
			_this.insertReply();
		});

		
		
	},

	insertReply: function() {
		alert("1:1 문의 등록 요청됨");

		let data = {
			postId: $("#postId").val(),
			content: $("#reply-content").val()
		}
		console.log(data.postId);

		// Ajax를 이용한 비동기 호출
		$.ajax({
			type: "POST", // 요청 방식
			url: `/post/${data.postId}/insertReply`, // 요청 path
			data: JSON.stringify(data), // user Object를 JSON으로 변환
			// HTTP 바디에 설정되는 데이터의 마임타입설정 
			contentType: "application/json; charset=utf-8"
			// done() : 요청 처리에 성공했을 때 실행될 코드를 작성한다.
			// 응답으로 들어온 JSON 데이터를 response로 받는다. 
		}).done(function(response){
			alert(response);
			location =`/post/get/${data.postId}`;
		}).fail(function (error) {
            alert(JSON.stringify(error));
        });
        

	},

	

}

// replyObject 객체의 init() 함수 호출. 
replyObject.init();
