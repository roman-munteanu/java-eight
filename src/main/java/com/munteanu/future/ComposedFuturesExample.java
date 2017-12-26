package com.munteanu.future;

import com.jasongoodwin.monads.Futures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ComposedFuturesExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    List<String> articles = Arrays.asList("<DOCTYPE html><html><body><p>text 1</p></body></html>",
      "<DOCTYPE html><html><body><h1>text 2</h1></body></html>");

    List<CompletableFuture<String>> futures = articles
        .stream()
        .map(html -> CompletableFuture.supplyAsync(() -> ArticleParser.apply(html)))
        .collect(Collectors.toList());

    Future<List<String>> futureArticles = Futures.sequence(futures);
    List<String> textList = futureArticles.get();
    System.out.println(textList);
  }

  static class ArticleParser {
    static String apply(String html) {
      return html.replaceAll("\\<.*?\\>", "");
    }
  }
}
