package br.com.bandoni.lib;
public class MD5Factory
{
    static private final String ALGORITHM = "MD5";
    static public String md5(String s)
    {
      return HashFactory.doHash(s,ALGORITHM);
    }
}
