<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page import="com.java.KhoaLuan.enums.UserRole" %>
                <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="ISO-8859-1">
                    <title>Trang chủ</title>
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                        crossorigin="anonymous">
                </head>

                <body>
                    <div class="container">
                        <h1>Chào mừng đến với trang đăng kí khóa luận</h1>
                        <c:if test="${not empty userLoggedIn}">
                            <div class="row">
                                <div class="col-sm-8 row">
                                    <div class="col-sm-4">
                                        <div class="name">Xin chào: ${userLoggedIn}</div>
                                    </div>
                                    <div class="col-sm-2">
                                        <form:form action="/KhoaLuan/change-password" method="get">
                                            <button type="submit" class="btn btn-secondary">Đổi mật khẩu</button>
                                        </form:form>
                                    </div>
                                    <div class="col-sm-2">
                                        <form:form action="/KhoaLuan/logout" method="get">
                                            <button type="submit" class="btn btn-danger">Đăng xuất</button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <br>
                        <c:if test="${empty userLoggedIn}">
                            <h3>Đăng nhập với vai trò:</h3>
                            <div class="row">
                                <div class="col-sm-6 row">
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/admin" method="get">
                                            <button type="submit" class="btn btn-primary">Quản trị</button>
                                        </form:form>
                                    </div>
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/ministry" method="get">
                                            <button type="submit" class="btn btn-success">Giáo vụ</button>
                                        </form:form>
                                    </div>
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/teacher" method="get">
                                            <button type="submit" class="btn btn-warning">Giảng viên</button>
                                        </form:form>
                                    </div>
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/student" method="get">
                                            <button type="submit" class="btn btn-info">Sinh viên</button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <c:if test="${(not empty ministry || not empty admin) &&  not empty userLoggedIn}">
                            <div class="row">
                                <div class="col-sm-9 row">
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/manage-thesis-defense" method="get">
                                            <button type="submit" class="btn btn-primary">Quản lí thông tin</button>
                                        </form:form>
                                    </div>
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/create-thesis-defense" method="get">
                                            <button type="submit" class="btn btn-success">Tạo hội đồng</button>
                                        </form:form>
                                    </div>
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/create-study" method="get">
                                            <button type="submit" class="btn btn-warning">Tạo khóa luận</button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <c:if test="${not empty teacher &&  not empty userLoggedIn}">
                            <div class="row">
                                <div class="col-sm-9 row">
                                    <div class="col-sm-3">
                                        <form:form action="/KhoaLuan/manage-thesis-defense" method="get">
                                            <button type="submit" class="btn btn-primary">Quản lí thông tin</button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>

                </body>

                </html>