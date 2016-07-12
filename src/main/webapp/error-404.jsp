<%@page import="com.ipartek.formacion.Constantes"%>
<%@ page isErrorPage="true" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="css/error.css?v=2.0">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

  

<div class="error-header"> </div>
<div class="container ">
    <section class="error-container text-center">
        <h1>404</h1>
        <div class="error-divider">
            <h2> <i class="fa fa-search" aria-hidden="true"></i> </h2>
            <p class="description">El recurso no existe</p>
        </div>
        <a href="<%=Constantes.WEB_HOME %>index.jsp" class="return-btn"><i class="fa fa-home"></i>Home</a>
    </section>
</div>