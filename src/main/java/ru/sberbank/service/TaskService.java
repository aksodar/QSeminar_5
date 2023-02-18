package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    private ArrayList<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    public void createTask(int id, String summary) throws IllegalAccessException {
        if(summary == null || summary.isEmpty()){
            throw new IllegalAccessException("Входные данные не валидны");
        }
        tasks.add(new Task(id, summary));
    }

    public Task getTask(String summary) throws IllegalAccessException {
        for (Task n: tasks) {
            if(summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        throw new IllegalAccessException("Задачи не найдены");
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: tasks) {
            if(!n.isDeveloped) {
                list.add(n);
            }
        }
        return list;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}