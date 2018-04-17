package java8.ex01;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		public default int sumAge() {
			int sum = 0;

			for (int i = 0; i < findAll().size(); i++) {
				sum = sum + findAll().get(i).getAge();
			}
			return sum;
		}

	}

	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

	class DaoB implements IDao {

		List<Person> people = Data.buildPersonList(100);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

	@Test
	public void test_daoA_sumAge() throws Exception {

		DaoA daoA = new DaoA();

		int result = 0;
		result = daoA.sumAge();
		assertThat(result, is(210));
	}

	@Test
	public void test_daoB_sumAge() throws Exception {

		DaoB daoB = new DaoB();

		int result = 0;
		result = daoB.sumAge();
		assertThat(result, is(5050));

	}
}
