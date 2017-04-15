<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   
 "http://www.w3.org/TR/html4/loose.dtd">  
<html lang="zh-CN">  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title></title>  
    <#include "layout/globalvariable.ftl" >
    <#include "layout/common_file_list.ftl"/>
    <link rel="stylesheet" href="${JS_PATH}/plug-in/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">
    
    
    <script src="${JS_PATH}/plug-in/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
    <script src="${JS_PATH}/admin/index.js" type="text/javascript"></script>
</head>
<body>
<div class="jumbotron">
  <div class="container">
  </div>
</div>

	<div class="container-fluid" style="width:80%;">
		<div class="panel panel-primary">
		  <div class="panel-heading">上传单个订单号</div>
		  <div class="panel-body">
		    
		    <div class="col-lg-3">
			    <div class="input-group">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">日期：</button>
			      </span>
			      <input readonly="true" type="text" placeholder="点击选择日期" name="datetimepicker" id="datetimepicker" value="${defaultDate}"  class="form-control">
			    </div><!-- /input-group -->
			</div><!-- /.col-lg-6 -->
			
		    <div class="col-lg-5">
			    <div class="input-group">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">订单号：</button>
			      </span>
			      <input type="text" value="" id="orderno" class="form-control">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="simpleOrderBtn">确定!</button>
			      </span>
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
		    
		  </div>
		</div>
	
		<div class="panel panel-primary">
		  <div class="panel-heading">批量上传订单号</div>
		  <div class="panel-body">
		    <form id="orderForm" action="${CONTEXT}/admin/doPatchOrders.html" enctype="multipart/form-data" name="orderForm" method="post" class="form-horizontal">
		    <!--
		    <div class="col-lg-3">
			    <div class="input-group">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">日期：</button>
			      </span>
			      <input readonly="true" type="text" placeholder="点击选择日期" name="datetimepicker2" id="datetimepicker2" value=""  class="form-control">
			    </div>
			</div>
			 -->
			 <input type="hidden" name="errorCode" id="errorCode" value="${errorCode}"/>
			 <input type="hidden" name="message" id="message" value="${message}"/>
		    <div class="col-lg-5">
			    <div class="input-group">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">订单号：</button>
			      </span>
			      <input type="file" value="" id="orderExcel" name="orderExcel" class="form-control">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="orderListBtn">确定!</button>
			      </span>
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
		    </form>
		    
		  </div>
		</div>
	</div>
</body>
</html>
