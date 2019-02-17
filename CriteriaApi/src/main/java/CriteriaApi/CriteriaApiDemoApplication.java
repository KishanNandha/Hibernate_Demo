package CriteriaApi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import CriteriaApi.Entities.Student;
import CriteriaApi.Repositories.StudentRepo;

@SpringBootApplication
public class CriteriaApiDemoApplication implements CommandLineRunner{

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	private EntityManager getEntitiyManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	private CriteriaBuilder getCriteriaBuilder() {
		return entityManagerFactory.getCriteriaBuilder();
	}
	
	private Session getSession() {
		return entityManagerFactory.unwrap(SessionFactory.class).openSession();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CriteriaApiDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//oldHibernateCriteraiApi();
		//firstCriteriaQuery();
		//firstCriteriaQueryRefactored();
	}

	//Hibernate Criteria Query Language (OLD)
	private void oldHibernateCriteraiApi() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Student.class);
		Criterion criterion = Restrictions.eq("studentId", 1L);
		criteria.add(criterion);
		criteria.setProjection(Projections.property("name"));  
		System.out.println("Result: "+criteria.list().toString());
		session.close();
	}
	
	private void firstCriteriaQuery() {
		// get criteria builder 
		CriteriaBuilder criteriaBuilder =getCriteriaBuilder();
		
		//get criteria query object
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		
		// a Root instance is created to define a range variable in the FROM clause. 
		//it is used in FROM clause. Query roots always reference entities.
		Root<Student> root = criteriaQuery.from(Student.class);

		//selecting root
		criteriaQuery.select(root);
		
		//The ParameterExpression instance, p, is created to represent the query parameter. 
		 ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
		
		//creating where condition
		 //this equal excepts (expression,expression) so following will work
		 // criteriaQuery.where(criteriaBuilder.equal(root.get("name"),"rohit"));
		 criteriaQuery.where(criteriaBuilder.equal(root.get("name"),parameter));
		 
		//A CriteriaQuery instance is equivalent to a JPQL string and not to a TypedQuery instance.
		//Therefore, running the query still requires a TypedQuery instance:
		 TypedQuery<Student> typedQuery = getEntitiyManager().createQuery(criteriaQuery);
		 
		//set paramater value
		 typedQuery.setParameter(parameter, "rohit"); //no need to set it if already set.
		 
		 //get result
		 List<Student> resultStudentList = typedQuery.getResultList();
		 
	}
	
	private void firstCriteriaQueryRefactored() {
		
		//criteriaQuery object can be chained
	
		
		CriteriaQuery<Student> criteriaQuery = getCriteriaBuilder()
										.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		ParameterExpression<String> parameter = getCriteriaBuilder()
										.parameter(String.class);
		criteriaQuery.select(root)
					.where(getCriteriaBuilder().equal(root.get("name"), parameter));
		
		 List<Student> resultStudentList = getEntitiyManager()
				.createQuery(criteriaQuery) //gives typed query
				.setParameter(parameter, "rohit")
				.getResultList();
	}
}

