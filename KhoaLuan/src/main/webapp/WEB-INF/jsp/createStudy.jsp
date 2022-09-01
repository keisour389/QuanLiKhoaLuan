<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Tạo khóa luận</title>
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
                    <c:if test="${studyCreated != null}">
                        <div class="alert alert-success">
                            ${studyCreated}
                        </div>
                    </c:if>
                    <h1>Tạo khóa luận</h1>
                    <div class="card">
                        <div class="card-body">
                            <form:form action="/KhoaLuan/create-study" method="post" modelAttribute="study">

                                <div class="form-group row">
                                    <label for="name" class="col-sm-2 col-form-label">Tên</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" name="name" id="name" path="name"
                                            placeholder="Tên của khóa luận">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="schoolYear" class="col-sm-2 col-form-label">Niên khóa</label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" name="schoolYear" id="schoolYear"
                                            path="schoolYear" placeholder="Niên khóa của khóa luận">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="studentsList" class="col-sm-2 col-form-label">Email của các sinh
                                        viên</label>
                                    <div class="col-sm-7">
                                        <textarea class="form-control" id="studentsList" rows="3"
                                            modelAttribute="studentsList" name="studentsList"
                                            placeholder="Email của từng sinh viên cách nhau bằng dấu ;"></textarea>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="teachersList" class="col-sm-2 col-form-label">Email của các giảng
                                        viên</label>
                                    <div class="col-sm-7">
                                        <textarea class="form-control" id="teachersList" rows="3"
                                            modelAttribute="teachersList" name="teachersList"
                                            placeholder="Email của từng giảng viên cách nhau bằng dấu ;"></textarea>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="teachersList" class="col-sm-2 col-form-label">Hội đồng</label>
                                    <div class="col-sm-7">
                                        <select name="thesisDefenseId" class="form-group">
                                            <c:forEach var="td" items="${thesisDefenses}">
                                                <option value="${td.id}">${td.id}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <button type="submit" class="btn btn-primary">Xác nhận</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>