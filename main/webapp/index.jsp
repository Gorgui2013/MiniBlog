<%@ include file="base_begin.jsp"%>
<div class="container-fluid bg-dark">
	<div class="col-lg-10 mx-auto">
		<nav
			class="navbar navbar-expand-lg sticky-top navbar-light bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="BlogListe.path">Blog J2EE</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="BlogListe.path"><i
								class="fas fa-home"></i> Accueil</a></li>
						<li class="nav-item"><a class="nav-link" href="Blog.path"><i
								class="fas fa-plus"></i> Ajouter</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container-fluid bg-white" style="height: 100vh">
			<div class="row">
				<c:choose>
					<c:when test="${ path.equals('/BlogListe.path') }">
						<%@ include file="BlogListe.jsp"%>
					</c:when>
					<c:when test="${ path.equals('/Blog.path') }">
						<%@ include file="Blog.jsp"%>
					</c:when>
					<c:otherwise>
						<%@ include file="BlogListe.jsp"%>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>
<%@ include file="base_end.jsp"%>