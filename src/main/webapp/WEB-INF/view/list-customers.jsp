<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" >
</head>
<body>
     <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
     </div>

     <div id="container">
        <div id="content">
            <!-- add out html table here -->
            <table>
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- loop over and print our customers -->
                    <c:forEach var="tempCustomer" items="${customers}">
                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
     </div>
</body>
</html>