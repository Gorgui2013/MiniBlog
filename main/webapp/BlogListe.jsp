<div class="col-lg-10 mx-auto">
	<h4 class="mt-2 mb-2">
		Liste Articles |<span style="font-size: 12px"> <strong>ID SESSION
				: </strong>${id} ; <strong>NB SESSION
				: </strong>${nb};
		</span>
	</h4>
	<hr>
	<c:if test="${not empty alert }">
		<div class="alert alert-success mb-4">${ alert }</div>
	</c:if>
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>Sujet</th>
				<th>Message</th>
				<th>@Ip</th>
				<th>Options</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articles}" var="article">
				<tr>
					<td>${article.getIdArticle()}</td>
					<td>${article.getSujet()}</td>
					<td>${article.getMessage()}</td>
					<td>${article.getIp()}</td>
					<td><a href="Blog.path?editArticle=${article.getIdArticle()}"
						class="btn btn-sm btn-primary"><i class="fas fa-eye"></i>
							Afficher</a> <a
						href="BlogListe.path?deleteArticle=${article.getIdArticle()}"
						class="btn btn-sm btn-danger"
						onclick="return confirm('Voulez-vous vraiment supprimer cette article ?')"><i
							class="fas fa-trash"></i> Supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>