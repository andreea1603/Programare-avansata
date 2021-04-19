<html>
    Comenzi realizate:


<body>
    <#list Operation?keys as key>
        <p>
            (*) ${key} = ${Operation[key]}
            </#list>
    </p>
</body>
</html>