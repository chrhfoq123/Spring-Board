<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						<form role="form" method="post" action="/board/register">
							<div class="form-group">
								<label>Title</label> <input class="form-control" name="title">
							</div>
							
							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3" name="content"></textarea>
							</div>
							
							<div class="form-group">
								<label>Writer</label> <input class="form-control" name="writer">
							</div>
							
							<button type="submit" class="btn btn-default">Submit
								Button</button>
							<button type="reset" class="btn btn-default">Reset
								Button</button>
						</form>
					</div>
					<!-- /.col-lg-6 (nested) -->
					
				</div>
				<!-- /.row (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<%@include file="../includes/footer.jsp" %>