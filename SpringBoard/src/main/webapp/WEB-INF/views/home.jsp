<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="include/header.jsp" %>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<div class="info-box bg-blue">
		<span class="info-box-icon"><i
			class="ion-ios-chatbubble-outline"></i></span>
		<div class="info-box-content">
			<span class="info-box-text">Direct Messages</span> <span
				class="info-box-number">163,921</span>
			<div class="progress">
				<div class="progress-bar" style="width: 40%"></div>
			</div>
			<span class="progress-description"> 40% Increase in 30 Days </span>
		</div>

	</div>
<%@ include file="include/footer.jsp" %>