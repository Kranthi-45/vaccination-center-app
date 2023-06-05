This is the continuation of "springBoot-model-branch-demo" project

# Suppose if you get error in "pom.xml" while creating springBoot proj
   RightClick Proj -> Maven -> Update Project.. -> Tick Force Snapshots -> Submit

#1) BranchController.java under Controller

#2) WEB-INF/jsp folder --    create branch.jsp file

#3) application.properties -- suffix / prefix
   
    Run the program once, 
    check  branch page is working or not -->  URL http://localhost:8080/branch
    this  Error in console              ---> Path with "WEB-INF" or "META-INF": [WEB-INF/jspbranch] then "Add tomcat"
   
    
#4) Add "Tomcat" dependency    if same error occurs

#5) Branch.java under entity  -- there is byte[] pic varible of Base64.. So we need Base 64 Dependency see below

#6) Add " Appache Commons Codec " Base64 dependency (1.15 version)

#7) BranchDoa.java under dao and basepackage  
      - Write the code in BranchDao.java (copy from " springBoot-branch-demo " proj)

#8) Add "my-sql-connector" & "jstl" jar (javax.servlet)  or dependencies  & update project once

#9) Write the code in branch.jsp (jumbotron,heading,buttons) and check once

#10) i) Using ModelMap - write the code in controller to display table of records passing to .jsp file
      
       - Create the table in jsp file to display on webpage by using <c:forEach> & also add " @taglib jstl " directive to use it 

     ii) Using ModelAndView - write the code in controller to display table of records passing to .jsp file
     
 Finnaly run the application  URL : localhost:8080/branch    

#11) see next demo for add/modify/del methods below
------------------------------------------------------------------------------------------------------------------------------------------
In The "springBoot-model-addBranch-demo" Project
                                               URL : localhost:8080/branch 
 
 --> change <form> method="POST" action="/add"  & also 
      @PostMapping is written for add() method  in BranchController.java class
       
       O/P in Console : Branch [bid=2000, bname=Rama, bcity=Kamareddy, pic=null]                       (for developer purpose)
       O/P in browser : Error
       
 --> @ResponseBody used extra for above add()
        - to inform that this method does not return URL(/add) in browser, it returns value to be printed  in browser
 
       O/P in browser : {"bid":"2000","bname":"Rama","bcity":"Kamareddy","pic":null,"picture":null}     (for User purpose)
     
 --> @ResponseBody and along with dao class
       O/P in broweser  :  Yes
       Stores Data in DB :  Yes   
       
-->   Instead @ResponseBody use ModelAndView concept for above same purpose
------------------------------------------------------------------------------------------------------------------------------------------------

In the "springBoot-model-branch-demo" Project

--> Edit jsp file put add/modify/del buttons & use name="add"/modify/delete attribute for each submit for url mapping to specific method in controller class   

--> Use  @RequestMapping(method = RequestMethod.POST, value = "/branch", params = "delete" ) in controller for multiple submit buttons in webpage
    value = "/branch"  (the              <form> --> action="/branch" value)
    params = "add"     (the <input type=submit> --> name="add" value )
       
--> Run the program and add/modfy/del the records       
--------------------------------------------------------------------------------------------------------------------------------------------------
In this project demo we add extra column SELECT feature
       
--> add " select " in .jsp <forEach> table
  
--> changing <form> tags to <form:form>, <form:input> and add @taglib directive for form:form
 
--> Remove pic related getters & setters in Branch - entity
                                     and in BranchDao - dao also           else O/P error as :  Unreadable branch , getter and setters not matched       
                                     
-->  Set the Controller class
      with appropriate @GetMapping, @RequestMapping
      
--> Run the Program                                         