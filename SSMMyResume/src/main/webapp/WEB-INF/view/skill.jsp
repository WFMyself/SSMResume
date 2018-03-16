<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>专业技能</title>
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
<div class="row">
    <form id="skillForm" action="http://localhost:8080/skill/updateSkill" method="post">
        <c:forEach items="${dataBinderSkill}" var="skill" varStatus="idxStatus">
            <%--<h1>索引：<c:out value="${idxStatus.index}"></c:out></h1>--%>
            <div class="col-md-2">
                <div class="panel panel-success">
                    <div class="panel-heading text-center">
                        技能${skill.id}
                    </div>
                    <div class="panel-body">
                        <input type="hidden" name="skills[${idxStatus.index}].id" value="${skill.id}"/>
                        <div class="form-group">
                            <input type="text" class="form-control validate[required]" name="skills[${idxStatus.index}].name" value="${skill.name}" placeholder="名称..."/>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control validate[required]" step="5" min="10" max="100"  name="skills[${idxStatus.index}].level" value="${skill.level}" placeholder="掌握程度..."/>
                        </div>
                        <div class="form-group">
                            <input type="hidden" class="form-control validate[required]"   name="skills[${idxStatus.index}].indexNo" value="${skill.indexNo}" placeholder="序号" />
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="edit-panel-footer col-md-12">
            <!-- 保存 -->
            <button type="submit" class="btn btn-primary save-btn">
                <i class="fa fa-floppy-o"></i>
                <spring:message code="button.save"/>
            </button>
            <!-- 取消 -->
            <button type="reset" class="btn btn-default cancel-btn">
                <i class="fa fa-times"></i>
                <spring:message code="button.cancel"/>
            </button>
        </div>
    </form>
</div>
</body>
</html>