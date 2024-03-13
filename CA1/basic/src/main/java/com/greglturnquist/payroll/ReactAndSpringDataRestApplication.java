/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Properties;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@SpringBootApplication
public class ReactAndSpringDataRestApplication {

    public static void main(String[] args) {
        try {
            String configFilePath = "src/config.properties";
            FileInputStream propsInput = new FileInputStream("C:\\temp\\devops-23-24-JPE-PSM-1231828\\CA1\\basic\\src\\main\\java\\com\\greglturnquist\\payroll\\config.properties");
            Properties prop = new Properties();
            prop.load(propsInput);
            System.out.println(prop.getProperty("DB_USER"));
            SpringApplication.run(ReactAndSpringDataRestApplication.class, args);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// end::code[]