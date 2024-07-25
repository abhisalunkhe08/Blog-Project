<%@page import="java.util.List"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder"%>
<%@page import="javax.persistence.criteria.CriteriaQuery"%>
<%@page import="javax.persistence.criteria.Root"%>
<%@page import="com.blog.entity.Blogs"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
.card {
    border-radius: 30px
}
</style>
</head>
<body>
    <%@include file="navbar.jsp"%>

    <div class="container ">
        <h1 class="d-flex justify-content-center">Show Blogs</h1>
        
            <div class="col-7  p-4 m-4">
                <%
                Configuration cfg = null;
                SessionFactory factory = null;
                Session se = null;
                Transaction tx = null;
                try {
                    cfg = new Configuration().configure();
                    factory = cfg.buildSessionFactory();
                    se = factory.openSession();
                    tx = se.beginTransaction();

                    CriteriaBuilder cb = se.getCriteriaBuilder();
                    CriteriaQuery<Blogs> cq = cb.createQuery(Blogs.class);
                    Root<Blogs> root = cq.from(Blogs.class);
                    cq.select(root);

                    List<Blogs> list = se.createQuery(cq).getResultList();

                    for (Blogs blog : list) {
                %>

                <div class="card m-4 bg-dark text-white" style="width:68rem;">
                    <div class="card-body ">
                        
                        <h5 class="card-title d-flex justify-content-center"><%=blog.getTitle()%></h5>
                        <p class="card-text d-flex justify-content-center"><%=blog.getDesc()%></p>
                        <p class="card-text d-flex justify-content-center"><%=blog.getDate()%></p>
                        <a href="DeletServelt?id=<%=blog.getId()%>" class="btn btn-danger d-flex justify-content-center m-2">Delete</a>

                        <a href="UpdateBlogjsp.jsp?id=<%=blog.getId()%>" class="btn btn-primary d-flex justify-content-center m-2">update</a>
                    </div>
                </div>

                <%
                    }
                    tx.commit();
                } catch (Exception e) {
                    if (tx != null) tx.rollback();
                    e.printStackTrace();
                } finally {
                    if (session != null) se.close();
                    if (factory != null) factory.close();
                }
                %>
            </div>
        
    </div>

</body>
</html>
