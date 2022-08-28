<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Đăng kí</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">

        </head>

        <body>
            <div class="container">
                <h1>Đăng kí tài khoản mới</h1>
                <div class="card">
                    <div class="card-body">
                        <form:form action="/KhoaLuan/register" method="post" modelAttribute="user">

                            <div class="form-group row">
                                <label for="lastName" class="col-sm-2 col-form-label">Họ</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="lastName" id="lastName"
                                        path="lastName" placeholder="Nhập vào họ">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="firstName" class="col-sm-2 col-form-label">Tên</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="firstName" id="firstName"
                                        path="firstName" placeholder="Nhập vào tên">
                                </div>
                            </div>



                            <div class=" form-group row">
                                <label for="email" class="col-sm-2 col-form-label">Email</label>
                                <div class="col-sm-7">
                                    <input type="email" class="form-control" name="email" id="email" path="email"
                                        placeholder="Nhập vào email">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-9">
                                    <label for="role" class="col-sm-3 col-form-label radio-inline">
                                        <input type="radio" name="role" id="role" path="role" value="ROLE_STUDENT"
                                            checked>Học sinh
                                    </label>
                                    <label for="role" class="col-sm-3 col-form-label radio-inline">
                                        <input type="radio" name="role" id="role" path="role" value="ROLE_TEACHER"
                                            checked>Giáo viên
                                    </label>
                                    <label for="role" class="col-sm-3 col-form-label radio-inline">
                                        <input type="radio" name="role" id="role" path="role" value="ROLE_MINISTRY"
                                            checked>Giáo vụ
                                    </label>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Xác nhận</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </body>

        </html>