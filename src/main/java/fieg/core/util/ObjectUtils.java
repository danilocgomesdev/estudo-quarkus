package com.estudo.core.util;

import java.util.Objects;

public final class ObjectUtils {

  /**
   * Faz a validacao de um objeto, caso nulo, retorna o valor do param passado, senao o proprio objeto.
   *
   * @param obj       objeto a ser validado.
   * @param elseValue valor para retorno caso obj nulo.
   * @param <T>       tipo do parametro a ser retornado.
   * @return valor nao nulo.
   */
  public static <T> T objectOrElse(T obj, T elseValue) {
    if (Objects.isNull(obj)) return elseValue;

    return obj;
  }
}
