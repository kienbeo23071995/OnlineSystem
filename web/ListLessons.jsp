
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<b>Lesson </b> 
<select name="lessonId" class="form-control">
    <c:forEach items="${listLessons}" var="L">
        <option value="${L.lessonId}" ${L.lessonId == requestScope.quizByQuizId.lessonId?"selected":""}>${L.lessonName}: ${L.content}</option>
    </c:forEach>
</select>