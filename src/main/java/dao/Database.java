package dao;

import java.util.ArrayList;

import entities.Message;

public class Database
{
		private static ArrayList<Message> messages = 
																new ArrayList<Message>();

		public static ArrayList<Message> getMessages() 
		{
				return messages;
		}
	
		public static void addMessage(Message msg)
		{
				messages.add(msg);
		}
}
