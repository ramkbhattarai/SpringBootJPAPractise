package com.rkb.springBootStrater.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public List<Course> findByTopicId(int id);
	// here jpa will split the method name as follows
	// findBy + Topic + Id
	//(this is field in course class but its an object of other class so it will look for id field in Topic class)

	//public List<Course> findByName(String name); // we have to write the name of the method similar to jpa methods,
	// first is find then All Or By the name or Id(this should be the same name as the fields in model class). This is just an example on how to write the method name.

	
	// another example
	//public List<Course> findByDescription(String description);
}
