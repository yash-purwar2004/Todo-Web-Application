package com.example.springBoot.TodoWebApplication.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity // So, now name of the table is TodoABC
public class Todo {
   @Id
   @GeneratedValue
    private int id;
    private String username;

    @Size(min=10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo(){

    }
    
    public Todo (int id, String username, String description, LocalDate targetDate, boolean done){
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

     public int getId(){
        return id;
     }

     public void setId(int id){
        this.id = id;
     }

     public String getusername(){
        return username;
     }

     public void setusername(String username){
        this.username = username;
     }

     public String getdescription(){
        return description;
     }

     public void setdescription(String description){
        this.description = description;
     }

     public LocalDate gettargetDate(){
        return targetDate;
     }

     public void settargetDate(LocalDate targetDate){
        this.targetDate = targetDate;
     }

     public boolean getdone(){
        return done;
     }

     public void setdone(boolean done){
        this.done = done;
     }
    
     @Override
     public String toString(){
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate=" + targetDate + ", done=" + done + "]";
     }

}


