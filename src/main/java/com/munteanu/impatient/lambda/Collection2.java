package com.munteanu.impatient.lambda;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T> {

  default void forEachIf(Consumer<T> action, Predicate<T> filter) {
    forEach(t -> {
      if (filter.test(t)) action.accept(t);
    });
  }
}

