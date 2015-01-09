<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Publisher</title>
<script>
	function deletePublisher(pubId)
	{
		$.ajax({
			  type: "POST",
			  url: "deletePublisherAction",
			  data: { publisherId: pubId}
			})
			  .done(function( msg ) {
				  if(msg.indexOf('Failed') == -1) {
					  $('#pub_row_' + pubId).html('');
				    }
				    $('#resultMsg').html(msg);			 
			  });	
	}
	
	function updateAuthor()
	{
		$.ajax({
			  type: "POST",
			  url: "updatePublisherAction",
			  data: { publisherId: $('#publisherId').val(), publisherName: $('#publisherName').val(),
				  publisherAddress:$('#publisherAddress'), publisherPhone:$('#publisherPhone').val()}
			})
			  .done(function( msg ) {
				  if(msg.indexOf('Failed') == -1) {
				    	$('#pub_name_'+$('#publisherId').val()).html($('#publisherName').val());
				    	$('#pub_address_'+$('#publisherId').val()).html($('#publisherAddress').val());
				    	$('#pub_phone_'+$('#publisherId').val()).html($('#publisherPhone').val());
				    }
	
				    $('#updateAuthorModal').modal('hide');
				    $('#resultMsg').html(msg);
				  });	
	}
	
	function showUpdateModal(id, name, address, phone)
	{
		$('#publisherId').val(id);
		$('#oldPublisherName').html(name);
		$('#oldPublisherAddress').html(address);
		$('#oldPublisherPhone').html(phone );
		$('#updateAuthorModal').modal('show');
	}
</script>

</head>
<body>
<%@ include file="menu.jsp"%>
	<div class="container " >
		<h3>Publisher Management</h3>
		<span id="resultMsg"></span><br/>
		<table class="table table-hover">
			<tr>
				<th>Publisher Name</th>
				<th>Publisher Address</th>
				<th>Publisher Phone</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${publisherList}" var="publisher">
			<tr id="pub_row_${publisher.publisherId}">
				<td id="pub_name_${publisher.publisherId}">${publisher.publisherName}</td>
				<td id="pub_address_${publisher.publisherId}">${publisher.publisherAddress}</td>
				<td id="pub_phone_${publisher.publisherId}">${publisher.publisherPhone}</td>
				<td><button class="btn btn-info"
						onclick="javascript:showUpdateModal(${publisher.publisherId}, '${publisher.publisherName}', '${publisher.publisherAddress}', '${publisher.publisherPhone}');">Update</button></td>
				<td><button class="btn btn-warning" onclick="javascript:deleteAuthor(${publisher.publisherId});">Delete</button></td>
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
						<h4 class="modal-title" id="myModalLabel">Update Publisher</h4>
					</div>
					<div class="modal-body">
						<form action="admin?function=UPDATE_AUTHOR" method="post"
							role="form">
							<div class="form-group">
								<label for="authorName">You are about to update the
									Publisher: <mark><span id="oldPublisherName"></span></mark>
								</label> 
								<input type="hidden" id="publisherId" name="publisherId" /> 
								
								<input type="text" class="form-control" id="publisherName"
									name="publisherName" placeholder="Enter new Publisher name" />
									
							</div>
							<div class="form-group">
								<label for="authorName">You are about to update the
									Address: <mark>
									<span id="oldPublisherAddress"></span></mark> <input type="text"
									class="form-control" id="publisherAddress" name="publisherAddress"
									placeholder="Enter new Publisher Address" />
								</label>
							</div>

							<div class="form-group">
								<label for="publisherPhone">You are about to update the
									Phone: <mark>
									<span id="oldPublisherPhone"></span></mark> <input type="text"
									class="form-control" id="publisherPhone" name="publisherPhone"
									placeholder="Enter new Publisher Phone" />
								</label>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"
							onclick="javascript:updatePublisher();">Save changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>