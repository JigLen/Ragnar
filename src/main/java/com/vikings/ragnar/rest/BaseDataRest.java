package com.vikings.ragnar.rest;

import com.vikings.ragnar.ejb.BaseDataService;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by carlmccann2 on 06/03/2017.
 *
 * https://examples.javacodegeeks.com/enterprise-java/rest/resteasy/resteasy-file-upload-example/
 *  Mine and davids code merged.
 */

/**
 * Created by C07589301 on 02/03/2017.
 */
@Path("/base_data")
public class BaseDataRest {

    @EJB
    BaseDataService baseDataService;

    // US 4
    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/us4/{id}")
    public Collection<?> searchErrorInfoBasedOnIMSI(@PathParam("id") Long id){
        return baseDataService.searchErrorInfoBasedOnIMSI(id);
    }

    // US 5
    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/us5/{imsi}/{d1}/{d2}")
    public Long getByIMSIAndTimePeriod(@PathParam("imsi") Long imsi, @PathParam("d1") String d1, @PathParam("d2") String d2 )throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = dt.parse(d1);
        Date date2 = dt.parse(d2);
        return baseDataService.getByIMSIAndTimePeriod(imsi, date1, date2);
    }

    // US 6
    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/us6/{imsi}")
    public Collection<?> getUniqueCauseCodes(@PathParam("imsi") Long imsi){
        return baseDataService.getUniqueCauseCodes(imsi);
    }

    // US 7
    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/us7/{d1}/{d2}")
    public  Collection<?> getAllIMSIByDate(@PathParam("d1") String d1, @PathParam("d2") String d2) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = dt.parse(d1);
        Date date2 = dt.parse(d2);
        return baseDataService.getAllIMSIByDate(date1,date2);
    }

    // US 8
    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/us8/{model}/{d1}/{d2}")
    public Collection<?> countNoOfCallFailuresForGivenModel(@PathParam("model") String model, @PathParam("d1") String d1, @PathParam("d2") String d2 )throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = dt.parse(d1);
        Date date2 = dt.parse(d2);
        return baseDataService.countNoOfCallFailuresForGivenModel(model, date1, date2);
    }

    // US 9
    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/us9/{d1}/{d2}")
    public Collection<?> countNoOfFailuresForImsi(@PathParam("d1") String d1, @PathParam("d2") String d2)throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = dt.parse(d1);
        Date date2 = dt.parse(d2);
        return baseDataService.countNoOfFailuresForImsi(date1, date2);
    }

    // US 10
    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/us10/{model}")
    public Collection<?> getAllUniqueCallFailuresForGivenModelOfPhone(@PathParam("model") String model)throws Exception {
        return baseDataService.getAllUniqueCallFailuresForGivenModelOfPhone(model);
    }

    // US 11
    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/us11/{d1}/{d2}")
    public Collection<?> getMostCommonMarketOperatorCellCombo(@PathParam("d1") String d1, @PathParam("d2") String d2) throws Exception{
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = dt.parse(d1);
        Date date2 = dt.parse(d2);
        return baseDataService.getTopTenMostCommonMarketOperatorCellCombo(date1, date2);
    }

    // US 12
    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/us12/{d1}/{d2}")
    public Collection<?> getTopTenMostCommonImsi(@PathParam("d1") String d1, @PathParam("d2") String d2) throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = dt.parse(d1);
        Date date2 = dt.parse(d2);
        return baseDataService.getTopTenMostCommonImsi(date1,date2);
    }

    //  US 14
    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/us14/{failureClass}")
    public Collection<?> getImsisByFailureClass(@PathParam("failureClass") Integer failureClass){
        return baseDataService.getImsisByFailureClass(failureClass);
    }

    // imsi combobox filler

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/getUniqueImsi")
    public Collection<?> getUniqueImsi(){ return  baseDataService.getUniqueImsiNumbers();}

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/getUniqueModels")
    public Collection<?> getUniqueModels(){ return  baseDataService.getUniqueModels();}

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/getUniqueFailureTypes")
    public Collection<?> getUniqueFailureTypes(){ return  baseDataService.getUniqueFailureTypes();}

    // file upload
    @POST @Path("/upload")@Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(MultipartFormDataInput input) throws IOException {
        // relative path not working
        String path = "res/incoming_data/";

        path = "D:\\Ragnar\\res\\incoming_data\\";
        String fileName = "";

        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        List<InputPart> inPart = formParts.get("file");

        for (InputPart inputPart : inPart) {

            try {
                // Retrieve headers, read the Content-Disposition header to obtain the original name of the file
                MultivaluedMap<String, String> headers = inputPart.getHeaders();
                fileName = parseFileName(headers);
                // Handle the body of that part with an InputStream
                InputStream istream = inputPart.getBody(InputStream.class,null);
                fileName = path + fileName;
                saveFile(istream,fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String output = "File saved to server location : " + fileName;
        return Response.status(200).entity(output).build();
    }

    // Parse Content-Disposition header to get the original file name
    private String parseFileName(MultivaluedMap<String, String> headers) {
        String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");
        for (String name : contentDispositionHeader) {
            if ((name.trim().startsWith("filename"))) {
                String[] tmp = name.split("=");
                String fileName = tmp[1].trim().replaceAll("\"","");
                return fileName;
            }
        }
        return "randomName";
    }

    // save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream, String serverLocation) {
        try {
            OutputStream outputStream;
            int read = 0;
            byte[] bytes = new byte[1024];

            outputStream = new FileOutputStream(new File(serverLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


