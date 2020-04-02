package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.HospitalDAO;
import dao.OfficialDAO;
import dao.PatientDAO;

import dao.TemporaryDAO;
import dao.Userdao;
import model.Admin;
import model.Hospital;
import model.Official;
import model.Patient;
import model.User;
import model.User2;
import model.UserProblem;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception 
	{
		
		
		
		System.out.println("Hello,welcome to health record System.");
		System.out.println("Please enter the details carefully"+"\n");
		Main.start();
	}
	public static void start() throws Exception
	{
		
		String choice="yes";
		
		while(choice.equalsIgnoreCase("yes"))
		{
			System.out.println("1.Enter ONE for Admin login");
			System.out.println("2.Enter TWO for Official login");
			System.out.println("3.Enter THREE for Hospital services");
			System.out.println("4.Enter FOUR for People servies");
			
			
			int n=Integer.parseInt(br.readLine());
			
			switch(n)
			{
			case 1 :  admin();
			          break;
				
				
			case 2 :  official();
				break;
				
				
			case 3 :  hospital();
			          break;
			case 4 : user();
			         break;
				
			
				
				
			default : System.out.println("sorry ,wrong input");
			          break;
			
			}
			System.out.println("1.Enter YES to continue in the same ");
			System.out.println("2.Enter NO to Exit");
			
			choice=br.readLine();
		
		}
	
	}
	
	//admn services 
	public static void admin() throws Exception
	{
		
		AdminController ac=new AdminController();
		System.out.println("Enter username");
		String uname=br.readLine();
		System.out.println("Enter password");
		String pass=br.readLine();
		Admin admin=new Admin(uname,pass);
	    boolean x=	ac.validate(admin);
	if(x)
	{
        String choice="yes";
		
		while(choice.equalsIgnoreCase("yes"))
		{
			System.out.println("1.Enter ONE for creating official");
			System.out.println("2.Enter TWO for updating official");
			System.out.println("3.Enter THREE for deleting official");
			System.out.println("4.Enter FOUR for reading official");
			System.out.println("5.Enter Five for to go back");
			
			OfficialDAO odao=new OfficialDAO();
			int n=Integer.parseInt(br.readLine());
			
			switch(n)
			{
			case 1 :System.out.print("enter id = ");
			        String id=  br.readLine();
			        System.out.print("\n"+"enter name = ");
			        String name=  br.readLine();
			       
			        System.out.print("\n"+"enter designation = ");
			        String designation=  br.readLine();
			        Official o=new Official(id,name,designation);
			       
				     odao.insertOfficial(o);
				     break;
				 
			case 2 :  System.out.print("enter id = ");
		              String id1=  br.readLine();
		              System.out.print("\n"+"enter name = ");
		              String name1=  br.readLine();
		       
		                System.out.print("\n"+"enter designation = ");
		             String designation1=  br.readLine();
		             
		             Official o1=new Official(id1,name1,designation1);
				       
				     odao.updateOfficial(o1);
				     break;
				     
				     
			case 3: 	System.out.println("Enter id to delete");
			            String id3=br.readLine();
			             odao.deleteOfficial(id3);
			             break;
			case 4 : //System.out.println("Enter id to serch");
			          //String id4=br.readLine();
			          odao.selectAllOfficial();
			          break;
			          
			case 5 :   start();
			           return;
			 default : System.out.println("You entered wrong input");
			           break;
			
			}
			System.out.println("Enter YES to continue");
			System.out.println("Enter BACK togo back");
			
			choice=br.readLine();
			if(choice.equalsIgnoreCase("back"))
				start();
			
		
	}
	}
	else
	{
		System.out.println("Sorry wrong inputs");
		System.out.println("1.Enter YES to continue in the same ");
		System.out.println("2.Enter BACK to go previous menu");
		
	
		String choice=br.readLine();
		
		if(choice.equalsIgnoreCase("yes"))
			start();
		
			
		
	}
}
	
	//official services
	
	public static void official() throws Exception
	{
		OfficialController oc=new OfficialController();
		if(oc.validate())
		{
			 String choice="yes";
			 TemporaryDAO tdao=new TemporaryDAO();
			 HospitalDAO hdao=new HospitalDAO();
				
				while(choice.equalsIgnoreCase("yes"))
				{
					System.out.println("1.Enter ONE for Hospital Registrations");
					System.out.println("2.Enter TWO for Hospital update");
					System.out.println("3.Enter THREE for hospital delete");
					System.out.println("4.Enter Four for user concerns");
					System.out.println("5.Enter Five to go back");
					
					
					
					
					int n=Integer.parseInt(br.readLine());
					
					switch(n)
					{
					
					case 1 : List<Hospital> list= tdao.readRegister();
					         for(Hospital h : list)
					         {
					        	 String id=h.getId(); 
					        	 String name=h.getName();
					        	 String password=h.getPassword();
					        	 String date=h.getEstablished();
					        	 System.out.println(id+"\t"+name+"\t"+password+"\t"+date);
					        	 System.out.println("Enter YES to approve"+"\t"+"Enter NO to reject"+"Enter HOLD to place in hold");
					        	 String a=br.readLine();
					        	 if(a.equalsIgnoreCase("YES"))
					        	 {
					        		 hdao.insertHospital(h);
					        		 tdao.deleteRegister(id);
					        		 
					        	 }
					        	 else if(a.equalsIgnoreCase("NO"))
					        	 {
					        		 tdao.deleteRegister(id);
					        	 }
					        	 
					        	 
					         }
					         break;
						
						
						
					case 2 :   List<Hospital> list1= tdao.readUpdate();
					           for(Hospital h : list1)
			                 {
					        	   String id=h.getId(); 
					        	   String name=h.getName();
					        	   String password=h.getPassword();
					        	   String date=h.getEstablished();
					        	   System.out.println(id+"\t"+name+"\t"+password+"\t"+date);
					        	   System.out.println("Enter YES to approve"+"\t"+"Enter NO to reject"+"Enter HOLD to place in hold");
					        	   String a=br.readLine();
					        	   if(a.equalsIgnoreCase("YES"))
					        	   {
					        		   hdao.updateHospital(h);
					        		   tdao.deleteUpdate(id);
			        		 
					        	   }
					        	   else if(a.equalsIgnoreCase("NO"))
					        	   {
			        		          tdao.deleteUpdate(id);
					        	   }
			        	 
			        	 
			                 }
					           break;
					
						
					case 3 :   List<String> list2= tdao.readDelete();
					 for(String id : list2)
	                 {
			        	   
			        	   
			        	   System.out.println(id);
			        	   System.out.println("Enter YES to approve"+"\t"+"Enter NO to reject"+"Enter HOLD to place in hold");
			        	   String a=br.readLine();
			        	   if(a.equalsIgnoreCase("YES"))
			        	   {
			        		   hdao.deleteHospital(id);
			        		   tdao.deleteDelete(id);
	        		 
			        	   }
			        	   else if(a.equalsIgnoreCase("NO"))
			        	   {
	        		          tdao.deleteDelete(id);
			        	   }
	        	 
	        	 
	                 }
			           break;
			           
					case 4 :  List<UserProblem> list6= tdao.readUserProblem();
			                  for(UserProblem h : list6)
			              {
			                	 String id=h.getId(); 
			                 	 String name=h.getMessage();
			        	      LocalDate date=h.getDate();
			        	    
			        	   System.out.println(id+"\t"+name+"\t"+date);
			        	 System.out.println("Enter YES to approve"+"\t"+"Enter NO to reject"+"Enter HOLD to place in hold");
			        	 String a=br.readLine();
			        	 if(a.equalsIgnoreCase("YES"))
			        	 {
			        		 tdao.deleteUserProblem(id);
			        		 
			        	 }
			        	 else if(a.equalsIgnoreCase("NO"))
			        	 {
			        		 tdao.deleteUserProblem(id);
			        	 }
			        	 
			        	 
			         }
			         break;  
					case 5 : start();
					         return;
			          
					
						
			default : System.out.println("Sorry,you entered wrong input");
					   break;
			
					}
					System.out.println("1.Enter YES to continue in the same ");
					System.out.println("2.Enter BACK to go previous menu");
					System.out.println("3.Enter ExIt to exit");
				
					choice=br.readLine();
					
					if(choice.equalsIgnoreCase("back"))
						start();
					
			
				}
		}
		else
		{
			System.out.println("Sorry wrong inputs");
			System.out.println("1.Enter YES to continue in the same ");
			System.out.println("2.Enter BACK to go previous menu");
			System.out.println("3.Enter ExIt to exit");
		
			String choice=br.readLine();
			
			if(choice.equalsIgnoreCase("back"))
				start();
			else if(choice.equalsIgnoreCase("yes"))
			   official();
		
		}
		}
	
	//hospital services
	
		public static void hospital() throws Exception
		
		{
			HospitalController hc=new HospitalController();
			
			String choice="yes";
			
			while(choice.equalsIgnoreCase("yes"))
			{
				System.out.println("1.Enter ONE for Register ");
				System.out.println("2.Enter TWO for Login");
				System.out.println("3.Enter THREE to go back");
				
				
				
				PatientDAO pdao=new PatientDAO(); 
				TemporaryDAO tdao=new TemporaryDAO();
				int n=Integer.parseInt(br.readLine());
				
				switch(n)
				{
				case 1 : System.out.println("Enter id");
				         String id=br.readLine();
				         System.out.println("Enter name");
				         String name=br.readLine();
				         System.out.println("Enter password");
				         String pass=br.readLine();
				         System.out.println("Enter established year");
				         String year=br.readLine();
				         
				         Hospital h=new Hospital(id,name,pass,year);
				         tdao.insertRegister(h);
				         break;
				         
				
		                  
				case 2 :  
					        if(hc.validate())  
					        	hospitalOperations();
					
					        break;
					        
				case 3 :  start();
				           return ;
				default :
					        System.out.println("Sorry,you entered wrong input");
					        break;
					
				
		
				}
				
				System.out.println("1.Enter YES to continue in the same ");
				System.out.println("2.Enter BACK to go previous menu");
				System.out.println("3.Enter ExIt to exit");
				
				choice=br.readLine();
				
				if(choice.equalsIgnoreCase("back"))
				start();
				}
	
		
			
				
							
			
		}	
		
		public static void hospitalOperations() throws Exception
		{
			HospitalController hc=new HospitalController();
			TemporaryDAO tdao=new TemporaryDAO();
			PatientDAO pdao=new PatientDAO(); 
            String choice="yes";
			
			while(choice.equalsIgnoreCase("yes"))
			{
			
			System.out.println("1.Enter ONE for Update");
			System.out.println("2.Enter TWO for Delete");
			System.out.println("3.Enter THREE for adding patient details ");
			System.out.println("4.Enter FOUR for updating patient details");
			System.out.println("5.Enter FIVE for read patient details");
			System.out.println("6.Enter SIX for delete patient details");
			System.out.println("7.Enter SEVEN to go back");
			
			int n=Integer.parseInt(br.readLine());
			switch(n)
			{
			
			
			case 1 :  
			      System.out.println("Enter id");
                String id1=br.readLine();
                System.out.println("Enter name");
                String name1=br.readLine();
                System.out.println("Enter password");
                String pass1=br.readLine();
                System.out.println("Enter established year");
                String year1=br.readLine();
       
                Hospital h1=new Hospital(id1,name1,pass1,year1);
                tdao.insertUpdate(h1);
                break; 
                
			case 2 :  System.out.println("Enter id");
						String id2=br.readLine();
						tdao.insertDelete(id2);
						break;
            
			case 3 :    System.out.println("Enter patien id");
						String id3=br.readLine();
						System.out.println("Enter patien name");
						String name3=br.readLine();
						System.out.println("Enter patient issue ");
						String issue=br.readLine();
						LocalDate date=LocalDate.now();
						Patient p=new Patient(id3,name3,issue,date);
						pdao.insertPatient(p);
						break;
	           
			case 4 :    System.out.println("Enter patien id");
     					String id4=br.readLine();
     					System.out.println("Enter patien name");
     					String name4=br.readLine();
     					System.out.println("Enter patient issue ");
     					String issue1=br.readLine();
     					LocalDate date1=LocalDate.now();
     					Patient p1=new Patient(id4,name4,issue1,date1);
     					pdao.updatePatient(p1);
     					break;     
	  
			case 5:   System.out.println("Enter id")  ;
	          		 String id5=br.readLine();
	          		 pdao.readPatient(id5);
	          		 break;
	          
			case 6 :   System.out.println("Enter id")  ;
             		  String id6=br.readLine(); 
             		 System.out.println("Enter issue")  ;
             		 String issue6=br.readLine();
             		 pdao.deletePatient(id6, issue6);
             		 break;
		       
			case 7 : hospital();
	         			return ;
		       
		       
			default : System.out.println("Sorry,you entered wrong input");
						break;
	        
			
			}
			System.out.println("1.Enter YES to continue in the same ");
			System.out.println("2.Enter BACK to go previous menu");
			System.out.println("3.Enter ExIt to exit");
			
			choice=br.readLine();
			
			if(choice.equalsIgnoreCase("back"))
			hospital();
			
			}  
			
		}
		
		//user services
		
		public static void  user() throws Exception
		{
           String choice="yes";
           Userdao udao=new Userdao();
           UserController uc= new UserController();
			
			while(choice.equalsIgnoreCase("yes"))
			{
				System.out.println("1.Enter ONE for Register ");
				System.out.println("2.Enter TWO for Login");
				System.out.println("3.Enter Three for login");
				
				int n=Integer.parseInt(br.readLine());
				switch(n)
				{
				case 1 : System.out.println("Enter your id");
				         String id=br.readLine();
				         System.out.println("Enter your name");
				          String name=br.readLine();
				         System.out.println("Enter your mobile");
				         String mobile=br.readLine();
				         System.out.println("Enter your password");
				         String password=br.readLine();
				         User user=new User(id,name,mobile,password);
				         udao.insertUser(user);
				         break;
				         
				case 2 :System.out.println("enter id and password");
		                 String username=br.readLine();
		                 String password1=br.readLine();
		                 User2 u=new  User2(username,password1);
		                 
		          
					if(uc.validate(u)) 
					     useroperations(username);
					     break;
					     
				case 3 : start();
				          return;
				          
					     
				default : System.out.println("sorry ,wrong input");  
	            break;	     
					     
			
				}
				System.out.println("1.Enter YES to continue in the same ");
				System.out.println("2.Enter BACK to go previous menu");
				System.out.println("3.Enter ExIt to exit");
				
				choice=br.readLine();
				if(choice.equalsIgnoreCase("back"))
					start();
				
		    }
		}
		public static void useroperations(String id) throws Exception
		{
			PatientDAO pdao=new PatientDAO();
			TemporaryDAO tdao=new TemporaryDAO();
			Userdao udao=new Userdao();
			 String choice="yes";
			 while(choice.equalsIgnoreCase("yes"))
				{
					System.out.println("1.Enter ONE for read health details ");
					System.out.println("2.Enter TWO for update account");
					System.out.println("3.Enter THREE for delete account");
					System.out.println("4.Enter Four to contact official");
					System.out.println("5.Enter Five to go back");
					
					
					int n=Integer.parseInt(br.readLine());
					switch(n)
					{ 
					
					case 1 :  pdao.readPatient(id);
					           break;
					           
					case 2 :  System.out.println("Enter name");
					          String name= br.readLine();
					          System.out.println("Enter password");
					          String pass=br.readLine();
					          System.out.println("Enter your mobile");
					          String mobile=br.readLine();
					          
					          User user=new User(id,name,mobile,pass);
					          udao.updateUser(user);
					          break;
					          
					case 3 :  udao.deleteUser(id);   
					            break;
					case 4 :   System.out.println("Enter Your concern");
					            String message=br.readLine();
					            LocalDate date=LocalDate.now();
					            UserProblem userproblem=new UserProblem(id,message,date);
					            tdao.insertUserProblem(userproblem);
					            break;
					            
					case 5 :   user();
					            break;
					            
					            
					 default : System.out.println("sorry ,wrong input");  
					            break;
					            
						
					}
					System.out.println("1.Enter YES to continue in the same ");
					System.out.println("2.Enter BACK to go previous menu");
					System.out.println("3.Enter ExIt to exit");
					
					choice=br.readLine();
					if(choice.equalsIgnoreCase("back"))
						user();
					
			
		}
		}
		
}
