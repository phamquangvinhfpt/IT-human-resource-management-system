<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="assets/css/newcss.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
            .row{
                background-color: #028ee1
            }
        </style>
    <body>
        <div class="container">
           
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editteam">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Team</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					

                                <div class="form-group">
                                    <label>IDTeam</label>
                                    <input value="${team.getID_Team()}" name="TeamID" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>TeamName</label>
                                    <input value="${team.getName_Team()}" name="TeamName" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>IDexperience</label>
                                    <input value="${team.getID_Experience()}" name="IDexperience" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <input value="${team.getDecription()}" name="Description" type="text" class="form-control" required>
                                </div>

                            </div>


                            <div class="modal-footer">
                                <a  class="btn btn-danger" href="teamcontroller">back</a>                          
                                <input type="submit" class="btn btn-success" value="Edit" name="txtEdit"/>
                            </div>
                        </form></div>
                </div>
            </div>
        </div>

    </div>


    <script src="js/manager.js" type="text/javascript"></script>
</body>
</html>