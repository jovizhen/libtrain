<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Authors</title>

<script>

function showUpdateModal(authId, oldAuthName) {
	$('#oldAuthorName').html(oldAuthName);
	$('#oldAuthorId').val(authId);
	$('#updateAuthorModal').modal('show');
}

function sendUpdateDetails() {
	$.ajax({
		  type: "POST",
		  url: "updateAuthorAction",
		  data: { authorId: $('#oldAuthorId').val(), authorName: $('#authorName').val() }
		})
		  .done(function( msg ) {
		    //alert('#auth_'+$('#oldAuthorId').val());
		    
		    if(msg.indexOf('Failed') == -1) {
		    	$('#auth_'+$('#oldAuthorId').val()).html($('#authorName').val());
		    }

		    $('#updateAuthorModal').modal('hide');
		    $('#resultMsg').html(msg);
		  });	
}

function deleteAuthor(authId) {
	$.ajax({
		  type: "POST",
		  url: "deleteAuthorAction",
		  data: { authorId: authId}
		})
		  .done(function( msg ) {
			  $('#auth_row_' + authId).html('');
		  });	
}
</script>

</head>
<%@ include file="menu.jsp"%>
<body>
	<span id="resultMsg"></span><br/>
	<!-- Modal -->
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
				<form name="updateAuthorForm" action="updateAuthorAction"
					method="post">
					<div class="modal-body">
						You are about to update the Author: <span id="oldAuthorName"></span><br />
						<input type="hidden" id="oldAuthorId" name="oldAuthorId" /> 
						<input type="text" placeholder="Enter Author's New Name"
							name="authorName" id="authorName" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"
							onclick="javascript:sendUpdateDetails();">Save changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container col-md-6 col-md-offset-3 col-sm-8 col-xs-12">
		<table class="table table-hover">
			<tr>
				<th>Author Name</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${authors}" var="author">
			<tr id="auth_row_${author.authorId}">
				<td id="auth_${author.authorId}">${author.authorName}</td>
				<td><button class="btn btn-info"
						onclick="javascript:showUpdateModal(${author.authorId}, '${author.authorName}');">Update</button></td>
				<td><button class="btn btn-warning" onclick="javascript:deleteAuthor(${author.authorId});">Delete</button></td>
			</tr>
			</c:forEach>
		
		</table>


	</div>
</body>
</html>