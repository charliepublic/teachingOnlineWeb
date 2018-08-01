<%@ page import="com.aneon.po.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>TOSIT学员管理系统</title>
    <link rel="stylesheet" href="../resources/lib/layui/css/layui.css" />
    <link rel="stylesheet" href="../resources/css/my.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">TOSIT后台面板</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <% User user = (User)session.getAttribute("User"); %>
                    <%= user.getName() %>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" id="sideNav" lay-filter="sideNav">
                <li class="layui-nav-item layui-nav-itemed">
                    <a>项目库管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="projectManage/projectdisplay.html">项目库展示</a></dd>
                        <dd><a href="javascript:;" data-url="projectManage/applymanagement.html">项目审批</a></dd>
                        <dd><a href="javascript:;" data-url="projectManage/projectmanager.html">项目管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>文档库管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="fileManage/fileManage.html">文档库展示</a></dd>
                        <dd><a href="javascript:;" data-url="fileManage/fileAdd.html">文档上传</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>学员、班级管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="studentManage/student.html">学员管理</a></dd>
                        <dd><a href="javascript:;" data-url="studentManage/Tclass.html">班级管理</a></dd>
                        <dd><a href="javascript:;" data-url="studentManage/classDVD.html">分班信息</a></dd>
                        <dd><a href="javascript:;" data-url="studentManage/classInfo.html">分组信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a>教学计划</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url=taskManage/TeachingPlanManagement.html>查看教学任务</a></dd>
                        <dd><a href="javascript:;" data-url=taskManage/TaskArrangement.html>添加任务</a></dd>
                        <dd><a href="javascript:;" data-url=taskManage/DocumentGrade.html>学员文档评分</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab fly-tab layui-tab-card" lay-filter="page-tab" lay-allowclose="true">
            <!--tab标题-->
            <ul class="layui-tab-title" id="tabTitle">
                <li class="layui-this" lay-id="0"><label>首页</label></li>
            </ul>
            <!--tab内容-->
            <div class="layui-tab-content" id="tabContainers">
                <div class="layui-tab-item layui-show">
                    <p>提示<span class="icon-i-b tips-icon mgl-5 ve-m"><span class="dialog-warp right"><label class="dialog-box">床前明月光，疑是地上霜，举头望明月，低头思故乡。</label></span></span>
                    </p>
                    <div class="fly-echart echart-map sw-100" id="user-form-map"> 地图 </div>
                    <div class="fly-echart echart-pie sw-50 fl" id="user-form-pie"> 饼状图 </div>
                    <div class="fly-echart echart-line sw-50 fl" id="user-form-line"> 折线图 </div>
                    <div class="fly-echart echart-bar sw-100 fl" id="user-form-bar"> 柱状和折线 </div>
                </div>
            </div>
        </div>
    </div>


</div>

<script src="../resources/lib/layui/layui.js"></script>
<script src="../resources/js/another.js"></script>
</body>
</html>