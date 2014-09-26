package com.example.assignment1;

import java.util.ArrayList;
import java.util.List;

public class TaskList{

	public List<Tasks> Task_List = new ArrayList<Tasks>();
	
	public void add_new(String new_text, int position){
		//add new tasks to the list 
		Tasks NewTask = new Tasks();
		
		//initializes new task
		NewTask.set_text(new_text);
		//NewTask.set_complete();
		int i = Task_List.size();
		if (Task_List.size() < position){
			while (position > Task_List.size()){
				Task_List.add(null);
			}
		}
		
		Task_List.add(position, NewTask);
		System.out.print("hold");
		//return Task_List;
	}
	
//	public void add(String new_text){
//		//add new tasks to the list 
//		Tasks NewTask = new Tasks();
//		
//		//initializes new task
//		NewTask.set_text(new_text);
//		NewTask.set_complete();
//				
//		Task_List.add(NewTask);
//	}
	
	private void ensureCapacity(int position) {
		// TODO Auto-generated method stub
	}

	public String[] List_To_Array(){
		String[] array = new String[Task_List.size()];
		for (int i = 0; i < Task_List.size(); i++) {
			array[i] = Task_List.get(i).getTodo();
			
		}
		System.out.print("hold");
		return array;
	}
	
	public int length(){
		return Task_List.size();
	}
	
	public boolean Select(int index){
		//looks in list, if item is selected, if it is, turns to false, if not turns to true
		if (this.get(index).selected == true){
			this.get(index).selected = false;
			return true;
			}
		else {
			this.get(index).selected = true;
			return false;
		}
	}
	
	private Tasks get(int index){
		Tasks task = Task_List.get(index);
		return task;
	}
	
	public void remove(int position){
		//remove single item from selected list
		Task_List.remove(position);
		System.out.print("hold");
	}
	
	public void delete(ArrayList Selected){
		//remove tasks selected from main list
		Task_List.removeAll(Selected);
		
	}
	public void email(){
		//email checked todo's
	}
	public void stats(){
		//print out statistics
	}
	public void filter(){
		//filters out completed/not completed todo's
	}
		
}
