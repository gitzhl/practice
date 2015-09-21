(function(){
	function regV(){
		var nick = $("#loginName").val();
		$.ajax({
			url:"/checkLoginToken",
			method:"post",
			data:{loginName:nick},
			dataType:"json",
			success:function(data){
				alert(data.responseText);
			}
		});
	}
});
