<!DOCTYPE html>
<#escape x as x?html><html>
<head>
<title>${getText('product')}</title>
</head>
<body>
<#list productList>
    <ul class="unstyled">
    <#items as product>
        <li><a class="ajax view" href="${actionBaseUrl}/${product.id}">${product.name}</a></li>
    </#items>
    <ul>
<#else>
    没有数据
</#list>
</body>
</html></#escape>
