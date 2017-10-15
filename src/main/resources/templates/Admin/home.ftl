Admin page

<#if username??>
<h1> Welcome, ${username!"guest"}</h1>
<h1> Welcome, ${type!"guest"}</h1>
<h2><a href="/logout">Logout</a></h2>
<#else>
<h1><a href="/register">Sign Up</a></h1>
<h1><a href="/login">Log In</a></h1>
</#if>