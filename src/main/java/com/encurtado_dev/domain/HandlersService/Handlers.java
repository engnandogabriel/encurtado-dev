package com.encurtado_dev.domain.HandlersService;
import org.springframework.http.HttpStatus;

public class Handlers<T> {
    public HandlerDTO badRquest(Exception e) {
        return new HandlerDTO<String>(HttpStatus.BAD_REQUEST, "Bad Request", e.getMessage());
    }

    public HandlerDTO servrError(Exception e) {
        return new HandlerDTO<String>(HttpStatus.INTERNAL_SERVER_ERROR, "ServerError", "Internal Server Error: Please, try again later");
    }

    public HandlerDTO success(T obj) {
        return new HandlerDTO<T>(HttpStatus.OK, "Success", obj);
    }

    public HandlerDTO notFound(Exception e) {
        return new HandlerDTO<String>(HttpStatus.NOT_FOUND, "Not Found", e.getMessage());
    }
}