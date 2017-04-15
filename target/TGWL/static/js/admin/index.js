/**
 * 
 */
$(document).ready(function(){
	$.fn.datetimepicker.dates['zh-CN'] = {
			days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
			daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
			daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
			months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
			monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
			today: "今天",
			suffix: [],
			meridiem: ["上午", "下午"]
	};
	$('#datetimepicker').datetimepicker({
		language: 'zh-CN',
        pickTime: true,
        showMeridian: true,
        todayBtn: true,
        autoclose: true,
        format:"yyyy-mm-dd hh:ii"
	});
	$('#datetimepicker2').datetimepicker({
		language: 'zh-CN',
        pickTime: true,
        showMeridian: true,
        todayBtn: true,
        autoclose: true,
        format:"yyyy-mm-dd hh:ii"
	});
	
	$("#simpleOrderBtn").unbind( "click" ).bind("click", function(){
		var orderno = $("#orderno").val();
		var datetimepicker = $("#datetimepicker").val();
		
		if( orderno=="" || datetimepicker=="" )
		{
			alert("日期或者订单号都不能为空");
			return false;
		}
		
		$.ajax({
		   type: "GET",
		   url: "doSimpleOrder.json",
		   data: "orderno="+orderno+"&datetimepicker="+datetimepicker,
		   dataType : "json",
		   success: function(msg){
		     if(msg.errorCode==1)
		     {
		    	 alert("录入成功");
		     }else
		     {
		    	 alert("录入失败");
		     }
		   }
		});
	});
	
	$("#orderListBtn").unbind( "click" ).bind("click", function(){
		var orderExcel = $("#orderExcel").val();
		if(orderExcel=="")
		{
			alert("请选择文件");
			return false;
		}
		$("#orderForm").submit();
		
	});
	
	var errorCode = $("#errorCode").val();
	var message = $("#message").val();
	debugger
	if(errorCode!="")
	{
		if(errorCode==0)
		{
			alert("上传成功，" + message);
		}else{
			alert("上传失败," + message);
		}
	}
	
});

