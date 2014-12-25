<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Publisher</title>
<script >
function showPublisherModal(id, name, address, phone)
{
	$('#publisherId').val(id);
	$('#oldPublisherName').html(name);
	$('#oldPublisherAddress').html(address);
	$('#oldPublisherPhone').html(phone);
	$('#updatePublisherModal').modal('show');
}

function updatePublisher()
{
	console.log('im here');
	$.ajax({
		type:"POST",
		url:"updatePublisherAction",
		data:{publisherId:$('#publisherId').val(), publisherName:$('#publisherName').val(), 
			publisherAddress:$('#publisherAddress').val(), publisherPhone:$('#publisherPhone').val()}		
	}).done(function(msg){
		if(msg.indexOf("Failed") == -1)
		{
			$('#pub_name_'+$('#publisherId').val()).html($('#publisherName').val());
			$('#pub_add_'+$('#publisherId').val()).html($('#publisherAddress').val());
			$('#pub_phone_'+$('#publisherId').val()).html($('#publisherPhone').val());
		}
		$('#updatePublisherModal').modal('hide');
		$('#resultMsg').html(msg);
	});
}

function deletePublisher(pubId)
{
	$.ajax({
		  type: "POST",
		  url: "deletePublisherAction",
		  data: { publisherId: pubId}
		})
		  .done(function( msg ) {
			  if(msg.indexOf("Failed")==-1)
			  {
			 	 $('#pub_row_' + pubId).html('');
			  }
			  $('#resultMsg').html(msg);
		  });	
}
</script>


<%@include file="menu.jsp" %>
</head>
<body>
<div class="container">
<h3>Publisher Management</h3>
	<span id="resultMsg"></span><br/>
	<form action="admin" method="POST" name=publisherListForm>
	<table class="table table-hover">
		<tr>
			<th>Publisher Name</th>
			<th>Publisher Address</th>
			<th>Publisher Phone</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="pub" items="${publisherList}">
		
		<tr id="pub_row_${pub.publisherId}">
		<td id="pub_name_${pub.publisherId}">${pub.publisherName}</td>
		<td id="pub_add_${pub.publisherId}">${pub.publisherAddress}</td>
		<td id="pub_phone_${pub.publisherId}">${pub.publisherPhone}</td>
					<td><button type="button" class="btn btn-info" 
					onClick="javascript:showPublisherModal(${pub.publisherId}, '${pub.publisherName}', 
					'${pub.publisherAddress}', '${pub.publisherPhone}');">Update</button></td>
		<td><button type="button" class="btn btn-warning" onClick="javascript:deletePublisher(${pub.publisherId});">Delete
						</button></td>
		</tr>
	</c:forEach>
	</table>
	</form>
			<div class="modal fade" id="updatePublisherModal" tabindex="-1"
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
						<form action="admin?function=UPDATE_PUBLISHER" method="post"
							role="form">
							<div class="form-group">
								<label for="publisherName">Update name: <mark><span id="oldPublisherName"></span></mark>
								</label> 
								<input type="hidden" id="publisherId" name="publisherId" />
								<input type="text" class="form-control" id="publisherName"
									name="publisherName" placeholder="Enter new publisher name" /> 
							</div>
							<div class="form-group">
								<label for="publisherAddress">Update address: <mark><span id="oldPublisherAddress"></span></mark>
								</label> 
								<input type="text" class="form-control"
									id="publisherAddress" name="publisherAddress" placeholder="Enter new publisher address"/> 
							</div>
							<div class="form-group">
								<label for="publisherPhone">Update phone: <mark><span id="oldPublisherPhone"></span></mark>
								</label> 
								<input type="text"
									class="form-control" id="publisherPhone" name="publisherPhone" placeholder="Enter new publisher phone"/>
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