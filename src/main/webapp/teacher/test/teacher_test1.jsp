<%@ page import="com.example.team_project.mybatis.factory.MyBatisSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.example.team_project.teacher.mapper.ClassMapper" %>
<%@ page import="com.example.team_project.teacher.dto.TeacherDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-11-20
  Time: 오후 6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>teacher_test1.jsp</title>
</head>
<body>
<%
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
    List<TeacherDTO> allTeacher = mapper.getAllTeacher();
    for (TeacherDTO dto : allTeacher) {
%>
<p><%=dto.getTeacherName()%></p>
<%
    }
%>
</body>
</html>
