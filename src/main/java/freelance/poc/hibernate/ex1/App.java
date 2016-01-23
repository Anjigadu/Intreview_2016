package freelance.poc.hibernate.ex1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import freelance.poc.hibernate.ex1.entity.Address;
import freelance.poc.hibernate.ex1.entity.Employee;
import freelance.poc.hibernate.ex1.entity.Job;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Employee employee = new Employee();
		employee.setName("Chandan - 1");
		Address address = new Address("Awesome - Location", "Description of Location");
		employee.setAddress(address);
		
		List<Job> jobList = new ArrayList<Job>();
		Job job = new Job();
		job.setEndDate(new Date());
		job.setStDate(new Date());
		job.setOrganztion("1");
		jobList.add(job);
		
		job = new Job();
		job.setEndDate(new Date());
		job.setStDate(new Date());
		job.setOrganztion("2");
		jobList.add(job);
		
		job = new Job();
		job.setEndDate(new Date());
		job.setStDate(new Date());
		job.setOrganztion("3");
		jobList.add(job);
		
		employee.setJobList(jobList);
		
		em.persist(employee);
		em.getTransaction().commit();
		System.out.println("COMIITING : " + employee);

	}
}
