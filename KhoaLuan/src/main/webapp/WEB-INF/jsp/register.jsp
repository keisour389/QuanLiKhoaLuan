<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <c:if test="${errMsg != null}">
                            <div class="alert alert-danger">
                                ${errMsg}
                            </div>
                        </c:if>
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
                                            <input type="email" class="form-control" name="email" id="email"
                                                path="email" placeholder="Nhập vào email">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-9">
                                            <label for="role" class="col-sm-3 col-form-label radio-inline">
                                                <input type="radio" name="role" id="role" path="role"
                                                    value="ROLE_STUDENT" checked>Sinh viên
                                            </label>
                                            <label for="role" class="col-sm-3 col-form-label radio-inline">
                                                <input type="radio" name="role" id="role" path="role"
                                                    value="ROLE_TEACHER" checked>Giảng viên
                                            </label>
                                            <label for="role" class="col-sm-3 col-form-label radio-inline">
                                                <input type="radio" name="role" id="role" path="role"
                                                    value="ROLE_MINISTRY" checked>Giáo vụ
                                            </label>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Xác nhận</button>
                                </form:form>
                            </div>
                        </div>
                    </div>

                    <c:if test="${userDataAfterCreating != null}">
                        <div class="modal hide fade" id="userDataModal" tabindex="-1" role="dialog"
                            aria-labelledby="userInfo" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="userInfo">Thông tin tài khoản</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form:form action="">
                                            <div class="form-group row">
                                                <div class="col-sm-3">ID: </div>
                                                <h5 class="col-sm-7" id="idInModal">${userDataAfterCreating.id}</h5>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-sm-3">Email: </div>
                                                <h5 class="col-sm-7" id="emailInModal">${userDataAfterCreating.email}</h5>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-sm-3">Mật khẩu: </div>
                                                <h5 class="col-sm-7" id="passwordInModal">${userPasswordPlainText}</h5>
                                            </div>
                                            <div class="form-group row">
                                                <fmt:formatDate value="${userCreatedDate}" pattern="dd-MM-yyyy HH:mm:ss"
                                                    var="parsedDate" />
                                                <div class="col-sm-3">Ngày tạo: </div>
                                                <h5 class="col-sm-7">${parsedDate}</h5>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-success" onclick="myFunction()">Sao chép</button>
                                        <button type="button" class="btn btn-primary">Xác nhận</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                        crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                        crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                        crossorigin="anonymous"></script>
                    <script type="text/javascript">
                        $(window).on('load', function () {
                            $('#userDataModal').modal('show');
                        });
                        function myFunction() {
                            /* Get the text field */
                            var id = document.getElementById("idInModal");
                            var email = document.getElementById("emailInModal");
                            var password = document.getElementById("passwordInModal");

                            var copyString = "{ ID: " + id.innerHTML + ", Email: " + email.innerHTML + ", Password: " + password.innerHTML + " }";

                            // /* Select the text field */
                            // copyText.select();
                            // copyText.setSelectionRange(0, 99999); /* For mobile devices */

                            /* Copy the text inside the text field */
                            navigator.clipboard.writeText(copyString);

                            /* Alert the copied text */
                            alert("Sao chép tài khoản thành công: " + email.innerHTML);
                        }
                    </script>
                </body>

                </html>