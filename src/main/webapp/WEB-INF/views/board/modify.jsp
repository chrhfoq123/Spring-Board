<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify</</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						<form role="form" method="post" action="/board/modify">
						
							<input type="hidden" name="pageNum" value="<c:out value="${cri.pageNum}"/>"/>
							<input type="hidden" name="amount" value="<c:out value="${cri.amount}"/>"/>
							<input type="hidden" name="keyword" value="<c:out value="${cri.keyword}"/>"/>
							<input type="hidden" name="type" value="<c:out value="${cri.type}"/>"/>
							
							<div class="form-group">
								<label>BNO</label> <input class="form-control" name="bno"
									value="<c:out value="${board.bno}"/>" readonly="readonly">
							</div>

							<div class="form-group">
								<label>Title</label> <input class="form-control" name="title"
									value="<c:out value="${board.title}"/>">
							</div>

							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3" name="content"><c:out
										value="${board.content}" /></textarea>
							</div>

							<div class="form-group">
								<label>Writer</label> <input class="form-control" name="writer"
									value="<c:out value="${board.writer}"/>" readonly="readonly">
							</div>

							<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
							<button type="submit" data-oper='remove' class="btn btn-danger">remove</button>
							<button type="submit" data-oper='list' class="btn btn-info">List</button>
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

<script type="text/javascript">
	
	$(document).ready( function(){

		var formObj = $("form");

		$('button').on("click", function(e){
			e.preventDefault();
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === 'remove'){
				formObj.attr("action", "/board/remove");
			}else if(operation === 'list'){
				formObj.attr("action", "/board/list").attr("method", "get");
				
				var pageNum = $("input[name='pageNum']").clone();
				var amount = $("input[name='amount']").clone();
				var keyword = $("input[name='keyword']").clone();
				var type = $("input[name='type']").clone();
				
				formObj.empty();
				
				formObj.append(pageNum);
				formObj.append(amount);
				formObj.append(keyword);
				formObj.append(type);
			}
			
			formObj.submit();
		});
	});

</script>

<%@include file="../includes/footer.jsp"%>