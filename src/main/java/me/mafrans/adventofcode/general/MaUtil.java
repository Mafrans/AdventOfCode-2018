package me.mafrans.adventofcode.general;


import org.apache.commons.io.IOUtils;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class MaUtil {
    public static String getWebString(String surl) throws IOException {
        URL url = new URL(surl);
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String body = IOUtils.toString(in);


        return body;
    }
    public static String readResource(final String fileName, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(fileName), charset);
    }
}
