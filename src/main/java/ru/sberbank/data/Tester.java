package ru.sberbank.data;

public class Tester extends TeamMember{
    public Tester(int id, String firstName, String secondName) {
        super(id, firstName, secondName);
    }

    void checkTask(){
        Task task = this.getCurrentTask();
        task.isTested = true;
        this.setCurrentTask(task);
        this.setFree(true);
    }

}
