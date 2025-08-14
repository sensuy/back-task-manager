package com.sensui.taskmanager.exception;

public abstract class TaskManagerException extends RuntimeException {

    public TaskManagerException() {
        super();
    }

    public TaskManagerException(String message) {
        super(message);
    }

    public TaskManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskManagerException(Throwable cause) {
        super(cause);
    }

    protected TaskManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
