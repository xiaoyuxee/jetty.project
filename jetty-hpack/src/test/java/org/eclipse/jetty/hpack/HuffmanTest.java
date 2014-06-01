package org.eclipse.jetty.hpack;

import org.junit.Assert;

import org.eclipse.jetty.util.TypeUtil;
import org.junit.Test;

public class HuffmanTest
{

    String[][] tests =
        {
            {"D.4.1","e7cf9bebe89b6fb16fa9b6ff","www.example.com"},
            {"D.4.2","b9b9949556bf","no-cache"},
            {"D.4.3k","571c5cdb737b2faf","custom-key"},
            {"D.4.3v","571c5cdb73724d9c57","custom-value"},
            {"D.6.1d","d6dbb29884de2a718805062098513109b56ba3","Mon, 21 Oct 2013 20:13:21 GMT"},
            {"D.6.1l","adcebf198e7e7cf9bebe89b6fb16fa9b6f","https://www.example.com"},
            {"D.6.2te","abdd97ff","gzip"},
            {"D.4.2cookie","e0d6cf9f6e8f9fd3e5f6fa76fefd3c7edf9eff1f2f0f3cfe9f6fcf7f8f879f61ad4f4cc9a973a2200ec3725e18b1b74e3f","foo=ASDJKHQKBZXOQWEOPIUAXQWEOIU; max-age=3600; version=1"},
            {"D.6.2date","d6dbb29884de2a718805062098513111b56ba3","Mon, 21 Oct 2013 20:13:22 GMT"},
        };
    
    @Test
    public void testDecode() throws Exception
    {
        for (String[] test:tests)
        {
            byte[] encoded=TypeUtil.fromHexString(test[1]);
            byte[] decoded=Huffman.decode(encoded);

            String d=new String(decoded);
            Assert.assertEquals(test[0],test[2],d);
        }
        
    }
}
