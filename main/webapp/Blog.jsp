<div class="col-lg-10 mx-auto">
	<h4 class="mt-2 mb-2">
		<c:choose>
			<c:when test="${article.getIdArticle() != 0}">Modification
					</c:when>
			<c:otherwise>Ajout
					</c:otherwise>
		</c:choose>
		Article
	</h4>
	<hr>
	<div class="col-lg-8 mx-auto card card-body">

		<c:choose>
			<c:when test="${article.getIdArticle() != 0}">
				<form action="Blog.path?editArticle=${article.getIdArticle()}"
					method="post">
			</c:when>
			<c:otherwise>
				<form action="Blog.path" method="post">
			</c:otherwise>
		</c:choose>
		<div class="form-group">
			<input type="text" name="sujet" class="form-control mb-4"
				placeholder="Sujet" required value="${ article.getSujet() }">
		</div>
		<div class="form-group">
			<input type="text" name="message" class="form-control mb-4"
				placeholder="Message" required value="${ article.getMessage() }">
		</div>
		<div align="right">
			<c:choose>
				<c:when test="${article.getIdArticle() != 0}">
					<button type="submit" class="btn btn-primary">
						<i class="fas fa-save"></i> Enregistrer
					</button>
				</c:when>
				<c:otherwise>
					<button type="submit" class="btn btn-primary">
						<i class="fas fa-save"></i> Ajouter
					</button>
				</c:otherwise>
			</c:choose>
		</div>
		</form>
	</div>
</div>