package com.alexferum.services;

import com.alexferum.model.NewsStall;
import com.alexferum.model.Product;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    public void serialize(NewsStall newsStall, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\JavaProjects\\MyNewsStall\\files\\" + filename + ".dat"))) {
            oos.writeObject(newsStall);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void JSONize(NewsStall newsStall, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        try {
            mapper.writeValue(new File("files\\" + filename + ".json"), newsStall);
        } catch (JsonGenerationException ex1) {
            ex1.printStackTrace();
        } catch (JsonMappingException ex2) {
            ex2.printStackTrace();
        } catch (IOException ex3) {
            ex3.printStackTrace();
        }

    }

    public NewsStall loadFromFile(String filename, String format) throws Exception {
        NewsStall newsStall = new NewsStall(new HashMap<Product, Integer>());
        byte value = -1;

        switch (format.hashCode()) {
            case 99223: {
                if (format.equals("dat")) {
                    value = 0;
                }
            }
            break;

            case 3271912: {
                if (format.equals("json")) {
                    value = 1;
                }
            }
            break;
        }

        switch (value) {
            case 0: {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files\\" + filename + ".dat"));
                    Throwable e1 = null;

                    try {
                        newsStall = (NewsStall) ois.readObject();
                    } catch (Throwable e2) {
                        e1 = e2;
                        throw e2;
                    } finally {
                        if (ois != null) {
                            if (e1 != null) {
                                try {
                                    ois.close();
                                } catch (Throwable e3) {
                                    e1.addSuppressed(e3);
                                }
                            } else {
                                ois.close();
                            }
                        }
                    }
                }
                catch (Exception e4) {
                    System.out.println(e4.getMessage());
                }
            }
            break;

            case 1: {
                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    newsStall = (NewsStall)(objectMapper.readValue(new FileInputStream("files\\" + filename + ".json"), NewsStall.class));
                }
                catch (JsonGenerationException e1) {
                    e1.printStackTrace();
                }
                catch (JsonMappingException e2) {
                    e2.printStackTrace();
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            break;
        }

        return newsStall;
    }
}