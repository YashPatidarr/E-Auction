<html>
   <head>
      <title>File Uploading Form</title>
   </head>
   
   <body>
      <h3>File Upload:</h3>
      <% 
      String prid =(String) request.getAttribute("pid");
      HttpSession hs = request. getSession(); 
      hs.setAttribute("pid" , prid);
      %>
      Select a file to upload for product <%=prid %> : <br />
      <form action = "UploadDest.jsp" method = "post"
         enctype = "multipart/form-data">
         <input type="hidden" name= "prid" value="<%=prid %>">
         <input type = "file" name = "file" size = "50" />
         
         
         
         <br />
         <input type = "submit" value = "Upload File" />
         
      </form>
   </body>
   
</html>