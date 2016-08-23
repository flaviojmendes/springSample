package es.flaviojmend.controller;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

/**
 * Created by flavio on 23/08/16.
 */
public class TestUtil {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );
}