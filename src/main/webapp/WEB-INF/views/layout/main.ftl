<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<#include "layout/globalvariable.ftl" >
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title></title>  
        <#include "layout/common_file_list.ftl"/>
    </head>  
    <body style="margin:0px;padding:0px;">  
        <div id="head-nav" class="head-nav">
        	<#include "layout/head.ftl" parse=true encoding="utf-8">  
        </div>
        <div id="content">
        	<#include "/tourist.ftl">
        	<sitemesh:body/>
        </div>
        <div id="foot" class="foot">
        	<#include "layout/foot.ftl">
        </div>
    </body>  
</html>