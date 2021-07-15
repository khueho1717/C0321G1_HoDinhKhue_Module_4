<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Selection of seasoning for Sandwich</h2>
    <p>The form below contains four inline checkboxes:</p>
    <form action="/condiment">
        <div class="form-check-inline">
            <label class="form-check-label" for="lettuce">
                <input type="checkbox" class="form-check-input" id="lettuce" name="lettuce" value="lettuce">lettuce
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label" for="mustard">
                <input type="checkbox" class="form-check-input" id="mustard" name="mustard" value="mustard">mustard
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label" for="tomato">
                <input type="checkbox" class="form-check-input" id="tomato" name="tomato" value="tomato">tomato
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label" for="sprouts">
                <input type="checkbox" class="form-check-input" id="sprouts" name="sprouts" value="sprouts">sprouts
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
    <h3>Sandwich Condiment</h3>
    <c:if test="${lettuce!=null}">
        <p class="text-danger">${lettuce}</p>
    </c:if>
    <c:if test="${tomato!=null}">
        <p class="text-danger">${tomato}</p>
    </c:if>
    <c:if test="${mustard!=null}">
        <p class="text-danger">${mustard}</p>
    </c:if>
    <c:if test="${sprouts!=null}">
        <p class="text-danger">${sprouts}</p>
    </c:if>
</div>
</body>
</html>