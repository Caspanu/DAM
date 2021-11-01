package com.example.whatsapptema;

public class Conversatie {
    private String nume;
    private String mesaj;
    private String data;

    public Conversatie(String nume, String mesaj, String data) {
        this.nume = nume;
        this.mesaj = mesaj;
        this.data = data;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Conversatie{" +
                "nume='" + nume + '\'' +
                ", mesaj='" + mesaj + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
