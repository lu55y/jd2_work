<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>


    <h1>Please, take a look our promo!</h1>

    <!-- Promo list -->

    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Promo code</th>
          <th scope="col">Description</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${promoList}" var="promoItem">
        <tr>
          <th scope="row">#</th>
          <td>${promoItem.promoId}</td>
          <td>${promoItem.description}</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
<jsp:include page="footer.jsp"/>
