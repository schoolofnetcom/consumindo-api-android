package com.schoolofnet.resource;

import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Session;

import com.schoolofnet.model.HibernateSession;
import com.schoolofnet.model.Person;

@Path("person")
public class PersonResource {

	private Session session = HibernateSession.getSession().openSession();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> findAll() {
		session.beginTransaction();
		
		List<Person> people = session.createQuery("from Person").getResultList();
		
		return people;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Person findOne(@PathParam("id") Integer id) {
		session.beginTransaction();
		
		Person p = session.find(Person.class, id);
		
		return p;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person create(Person person) {
		session.beginTransaction();
		
		Person newPerson = new Person(person.getName(), person.getTelephone());
		
		if (person.getLastname() != null) {
			newPerson.setLastname(person.getLastname());			
		}
		
		if (person.getEmail() != null) {
			newPerson.setEmail(person.getEmail());
		}

		if (person.getCompanyName() != null) {
			newPerson.setCompanyName(person.getCompanyName());
		}
		
		session.save(newPerson);
		
		session.getTransaction().commit();
		
		return newPerson;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Person edit(@PathParam("id") Integer id, Person person) {
		session.beginTransaction();
		
		Person personEdited = session.find(Person.class, id);
		
		if (person.getName() != null) {
			personEdited.setName(person.getName());			
		}
		
		if (person.getEmail() != null) {
			personEdited.setEmail(person.getEmail());
		}
		
		if (person.getCompanyName() != null) {
			personEdited.setCompanyName(person.getCompanyName());
		}
		
		if (person.getLastname() != null) {
			personEdited.setLastname(person.getLastname());
		}
		
		if (person.getTelephone() != null) {
			personEdited.setTelephone(person.getTelephone());
		}
		
		session.save(personEdited);
		
		session.getTransaction().commit();
		
		return personEdited;
	}
	
	@DELETE
	@Path("{id}")
	public Boolean delete(@PathParam("id") Integer id) {
		session.beginTransaction();
		
		Person p = session.find(Person.class, id);
		
		if (p == null) {
			return false;
		}
		
		session.delete(p);
		
		session.getTransaction().commit();
		
		return true;
	}
	
}
