<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Chấm điểm</title>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <h1>Chấm điểm khóa luận</h1>
                    <div class="card">
                        <div class="card-body">
                            <form:form action="" method="post">
                                <c:forEach var="criteria" items="${criterias}">
                                    <div class="form-group row">
                                        <label for="name" class="col-sm-2 col-form-label">${criteria.name}</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" name="${criteria.name}"
                                                placeholder="Nhập vào điểm">
                                        </div>
                                    </div>
                                </c:forEach>
                                <button type="submit" class="btn btn-primary">Xác nhận</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>