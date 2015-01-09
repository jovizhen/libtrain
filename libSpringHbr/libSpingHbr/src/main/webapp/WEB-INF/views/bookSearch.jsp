<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
<script >
function showBookDetailModal(title,pub,authors, genres)
{
	$('#bookTitle').html(title);
	$('#bookPublisher').html(pub);
	$('#bookAuthors').html(authors);
	$('#bookGenres').html(genres);
	
	$.ajax({
		type:"POST",
		url:"booksBySameAuthor",
		data:{authors:authors}
		
	}).done(function(msg){
		$('#bookBySameAuthor').html(msg);
	});
	
	$.ajax({
		type:"POST",
		url:"booksBySamePublisher",
		data:{publisher:pub}
		
	}).done(function(msg){
		$('#bookBySamePub').html(msg);
	});
	
	$.ajax({
		type:"POST",
		url:"booksBySameGenre",
		data:{genres:genres}
		
	}).done(function(msg){
		$('#bookBySameGenre').html(msg);
	});
	$('#bookDetailModal').modal('show');
	
}

</script>
</head>
<body>
<%@ include file="menu.jsp"%>
	<div class="container col-md-10 col-md-offset-1">
	<form action="performSearchAction" method="post" class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Book Title/Author name/Publisher name" name="keyWord"/>
						<select class="form-control" name="authorId">
						<option value="-1">Select Author</option>
						<c:forEach var="author" items="${authors}">
						<option value="${author.authorId}">${author.authorName}</option>
						</c:forEach>
						</select>
						<select class="form-control" name="pubId">
						<option value="-1">Select Publisher</option>
						<c:forEach var="pub" items="${publishers}">
						<option value="${pub.publisherId}">${pub.publisherName}</option>
						</c:forEach>
						</select>
					</div>
					<button type="Submit" class="btn btn-primary">Search</button>
				</form></br>
	<h3 > By Title</h3>
	<table class="table table-hover">
				<tr>
					<th>Book Name</th>
					<th>Publisher</th>
					<th>Authors</th>
					<th>Genres</th>
					<th>Detail</th>
				</tr>
				<c:forEach var="book" items="${booksByTitle}">
				<tr id="book_row_${book.bookId}">
					<td id="book_title_${book.bookId}">${book.title}</td>
					<td id="book_pub_${book.bookId}">${book.publisher.publisherName}</td>
					<td>${book.authorString}</td>
					<td>${book.genreString}</td>
					<td><button type="button" class="btn btn-info"
							onClick="javascript:showBookDetailModal('${book.title}', '${book.publisher.publisherName}', '${book.authorString}', '${book.genreString}');">Detail</button></td>
				</tr>
				</c:forEach>
			</table>
	
	
	<h3> By Author</h3>
	
	<table class="table table-hover">
				<tr>
					<th>Book Name</th>
					<th>Publisher</th>
					<th>Authors</th>
					<th>Genres</th>
					<th>Detail</th>
				</tr>
				<c:forEach var="book" items="${booksByAuthor}">
				<tr id="book_row_${book.bookId}">
					<td id="book_title_${book.bookId}">${book.title}</td>
					<td id="book_pub_${book.bookId}">${book.publisher.publisherName}</td>
					<td>${book.authorString}</td>
					<td>${book.genreString}</td>
					<td><button type="button" class="btn btn-info"
							onClick="javascript:showBookDetailModal('${book.title}', '${book.publisher.publisherName}', '${book.authorString}', '${book.genreString}');">Detail</button></td>
				</tr>
				</c:forEach>
			</table>
	
	<h3> By Publisher</h3>
	<table class="table table-hover">
				<tr>
					<th>Book Name</th>
					<th>Publisher</th>
					<th>Authors</th>
					<th>Genres</th>
					<th>Detail</th>
				</tr>
				<c:forEach var="book" items="${booksByPub}">
				<tr id="book_row_${book.bookId}">
					<td id="book_title_${book.bookId}">${book.title}</td>
					<td id="book_pub_${book.bookId}">${book.publisher.publisherName}</td>
					<td>${book.authorString}</td>
					<td>${book.genreString}</td>
					<td><button type="button" class="btn btn-info"
							onClick="javascript:showBookDetailModal('${book.title}', '${book.publisher.publisherName}', '${book.authorString}', '${book.genreString}');">Detail</button></td>
				</tr>
				</c:forEach>
			</table>
	
	</div>
	
	<div class="modal fade" id="bookDetailModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Book Details</h4>
					</div>
					<div class="modal-body">
							<div class="form-group">
								<label>Title: <span id="bookTitle" style="color:blue"></span>
								</label> 
							</div>
							<div class="form-group">
								<label >Publisher: <span id="bookPublisher" style="color:blue"></span>
								</label> 
							</div>
							<div class="form-group">
								<label>Authors: <span id="bookAuthors" style="color:blue"></span>
								</label> 
							</div>
							<div class="form-group">
								<label>Genres: <span id="bookGenres" style="color:blue"></span>
								</label> 
							</div>
								<div class="form-group">
								<label>Book By same Author: </label>
								<span id="bookBySameAuthor" style="color:blue"></span> 
							</div>
							
							<div class="form-group">
								<label>Book By same Publisher: </label>
								<span id="bookBySamePub" style="color:blue"></span> 
							</div>
							<div class="form-group">
								<label>Book By same Genre: </label>
								<span id="bookBySameGenre" style="color:blue"></span> 
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>