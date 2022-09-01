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
                    <a href="<c:url value=" /logout" />">Logout</a>
                    <h1>Danh sách các hội đồng khóa luận</h1>
                    <c:if test="${errMsg != null}">
                        <div class="alert alert-primary">
                            ${errMsg}
                        </div>
                    </c:if>
                    <c:forEach var="thesisDefense" items="${thesisDefenses}">
                        <br>
                        <div class="row">
                            <div class="col-sm-5">
                                <h3>Mã định danh của hội đồng: ${thesisDefense.id}</h3>
                            </div>
                            <div class="col-sm-5">
                                <h3>Trạng thái: ${thesisDefense.status}</h3>
                            </div>
                        </div>
                        
                        <c:if test="${empty thesisDefense.study}">
                            <p class="font-weight-light">Hiện tại chưa có khóa luận nào trong hội đồng này</p>
                        </c:if>
                        <c:if test="${!empty thesisDefense.study}">
                            <br>
                            <p>Danh sách khóa luận</p>
                            <div class="row">
                                <c:forEach var="s" items="${thesisDefense.study}">
                                    <div class="card col-sm-4">
                                        <div class="card-body">
                                            <form:form action="/KhoaLuan/manage-thesis-defense" method="post">
                                                <div class="form-group row">
                                                    <label for="id" class="col-sm-5">Định danh:
                                                    </label>
                                                    <div class="col-sm-5">
                                                        <input type="hidden" class="form-control" name="studyId" id="studyId" modelAttribute="studyId" value="${s.id}">${s.id}
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="createdDate" class="col-sm-5">Ngày tạo:
                                                    </label>
                                                    <div class="col-sm-7">
                                                        <div class="text-center">${s.createdDate}</div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <input type="hidden" class="form-control" name="thesisDefenseId" id="thesisDefenseId" modelAttribute="thesisDefenseId" value="${thesisDefense.id}">
                                                    <div class="col-sm-5"><button type="submit"
                                                            class="btn btn-success">Xem chi tiết</button>
                                                    </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </body>

            </html>