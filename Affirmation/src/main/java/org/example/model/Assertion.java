package org.example.model;

public class Assertion {
    private Affirmation[] affirmations;
    private Conjonction[] conjonctions;

    public Assertion(Affirmation... affirmations) {
        this.affirmations = affirmations;
        this.conjonctions = new Conjonction[affirmations.length - 1];
    }

    public Assertion(Affirmation[] affirmations, Conjonction[] conjonctions) {
        this.affirmations = affirmations;
        this.conjonctions = conjonctions;
    }

    public Affirmation[] getAffirmations() {
        return affirmations;
    }

    public Conjonction[] getConjonctions() {
        return conjonctions;
    }

    public String evaluer() {
        boolean affirmationsSontVraies = verifierAffirmations();
        if (!affirmationsSontVraies) {
            return "faux";
        }
        boolean conjonctionsSontVraies = verifierConjonctions();
        return conjonctionsSontVraies ? "vrai" : "faux";
    }

    private boolean verifierAffirmations() {
        for (Affirmation affirmation : affirmations) {
            if (affirmation.getStatut() != Statut.VERITE) {
                return false;
            }
        }
        return true;
    }

    private boolean verifierConjonctions() {
        for (int i = 0; i < conjonctions.length - 1; i++) {
            switch (conjonctions[i]) {
                case ET:
                    if (!affirmations[i].getStatement().equals(affirmations[i + 1].getStatement())) {
                        return false;
                    }
                    break;
                case OU:
                    if (affirmations[i].getStatement().equals(affirmations[i + 1].getStatement())) {
                        return true;
                    }
                    break;
                case DONC:
                    if (affirmations[i].getStatement().equals(affirmations[i + 1].getStatement())) {
                        return false;
                    }
                    break;
                default:
                    return false; // Si une conjonction non prise en charge est rencontrée, retourner faux
            }
        }
        return true;
    }
}
