<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Author</title>
<script>
function deleteAuthor(authId)
{
	$.ajax({
		  type: "POST",
		  url: "deleteAuthorAction",
		  data: { authorId: authId}
		})
		  .done(function( msg ) {
			  if(msg.indexOf('Failed') == -1) {
				  $('#auth_row_' + authId).html('');
			    }
			    $('#resultMsg').html(msg);			 
		  });	
}

function updateAuthor()
{
	$.ajax({
		  type: "POST",
		  url: "updateAuthorAction",
		  data: { authorId: $('#authorId').val(), authorName: $('#authorName').val() }
		})
		  .done(function( msg ) {
		    //alert('#auth_'+$('#authorId').val());
			  if(msg.indexOf('Failed') == -1) {
			    	$('#auth_'+$('#authorId').val()).html($('#authorName').val());
			    }

			    $('#updateAuthorModal').modal('hide');
			    $('#resultMsg').html(msg);
			  });	
}

function showUpdateModal(id, name)
{
	$('#authorId').val(id);
	$('#oldAuthorName').html(name);
	$('#updateAuthorModal').modal('show');
}
</script>
</head>
<body>
<%@ include file="menu.jsp"%>
	<div class="container " >
		<h3>Author Management</h3>
		<span id="resultMsg"></span><br/>
		<table class="table table-hover">
			<tr>
				<th>Author Name</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${authorList}" var="author">
			<tr id="auth_row_${author.authorId}">
				<td id="auth_${author.authorId}">${author.authorName}</td>
				<td><button class="btn btn-info"
						onclick="javascript:showUpdateModal(${author.authorId}, '${author.authorName}');">Update</button></td>
				<td><button class="btn btn-warning" onclick="javascript:deleteAuthor(${author.authorId});">Delete</button></td>
			</tr>
			</c:forEach>
		
		</table>
		<div class="modal fade" id="updateAuthorModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Update Author</h4>
					</div>
					<div class="modal-body">
						<form action="admin?function=UPDATE_AUTHOR" method="post"
							role="form">
							<div class="form-group">
								<label for="authorName">You are about to update the
									Author: <mark><span id="oldAuthorName"></span></mark>
								</label> <input type="hidden" id="authorId" name="authorId" /> <input
									type="text" class="form-control" id="authorName"
									name="authorName" placeholder="Enter new author name" />
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"
							onclick="javascript:updateAuthor();">Save changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>