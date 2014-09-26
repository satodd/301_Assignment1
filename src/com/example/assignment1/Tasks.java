package com.example.assignment1;

public class Tasks {

	public String todo;
	public boolean complete = false;
	public boolean selected = false;

	
	public void set_text(String text) {
		//set to-do text
		this.todo = text;
	}
	public void set_complete(){
		this.complete = true;
	}
	public void select(){
		this.selected = true;
	}
	public void deselect(){
		this.selected = false;
	}
	
	public void completed(){
		if (this.complete == true){
			complete = false;
		} else {
			complete = true;
		}				
	}
	
	public String getTodo(){
		return todo;
	}
	
	public static void serialize() {
		//will get file, decode message into string and completed task
	}
	
}
