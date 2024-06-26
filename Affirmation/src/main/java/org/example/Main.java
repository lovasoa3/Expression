package org.example;
import model.Affirmation;
import model.Assertion;
import model.Conjonction;
import model.Statut;

public class Main {
  public static void main(String[] args) {
      Conjonction et = Conjonction.ET;
      Conjonction ou = Conjonction.OU;
      Conjonction donc = Conjonction.DONC;
      Assertion[] assertions = {
              new Assertion(louEstPauvre, et, louEstGenereux),
              new Assertion(louEstBeau, donc, louEstPauvre),
              new Assertion(louEstPauvre, donc, louEstGenereux),
              new Assertion(louEstBeau, ou, louEstGenereux),
              new Assertion(louEstBeau, ou, louEstGenereux, donc, louEstPauvre)
      };
      for (Assertion assertion : assertions) {
          System.out.println("L'affirmation \"" + assertion.getStatement() + "\" est : " + evaluerAssertion(assertion));
      }
  }
}
  
