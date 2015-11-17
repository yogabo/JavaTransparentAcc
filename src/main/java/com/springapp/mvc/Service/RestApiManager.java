package com.springapp.mvc.Service;

import sun.management.FileSystem;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by sytensky on 15/11/15.
 */
public class RestApiManager {

    static String baseURL = "https://www.csas.cz/webapi/api/v1/transparentAccounts/accounts";

    /**
     * @return
     */
    public static String getAllTransAcc() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(baseURL)
                .request()
                .header("WEB-API-key", "9fe868a3-8116-4ca5-befa-572d302a38e2")
                .get();
        return response.readEntity(String.class);
    }

    /**
     * @return
     */
    public static String getDetailAcc(String accNum) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(baseURL +"/"+ accNum )
                .request()
                .header("WEB-API-key", "9fe868a3-8116-4ca5-befa-572d302a38e2")
                .get();
        return response.readEntity(String.class);
    }

    public static String readFile(String path, Charset encoding) {


        try {
            File file = new File("/Users/sytensky/KB/Repo/JavaTransparentAcc/src/main/webapp/resources/accounts.json");

//            String text = org.apache.commons.io.IOUtils.toString(RestApiManager.class.getResourceAsStream("accounts.json"));
//            URL url = com.google.common.io.Resources.getr
//            File file = new File("resources/accounts.json");
            java.nio.file.Path path3 = file.toPath();
            byte[] encoded = Files.readAllBytes(path3);

//                    file.toPath()
            Path path1 = FileSystems.getDefault().getPath("resources/accounts.json");
//            java.io.Path path3 = Paths.get("dwedw");
//            byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            return new String(encoded, encoding);
        } catch (IOException ex) {

            System.out.println(ex);
        }
        return "";
    }
}