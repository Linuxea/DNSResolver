package com.linuxea.dnsresolver;

public class JavaDNSResolver implements DNSResolver {

  @Override
  public String resolve(String domain) {
    try {
      return java.net.InetAddress.getByName(domain).getHostAddress();
    } catch (java.net.UnknownHostException e) {
      return null;
    }
  }

}
