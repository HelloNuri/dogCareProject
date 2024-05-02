<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="dog" items="${dogs}">
            	<li><a class="dropdown-item" dog-id="${dog.getDogId()}" dog-breed="${dog.getBreed()}" dog-birth-date="${dog.getBirthDate()}" dog-gender="${dog.getGender()}">${dog.getName()}</a></li>
</c:forEach>
<li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="controller?cmd=registerDogUI"
                  style="display: flex; justify-content: center; color: green;"><svg xmlns="http://www.w3.org/2000/svg"
                    width="32" height="32" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                    <path
                      d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z" />
                  </svg></a></li>
