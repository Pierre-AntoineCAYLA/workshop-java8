package java8.ex02;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - java.util.function.BiFunction
 */
public class Function_02_Test {

    //  tag::buildAccount[]
    // TODO Compléter la fonction buildAccount
    // TODO la fonction possède 2 paramètres en entrée : une personne et un solde
    BiFunction<Person, Integer, Account> buildAccount = (person, entier)->{
    	Account account =new Account();
    account.setOwner(person);
    account.setBalance(entier);
	return account;
    };
    //  end::buildAccount[]

    @Test
    public void test_build_account() throws Exception {
    	Person john=new Person();
    	john.setFirstname("John");
    	john.setPassword("pass");
    	john.setLastname("France");
    	john.setAge(80);
        // TODO invoquer la fonction buildAccount pour que le test soit passant
        Account account = buildAccount.apply(john, 500);

        assertThat(account, hasProperty("balance", is(500)));
        assertThat(account.getOwner(), hasProperty("firstname", is("John")));
        assertThat(account.getOwner(), hasProperty("lastname", is("France")));
        assertThat(account.getOwner(), hasProperty("age", is(80)));
        assertThat(account.getOwner(), hasProperty("password", is("pass")));
    }


}
