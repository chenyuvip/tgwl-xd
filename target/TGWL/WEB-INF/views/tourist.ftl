<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   
 "http://www.w3.org/TR/html4/loose.dtd">  
<html lang="zh-CN">  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="${JS_PATH}/tourist.js" type="text/javascript"></script>
        <title>捷达国际物流查询</title>  
    </head>  
    <body>  
    <div class="container-fluid" style="width:60%;">
        <div class="panel panel-success">
        	<div class="panel-heading">
			    <h3 class="panel-title">捷达国际物流查询</h3>
			</div>
			
			<div class="panel-body" style="min-height:300px;">
				<div class="alert alert-success alert-dismissible" role="alert">
				  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				  <strong>提示!</strong> 此处显示物流信息。
				</div>	
				
				<ul class="list-group" id="list-wl">
					<!-- test data
				  <li class="list-group-item list-group-item-success"><span class="label label-default">2016-10-11 10:00 am</span>泰国边境</li>
				  <li class="list-group-item list-group-item-success"><span class="label label-default">2016-10-11 10:00 am</span>泰国边境</li>
				  <li class="list-group-item list-group-item-success"><span class="label label-default">2016-10-11 10:00 am</span>泰国边境</li>
				  <li class="list-group-item list-group-item-success"><span class="label label-default">2016-10-11 10:00 am</span>泰国边境</li>
				  <li class="list-group-item list-group-item-success"><span class="label label-default">2016-10-11 10:00 am</span>泰国边境</li>
				  <li class="list-group-item list-group-item-success"><span class="label label-default">2016-10-11 10:00 am</span>泰国边境</li>
				  -->
				  <#if wlDeatails?exists>
				  	  <#list wlDeatails as wlDetail>
					  	<li class="list-group-item list-group-item-success"><span class="label label-default">${wlDetail.curtime}</span>&nbsp;&nbsp;：&nbsp;${wlDetail.stepinfo}</li>
					  </#list>
				  <#else>
					 <span class="label label-warning">${message}</span>
				  </#if>
				  
				</ul>

		    </div>
		    
		    <div class="panel-footer">
			    <form method="post" id="orderForm" name="orderForm" action="${CONTEXT}/index.html">
			        <div class="input-group">
			          <input type="text" class="form-control" placeholder="请输入订单号，然后单击查询" id="orderno" name="orderno" value="${orderno}">
			          <span class="input-group-btn">
			            <button class="btn btn-default" type="button" id="queryOrderBtn">查询</button>
			          </span>
			        </div>
			    </form>  
		    </div>
		    
		</div>
	</div>
	
	<#include "common/dialog-sm.ftl">
    </body>  
</html>