<!DOCTYPE html>
<#escape x as x?html><html>
<head>
<title>${action.getText('product')}</title>
</head>
<body>
<table class="table table-hover table-striped table-bordered" style="white-space: nowrap;">
	<tr>
		<td style="width:200px;">${action.getText('name')}</td>
		<td>${product.name}</td>
	</tr>
	<tr>
		<td>${action.getText('price')}</td>
		<td>${(product.price?string('#,###.00'))!}</td>
	</tr>
	<tr>
		<td>${action.getText('quantity')}</td>
		<td>${product.quantity!}</td>
	</tr>
	<tr>
		<td>${action.getText('status')}</td>
		<td>${product.status!}</td>
	</tr>
	<tr>
		<td>${action.getText('tag')}</td>
		<td><#if product.tags?has_content><#list product.tags as tag><span class="label">${tag}</span> </#list></#if></td>
	</tr>
	<tr>
		<td>${action.getText('description')}</td>
		<td>${product.description!}</td>
	</tr>
</table>
</body>
</html></#escape>
