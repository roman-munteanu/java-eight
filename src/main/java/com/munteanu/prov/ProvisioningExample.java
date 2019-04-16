package com.munteanu.prov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

class MerchantDetails {
  public String name;

  public MerchantDetails(String name) {
    this.name = name;
  }
}

class AccountDetails {
  public String name;

  public AccountDetails(String name) {
    this.name = name;
  }
}

public class ProvisioningExample {

  private static Map<String, List<Object>> contextMap = new HashMap<>();

  public static <T> List<T> getDetails(String key, Function<Object, T> func) {
    List<T> result = new ArrayList<>();

    for (Object obj : contextMap.get(key)) {
      result.add(func.apply(obj));
    }

    return result;
  }

  public static void main(String[] args) {
    contextMap.put("merchant", Arrays.asList(new MerchantDetails("m1"), new MerchantDetails("m2")));
    contextMap.put("account", Arrays.asList(new AccountDetails("a1")));

    List<MerchantDetails> merchantDetails = getDetails("__", x -> (MerchantDetails) x);
    System.out.println(merchantDetails.size());

    List<AccountDetails> accountDetails = getDetails("account", x -> (AccountDetails) x);
    System.out.println(accountDetails.size());
  }
}
