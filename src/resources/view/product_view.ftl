<!DOCTYPE html>
<#escape x as x?html><html>
<head>
<title>${getText('product')}</title>
</head>
<body>
<table class="table table-hover table-striped table-bordered" style="white-space: nowrap;">
	<tr>
		<td style="width:200px;">${getText('name')}</td>
		<td>${product.name}</td>
	</tr>
	<tr>
		<td>${getText('price')}</td>
		<td>${(product.price?string('#,###.00'))!}</td>
	</tr>
	<tr>
		<td>${getText('quantity')}</td>
		<td>${product.quantity!}</td>
	</tr>
	<tr>
		<td>${getText('status')}</td>
		<td>${product.status!}</td>
	</tr>
	<tr>
		<td>${getText('tag')}</td>
		<td><#if product.tags?has_content><#list product.tags as tag><span class="label">${tag}</span> </#list></#if></td>
	</tr>
	<tr>
		<td>${getText('description')}</td>
		<td>${product.description!}</td>
	</tr>
</table>
</body>
</html></#escape>
