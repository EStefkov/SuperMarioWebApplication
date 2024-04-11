package menaged_beans;



import dao.Database;
import entities.Message;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Contacts
{
		private String senderName;
		private String email;
		private String message;
	
		public String getSenderName() 
		{
				return senderName;
		}
	
		public void setSenderName(String senderName) 
		{
				this.senderName = senderName;
		}
	
		public String getEmail() 
		{
				return email;
		}
	
		public void setEmail(String email) 
		{
				this.email = email;
		}
	
		public String getMessage() 
		{
				return message;
		}
	
		public void setMessage(String message) 
		{
				this.message = message;
		}
	
		public String send()
		{	
				if(email.matches("^[a-zA-Z0-9]+[._]*+[a-zA-Z0-9]*+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$"))
				{
						// Създаване на ново съобщение
						Message msg = 
							new Message(senderName, email, message);
			
						// Добавяне на съобщението към базата данни
						Database.addMessage(msg);
				
						return "sent";
				}
				else
				{
						// При невалиден имейл, потребителя 
						// се връща към същата страница
						return "contacts";
				}
		}
}
