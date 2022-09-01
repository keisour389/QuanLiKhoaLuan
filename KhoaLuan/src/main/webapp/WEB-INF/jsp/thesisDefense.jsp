<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Tạo hội đồng</title>
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
                    <c:if test="${thesisDefenseCreated != null}">
                        <div class="alert alert-success">
                            ${thesisDefenseCreated}
                        </div>
                    </c:if>
                    <h1>Tạo khóa luận</h1>
                    <div class="card">
                        <div class="card-body">
                            <form:form action="/KhoaLuan/create-thesis-defense" method="post">
                                <div class="form-group row">
                                    <label for="manager" class="col-sm-3 col-form-label">Email của chủ tịch hội đồng (*)</label>
                                    <div class="col-sm-7">
                                        <input type="email" class="form-control" name="manager" id="manager" modelAttribute="manager"
                                            placeholder="Nhập vào email" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="secretary" class="col-sm-3 col-form-label">Email của thư ký (*)</label>
                                    <div class="col-sm-7">
                                        <input type="email" class="form-control" name="secretary" id="secretary" modelAttribute="secretary"
                                            placeholder="Nhập vào email" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="counterAgrument" class="col-sm-3 col-form-label">Email của người phản biện (*)</label>
                                    <div class="col-sm-7">
                                        <input type="email" class="form-control" name="counterAgrument" id="counterAgrument" modelAttribute="counterAgrument"
                                            placeholder="Nhập vào email" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="member1" class="col-sm-3 col-form-label">Email của thành viên 1</label>
                                    <div class="col-sm-7">
                                        <input type="email" class="form-control" name="member1" id="member1" modelAttribute="member1"
                                        placeholder="Nhập vào email">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="member2" class="col-sm-3 col-form-label">Email của thành viên 2</label>
                                    <div class="col-sm-7">
                                        <input type="email" class="form-control" name="member2" id="member2" modelAttribute="member2"
                                        placeholder="Nhập vào email">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Xác nhận</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>