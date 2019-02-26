package ru.hh.todo.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

@Path("/")
public class FrontResource {
    String path = "src/main/resources/vanillajs/";

    @GET
//    @Produces({ MediaType.TEXT_HTML })
    @Path("/")
    public FileInputStream getHtml() {
        File html = new File(path + "index.html");
        try {
            return new FileInputStream(html);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/node_modules/todomvc-app-css/index.css")
    public FileInputStream getIndexCss() {
        try {
            return new FileInputStream(new File(path + "node_modules/todomvc-app-css/index.css"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/node_modules/todomvc-common/base.css")
    public FileInputStream getBaseCss() {
        try {
            return new FileInputStream(new File(path + "node_modules/todomvc-common/base.css"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/node_modules/todomvc-common/base.js")
    public FileInputStream getBaseJs() {
        try {
            return new FileInputStream(new File(path + "node_modules/todomvc-common/base.js"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/dist/bundle.js")
    public FileInputStream getBundleJs() {
        try {
            return new FileInputStream(new File(path + "dist/bundle.js"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/js/{script}")
    public FileInputStream getScript(@PathParam("script") String script) {
        try {
            return new FileInputStream(new File(path + "js/" + script));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
