package com.baharmand.dao.sequencers;

public abstract class Sequencer {
    private static int currentId = 0;

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int newId) {
        currentId = newId;
    }
}
