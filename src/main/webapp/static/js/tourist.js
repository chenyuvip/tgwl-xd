/**
 * 
 */
$(document).ready(function(){
	$("#queryOrderBtn").click(function(){
		var orderno = $("#orderno").val();
		if(orderno!="")
		{
			$("#orderForm").submit();
		}else
		{
			debugger
			$("#dialog-sm-content").html("请先输入订单号");
			$('#dialog-sm').modal('show')
		}
		
	}); 
});

