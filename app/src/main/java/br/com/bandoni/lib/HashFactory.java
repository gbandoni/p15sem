package br.com.bandoni.lib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by gbandoni on 23/06/2016.
 */
public class HashFactory
{
    static public String doHash(String s,String Algorithm)
    {
        try
        {
            // carrega o algoritmo
            MessageDigest digest = java.security.MessageDigest.getInstance(Algorithm);
            digest.update(s.getBytes()); // efetua a conversao
            byte messageDigest[] = digest.digest(); // recebe o digest num vetor de byte

            // converte todos os bytes obtidos pelo digest em caracteres Hexadecimais
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            // so entrara aqui se o hardware ou a versao do android nao for capaz
            // de obter um digest para o algoritmo
            e.printStackTrace();
        }
        return "";
    }
}
