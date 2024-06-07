package org.example.model;

public class Affirmation {
    private String statement;
    private Statut statut;

    public Affirmation(String statement, Statut statut) {
        this.statement = statement;
        this.statut = statut;
    }

    public String getStatement() {
        return statement;
    }

    public Statut getStatut() {
        return statut;
    }
    
}