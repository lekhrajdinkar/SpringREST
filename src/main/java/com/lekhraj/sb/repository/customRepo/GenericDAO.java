package com.lekhraj.sb.repository.customRepo;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDAO<T extends Serializable> extends AbstractDAO<T>{

}

// https://www.baeldung.com/simplifying-the-data-access-layer-with-spring-and-java-generics