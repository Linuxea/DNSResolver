package com.linuxea.dnsresolver;


import org.junit.Assert;
import org.junit.Test;

public class DNSResolverTest {

  @Test
  public void testJavaDNSResolver() {
    JavaDNSResolver javaDnsResolver = new JavaDNSResolver();
    String resolve = javaDnsResolver.resolve("www.baidu.com");
    System.out.println(resolve);
    Assert.assertNotEquals(resolve, null);
  }

  @Test
  public void testCustomDNSResolver() {
    JavaDNSResolver javaDnsResolver = new JavaDNSResolver();
    CustomDNSResolver customDnsResolver = new CustomDNSResolver(javaDnsResolver);
    customDnsResolver.addCustomIP("web", "192.168.1.100");
    customDnsResolver.addCustomIP("db", "192.168.1.101");

    String webDNSResolve = customDnsResolver.resolve("web");
    System.out.println(webDNSResolve);
    Assert.assertEquals(webDNSResolve, "192.168.1.100");

    String dbDNSResolve = customDnsResolver.resolve("db");
    System.out.println(dbDNSResolve);
    Assert.assertEquals(dbDNSResolve, "192.168.1.101");

    String resolve = javaDnsResolver.resolve("www.baidu.com");
    System.out.println(resolve);
    Assert.assertNotEquals(resolve, null);
  }

}