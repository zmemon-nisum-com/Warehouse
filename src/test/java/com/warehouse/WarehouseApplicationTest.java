package com.warehouse;

import java.net.MalformedURLException;

import org.junit.BeforeClass;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
////@ContextConfiguration(classes = WebMvcConfig.class)
public abstract class WarehouseApplicationTest {

	@BeforeClass
    public static void setLogger() throws MalformedURLException
    {
        System.setProperty("log4j.configurationFile","log4j.properties");
    }
}
