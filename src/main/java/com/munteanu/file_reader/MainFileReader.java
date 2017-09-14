package com.munteanu.file_reader;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by romunteanu on 1/13/2016.
 */
public class MainFileReader {
    private static ClassLoader classLoader;

    public MainFileReader() {
        classLoader = this.getClass().getClassLoader();
    }

    public static void main(String[] args) {

        String fileName = "test-data.csv";
//        MainFileReader mainFileReader = new MainFileReader();
//        URL url = mainFileReader.classLoader.getResource(fileName);
        final URL url = MainFileReader.class.getClassLoader().getResource(fileName);

//        readWithBufferedReader(url);
        System.out.println("-----------------------");
//        readWithUnbufferedStreams(url);
        System.out.println("-----------------------");
//        readWithScanner(url);
        System.out.println("-----------------------");
        readWithFilesJDK8(url);
    }

    private static void readWithBufferedReader(URL url) {
        Charset charset = Charset.forName("UTF-8");
        try {
            Path path = Paths.get(url.toURI());
            BufferedReader br = Files.newBufferedReader(path, charset);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void readWithUnbufferedStreams(URL url) {
        try {
            Path path = Paths.get(url.toURI());
            InputStream in = Files.newInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readWithScanner(URL url) {
        StringBuilder sb = new StringBuilder();
        File file = new File(url.getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    private static void readWithFilesJDK8(URL url) {
        try {
            Path path = Paths.get(url.toURI());
            Files.lines(path, StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
