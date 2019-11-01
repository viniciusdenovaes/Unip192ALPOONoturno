package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Aluno;
import model.Curso;

public class DaoHibernate {
	private SessionFactory factory;
	
	public DaoHibernate() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public boolean addAluno(Aluno aluno) {
		boolean result = true;
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			if(session.get(Aluno.class, aluno.getRa())!=null) {
				System.out.println("Aluno já existente");
				return false;
			}
			
			session.save(aluno);
			
			tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}
	
	public boolean addCurso(Curso curso) {
		boolean result = true;
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			if(session.get(Curso.class, curso.getNome())!=null) {
				System.out.println("Curso já existente");
				return false;
			}
			
			session.save(curso);
			
			tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}
	
	public List<Aluno> getAllAlunos() {
		List<Aluno> alunos = new ArrayList<>();
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			Query<Aluno> qAlunos = session.createQuery("FROM Aluno");
			
			for(Aluno qAluno : qAlunos.list()) {
				Set<Curso> cursos = new HashSet<>();
				for(Curso qCurso : qAluno.getCursos()) {
					cursos.add(new Curso(qCurso.getNome()));
				}
				Aluno aluno = new Aluno(qAluno.getRa(), qAluno.getNome());
				aluno.setCursos(cursos);
				alunos.add(aluno);
			}
			
		}catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return alunos;
	}
	

}
