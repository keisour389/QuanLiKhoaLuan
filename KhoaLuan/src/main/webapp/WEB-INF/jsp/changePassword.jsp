<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Đổi mật khẩu</title>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <c:if test="${errMsg != null}">
                        <div class="alert alert-danger">
                            ${errMsg}
                        </div>
                    </c:if>
                    <h1>Đổi mật khẩu</h1>
                    <div class="card">
                        <div class="card-body">
                            <form:form action="/KhoaLuan/change-password" method="post">

                                <div class="form-group row">
                                    <label for="newPassword" class="col-sm-2 col-form-label">Mật khẩu mới</label>
                                    <div class="col-sm-7">
                                        <input type="password" class="form-control" name="newPassword" id="newPassword"
                                            modelAttribute="newPassword" placeholder="Nhập vào mật khẩu mới">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="newConfirmPassword" class="col-sm-2 col-form-label">Nhập lại mật
                                        khẩu</label>
                                    <div class="col-sm-7">
                                        <input type="password" class="form-control" name="newConfirmPassword"
                                            id="newConfirmPassword" modelAttribute="newConfirmPassword"
                                            placeholder="Nhập lại mật khẩu">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Xác nhận</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>