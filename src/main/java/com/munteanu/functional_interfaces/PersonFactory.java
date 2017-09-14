package com.munteanu.functional_interfaces;

import com.munteanu.model.Person;

/**
 * Created by romunteanu on 1/12/2016.
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
