package com.uncleakamai.httpfun;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetPage
{
    public static void main(String[] Args) throws IOException
    {

        DefaultHttpClient httpclient = new DefaultHttpClient();

        //object that will be passed to the execute method of httpclient
        HttpGet httpGet = new HttpGet("http://www.disney.com");

        //return HttpResponse object to response1
        HttpResponse response1 = httpclient.execute(httpGet);

        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST either fully consume the response content  or abort request
        // execution by calling HttpGet#releaseConnection().

        try {
            System.out.println(response1.getStatusLine());
            System.out.println(response1.getAllHeaders());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity1);
        } finally {
            httpGet.releaseConnection();
        }

    }


}
