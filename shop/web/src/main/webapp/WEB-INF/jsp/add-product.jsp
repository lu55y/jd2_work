<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>

<form action="/web/product/add" method="post">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">Product Name</span>
  <input type="text" class="form-control" placeholder="product name" aria-label="product name" aria-describedby="productName">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon2">Description</span>
  <input type="text" class="form-control" placeholder="description" aria-label="description" aria-describedby="basic-addon1">
</div>
 <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>