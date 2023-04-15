package com.linuxea.dnsresolver;

/**
 * DNS resolver
 */
public interface DNSResolver {

  /**
   * resolve domain to ip
   *
   * @param domain domain
   * @return ip
   */
  String resolve(String domain);

}
