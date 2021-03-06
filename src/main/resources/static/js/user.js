let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	},
	
	save: function() {
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email    : $("#email").val()
		};
		
		$.ajax({
			type : "POST",
			url  : "/auth/joinProc",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8", //body 데이터가 어떤 타입인지
			dataType : "json" //응답 
		}).done(function(response) {
			alert("회원가입이 완료되었습니다.");
			location.href="/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 json으로 insert요청
	}
}

index.init();