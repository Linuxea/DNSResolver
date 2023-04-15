package com.linuxea.dnsresolver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomDNSResolver implements DNSResolver {

  private final DNSResolver dnsResolver;
  private final Map<String, String> ip2DomainMap;

  public CustomDNSResolver(DNSResolver dnsResolver) {
    this.dnsResolver = dnsResolver;
    this.ip2DomainMap = new ConcurrentHashMap<>();
  }

  public void addCustomIP(String domain, String ip) {
    ip2DomainMap.put(domain, ip);
  }


  @Override
  public String resolve(String domain) {
    String custom = this.ip2DomainMap.get(domain);
    if (custom != null) {
      return custom;
    }
    return this.dnsResolver.resolve(domain);
  }

}
