<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Book</title>
<script>
function showBookModal(bookId, authorName, pubName, title)
{
	$('#bookId').val(bookId);
	$('#oldAuthorName').html(authorName);
	$('#oldPublisherName').html(pubName);
	$('#oldBookTitle').html(title);
	$('#updateBookModal').modal('show');
}

function updateBook()
{
	$.ajax({
		type:"POST",
		url:"updateBookAction",
		data:{bookId:$('#bookId').val(), title: $('#title').val(), authorId: $('#authorSelector').val()
			,publisherId:$('#publisherSelector').val()}
	}).done(function(msg){
		$('#book_title_'+$('#bookId').val()).html($('#title').val());
		$('#book_auth_'+$('#bookId').val()).html($('#authorSelector option[value='+$('#authorSelector').val()+']').text());
		$('#book_pub_'+$('#bookId').val()).html($('#publisherSelector option[value='+$('#publisherSelector').val()+']').text());
		$('#updateBookModal').modal('hide');
		$('#resultMsg').html(msg);
			});
}

function deleteBook(id)
{
	$.ajax({
		type:"POST",
		url:"deleteBookAction",
	    data:{bookId:id}
	}).done(function(msg){
		$('#book_row_'+id).html('');
		$('#resultMsg').html(msg);
	});
}
</script>
<%@ include file="menu.jsp"%>
</head>
<body>
	<div class="container">
	<h3>Book Management</h3>
	<span id="resultMsg"></span><br/>
		<form action="admin" method="POST" name=bookListForm>
			<table class="table table-hover">
				<tr>
					<th>Book Name</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="book" items="${bookList}">
				<tr id="book_row_${book.bookId}">
					<td id="book_title_${book.bookId}">${book.title}</td>
					<td id="book_auth_${book.bookId}">${book.author.authorName}</td>
					<td id="book_pub_${book.bookId}">${book.publisher.publisherName}</td>
					<td><button type="button" class="btn btn-info"
							onClick="javascript:showBookModal(${book.bookId}, '${book.author.authorName}',
							 '${book.publisher.publisherName}',
							 '${book.title}');">Update</button></td>
					<td><button type="button" class="btn btn-warning" onClick="javascript:deleteBook(${book.bookId});">Delete</button></td>
				</tr>
				</c:forEach>
			</table>
		</form>
		<div class="modal fade" id="updateBookModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Update Book</h4>
					</div>
					<div class="modal-body">
						<form action="admin?function=ADD_BOOK" method="post" role="form">
							<div class="form-group">
								<label for="title">Update title: <mark>
									<span id="oldBookTitle"></span></mark></label> 
									<input
									type="hidden" id="bookId" name="bookId" /> <input type="text"
									class="form-control" id="title" name="title"
									placeholder="Enter Title">
							</div>
							<div class="form-group">
								<label for="author">Update author: 
								<mark><span id="oldAuthorName"></span></mark></label>
								<select class="form-control" id="authorSelector">
								<option value=1>Select</option>
								<c:forEach var="author" items="${authorList}">
								<option value="${author.authorId}">${author.authorName}</option>
								</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="publisher">Publisher: Update publisher: 
								<mark><span id="oldPublisherName"></span></mark></label>
								<select class="form-control" id="publisherSelector">
								<option value=1>Select</option>
								<c:forEach var="publisher" items="${publisherList}">
								<option value="${publisher.publisherId}">${publisher.publisherName}</option>
								</c:forEach>
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"
							onclick="javascript:updateBook();">Save changes</button>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>