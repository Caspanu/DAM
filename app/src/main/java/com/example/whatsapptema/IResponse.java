package com.example.whatsapptema;

import java.util.List;

public interface IResponse {

    void onSuccess(List<Conversatie> conversatie);
    void onError(String mesaj);

}
