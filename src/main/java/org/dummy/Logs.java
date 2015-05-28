package org.dummy;


import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.commons.io.filefilter.RegexFileFilter;

public class Logs implements Serializable {

    private final String gMaquinas;
    private final String nombreMaquina;
    private final String dominio;
    private final String ipCliente;
    private final String nosequees1;
    private final String usuario;
    private final String fecha; //[02/Mar/2015:00:00:19 +0100]
    private final String metodo_request; //"GET /oviedo/20080901/cuencas/integracion-pola-20080901.html HTTP/1.1"
    private final String estado; //301
    private final String bytes;
    private final String referer;
    private final String user_agent; // "Mozilla/5.0 (compatible; SemrushBot/0.98~bl; +http://www.semrush.com/bot.html)"
    private final String tiempoEjecucion;
    private final String noseque2;

    public Logs(String linea) {

        String reg = "(\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) \\[([^:]+):(\\d+:\\d+:\\d+) ([^\\]]+)\\] \\\"(\\S+) (.*?) (\\S+)\\\" (\\S+) (\\S+) (\\\".*?\\\") (\\\".*?\\\") (\\d) (\\S+)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matches = pattern.matcher(linea);
        if (matches.find())
        {
            this.gMaquinas = matches.group(1);
            this.nombreMaquina = matches.group(2);
            this.dominio = matches.group(3);
            this.ipCliente = matches.group(4);
            this.nosequees1 = matches.group(5);
            this.usuario = matches.group(6);
            this.fecha = matches.group(7);
            this.metodo_request = matches.group(8);
            this.estado = matches.group(9);
            this.bytes = matches.group(10);
            this.referer = matches.group(11);
            this.user_agent = matches.group(12);
            this.tiempoEjecucion = matches.group(13);
            this.noseque2 = matches.group(14);

        }else{
            this.gMaquinas = "error";
            this.nombreMaquina = "error";
            this.dominio = "error";
            this.ipCliente = "error";
            this.nosequees1 = "error";
            this.usuario = "error";
            this.fecha = "error";
            this.metodo_request = "error";
            this.estado = "error";
            this.bytes = "error";
            this.referer = "error";
            this.user_agent = "error";
            this.tiempoEjecucion = "error";
            this.noseque2 = "error";
            System.out.println("ERROR");
        }

    }

    public String getgMaquinas() {
        return gMaquinas;
    }

    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public String getDominio() {
        return dominio;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public String getNosequees1() {
        return nosequees1;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMetodo_request() {
        return metodo_request;
    }

    public String getEstado() {
        return estado;
    }

    public String getBytes() {
        return bytes;
    }

    public String getReferer() {
        return referer;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public String getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public String getNoseque2() {
        return noseque2;
    }


}
