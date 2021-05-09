package com.lekhraj.sb.play;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class playRepo
{
	@Autowired
	SessionFactory sf;
	
	void play() {
		Session s = sf.openSession();
		s.beginTransaction();
		System.out.println(" timepass ");
		s.close();
	}
}
