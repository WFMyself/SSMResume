<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>我的资料编辑页面</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 设置编码格式为utf-8 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- 引用jQuery原生的js文件 -->
    <script type="text/javascript" src="/static/plugins/jquery-1.9.1.min.js"></script>

    <!-- 引用bootstrap原生的css文件 -->
    <link href="/static/plugins/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- 引用bootstrap原生的js文件 -->
    <script type="text/javascript" src="/static/plugins/bootstrap/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/static/plugins/fontawesome/font-awesome.min.css">

    <script type="text/javascript" src="/static/plugins/circles/circles.js"></script>

    <!-- 加载等待插件 https://github.com/vadimsva/waitMe -->
    <link rel="stylesheet" href="/static/plugins/waitme/waitMe.css">
    <script src="/static/plugins/waitme/waitMe.js"></script>

    <!-- 输入有效性验证插件 -->
    <link rel="stylesheet" href="/static/plugins/validate/validationEngine.jquery.css">
    <script src="/static/plugins/validate/jquery.validationEngine.js"></script>
    <script src="/static/plugins/validate/locales/jquery.validationEngine-zh_CN.js"></script>

    <!-- 引用自定义的css文件 -->
    <link href="/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<form method="post" action="http://localhost:8080/about/updateAboutMe">
    <c:forEach items="${aboutMes}" var="aboutMeInfo">
    <%--<form:hidden path="aboutMeInfo.id" />--%>
        <div class="form-group col-md-4" style="display:none">
            <!-- 编号 -->
            <label for="aboutMeId"></label>
            <input id="aboutMeId" name="id" value="${aboutMeInfo.id}" class="form-control" maxlength="100" placeholder="..." required="required"/>
        </div>
    <div class="form-group col-md-4">
        <!-- 姓名 -->
        <label for="name"><spring:message code="about.me.name" />：</label>
        <input id="name" name="name" value="${aboutMeInfo.name}" class="form-control" maxlength="100" placeholder="..." required="required" autofocus="autofocus"/>
    </div>
    <div class="form-group col-md-4">
        <!-- 性别 -->
        <label><spring:message code="about.me.gender" />：</label>
        <div>
            <label class="radio-inline">
                <input id="gender2" name="gender" type="radio" value="Female" checked="checked"/>
                <spring:message code="about.me.gender.female" />
            </label>

            <label class="radio-inline">
            <input id="gender1" name="gender" type="radio" value="Male" checked="checked"/>
                <spring:message code="about.me.gender.male" />
            </label>


        </div>
    </div>
    <div class="form-group col-md-4 date">
        <!-- 生日 -->
        <label for="birthday"><spring:message code="about.me.birthday" />：</label>

        <input id="birthday" value="${aboutMeInfo.birthday}" name="birthday" placeholder="..." class="form-control date-picker" required="required" readonly="readonly" type="text" maxlength="100"/>
    </div>

    <div class="form-group col-md-4">
        <!-- 工作年限 -->
        <label for="workingyears"><spring:message code="about.me.working.years" />：</label>
        <input id="workingyears" value="${aboutMeInfo.workingyears}" name="workingyears" class="form-control" maxlength="100" placeholder="..." required="required" />
    </div>

    <div class="form-group col-md-4">
        <!-- 居住地 -->
        <label for="residence"><spring:message code="about.me.residence" />：</label>
        <input id="residence" value="${aboutMeInfo.residence}" name="residence" class="form-control" maxlength="200" placeholder="..." required="required" />
    </div>
    <div class="form-group col-md-4">
        <!-- 邮件 -->
        <label for="email"><spring:message code="about.me.email" />：</label>
        <input id="email" value="${aboutMeInfo.email}" name="email" class="form-control" maxlength="100" placeholder="..." required="required" />
    </div>


        <div class="form-group col-md-4">
            <!-- 教育程度 -->

            <label for="educationDegrees"><spring:message code="about.me.education.degree" />：</label>
            <select id="educationDegrees" class="form-control">
                <option value="${aboutMeInfo.educationDegree.id}">${aboutMeInfo.educationDegree.name}</option>
                <c:forEach items="${educationDegree}" var="ed">
                        <option value="${ed.id}" >${ed.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group col-md-4">
            <!-- 工作状态 -->
            <label for="workingStatus"><spring:message code="about.me.working.status" />：</label>
            <select id="workingStatus"  class="form-control">
                <option value="${aboutMeInfo.workingStatus.id}">${aboutMeInfo.workingStatus.name}</option>
                <c:forEach items="${workingStatus}" var="work">
                    <option value="${work.id}" >${work.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group col-md-4">
        <!-- 手机 -->
        <label for="mobile"><spring:message code="about.me.mobile" />：</label>
        <input id="mobile" value="${aboutMeInfo.mobile}" name="mobile" class="form-control" maxlength="50" placeholder="..." required="required" />
    </div>
    <div class="form-group col-md-12">
        <!-- 人生格言 -->
        <label for="motto"><spring:message code="about.me.motto" />：</label>
        <input id="motto" value="${aboutMeInfo.motto}" name="motto" class="form-control" maxlength="300" placeholder="..." required="required" />
    </div>


    <div class="edit-panel-footer col-md-12">
        <!-- 保存 -->
        <button type="submit" class="btn btn-primary save-btn">
            <i class="fa fa-floppy-o"></i>
            <spring:message code="button.save" />
        </button>
        <!-- 取消 -->
        <button type="reset" class="btn btn-default cancel-btn">
            <i class="fa fa-times"></i>
            <spring:message code="button.cancel" />
        </button>
    </div>
    </c:forEach>
</form>
</body>
</html>