package ru.sberbank.data;

public class Task {
    public int id;
    public boolean isDeveloped;
    public boolean isTested;
    public String summary;

    public Task(int id, String summary) {
        this.id = id;
        this.isDeveloped = false;
        this.isTested = false;
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", isDeveloped=" + isDeveloped +
                ", summary='" + summary + '\'' +
                ", isTested=" + isTested + '\'' +
                '}';
    }

    public void setDeveloped(final boolean developed) {
        isDeveloped = developed;
    }
}